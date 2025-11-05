package Irrgarten;

import java.util.ArrayList;
/**
 *
 * @author aaron
 */
public class Labyrinth {
    private static final char BLOCK_CHAR = 'X';
    private static final char EMPTY_CHAR = '-';
    private static final char MONSTER_CHAR = 'M';
    private static final char COMBAT_CHAR = 'C';
    private static final char EXIT_CHAR = 'E';
    private static final int ROW = 0;
    private static final int COL = 1;
    
    private final int nRows;
    private final int nCols;
    private final int exitRow;
    private final int exitCol;
    
    private Monster[][] monster_pos;
    private Player[][] player_pos;
    private char[][] grid;
    
    public Labyrinth(int _nRows, int _nCols, int _exitRow, int _exitCol) {
        nRows = _nRows;
        nCols = _nCols;
        exitRow = _exitRow;
        exitCol = _exitCol;
        
        // creacion de las matrices de player, monster y laberinto
        grid = new char[nRows][nCols];
        monster_pos = new Monster[nRows][nCols];
        player_pos = new Player[nRows][nCols];
        
        // Inicializacion del laberinto
        for(int i = 0; i < nRows; ++i){
            for(int j = 0; j < nCols; ++j)
                grid[i][j] = EMPTY_CHAR;
        }
        grid[exitRow][exitCol] = EXIT_CHAR;
    }

    public void spreadPlayers(Player[] players) { 
        for(Player player : players){
            int[] pos = randomEmptyPos();
            Monster monster = putPlayer2D(-1,-1,pos[ROW],pos[COL],player);
        }
    }

    public boolean haveAWinner() { 
        boolean winner = false;
        
        for(int i = 0; i < nRows; i++){
            
            for(int j = 0; j < nCols; j++){
                
                Player player = player_pos[i][j];
                
                if(player != null && player.getRow() == exitRow && player.getCol() == exitCol)
                    winner = true;
            }
        }
        
        return winner; 
    }

    @Override
    public String toString() { 
        String result = "";
        
        for(int i = 0; i < nRows; ++i){
            for(int j = 0; j < nCols; ++j){
                if(player_pos[i][j] != null)
                    result += " " + player_pos[i][j].getNumber();
                else
                    result += " " + grid[i][j];
            }
            
            result += "\n";
        }
        
        return result; 
    }

    public void addMonster(int row, int col, Monster monster) { 
        if(emptyPos(row,col)){ // no hago la comprobacion de posOK(row,col) porque ya lo hace el metodo emptyPos(row,col)
            grid[row][col] = MONSTER_CHAR;
            monster.setPos(row,col);
            monster_pos[row][col] = monster;
        }
    }

    public Monster putPlayer(Directions direction, Player player) { 
        int oldRow = player.getRow();
        int oldCol = player.getCol();
        int[] newPos = dir2Pos(oldRow,oldCol,direction);
        return putPlayer2D(oldRow,oldCol,newPos[ROW],newPos[COL],player);
    }

    public void addBlock(Orientation orientation, int startRow, int startCol, int length) { 
        int incRow, incCol;
        if(orientation == Orientation.VERTICAL){
            incRow = 1;
            incCol = 0;
        }
        else{
            incRow = 0;
            incCol = 1;
        }
        
        int row = startRow;
        int col = startCol;
        
        while(posOK(row,col) && emptyPos(row,col) && (length > 0)){
            grid[row][col] = BLOCK_CHAR;
            length--;
            row += incRow;
            col += incCol;
        }
    }

    public Directions[] validMoves(int row, int col) {
    
        ArrayList<Directions> direccionesValidas = new ArrayList<>();

        if(canStepOn(row + 1,col))
            direccionesValidas.add(Directions.DOWN);
        if(canStepOn(row - 1,col))
            direccionesValidas.add(Directions.UP);
        if(canStepOn(row,col + 1))
            direccionesValidas.add(Directions.RIGHT);
        if(canStepOn(row,col - 1))
            direccionesValidas.add(Directions.LEFT);

        return direccionesValidas.toArray(new Directions[direccionesValidas.size()]);
    }

    private boolean posOK(int row, int col) { 
        return ((row >= 0 && row < nRows) && (col >= 0 && col < nCols)); 
    }

    private boolean emptyPos(int row, int col) { 
        return (grid[row][col] == EMPTY_CHAR);
    }

    private boolean monsterPos(int row, int col) { 
        return (grid[row][col] == MONSTER_CHAR); 
    }

    private boolean combatPos(int row, int col) { 
        return  (grid[row][col] == COMBAT_CHAR);
    }

    private boolean exitPos(int row, int col) { 
        return (grid[row][col] == EXIT_CHAR);
    }

    private boolean canStepOn(int row, int col) { 
        boolean pos = false;
        
        if(posOK(row,col))
            pos = (emptyPos(row,col) || monsterPos(row,col) || exitPos(row,col));
        
        return pos;  
    }

    private void updateOldPos(int row, int col) { 
        if(posOK(row,col)){
            if(monster_pos[row][col] != null)
                grid[row][col] = MONSTER_CHAR;
            else
                grid[row][col] = EMPTY_CHAR;
            
            player_pos[row][col] = null;
        }
    }

    private int[] dir2Pos(int row, int col, Directions direction) { 
        int[] next_pos = new int[2];
        next_pos[ROW] = row;
        next_pos[COL] = col;
        
        switch (direction){
            case UP:
                --next_pos[ROW];
                break;
            case DOWN:
                ++next_pos[ROW];
                break;
            case LEFT:
                --next_pos[COL];
                break;
            case RIGHT:
                ++next_pos[COL];
                break;
        }
        
        return next_pos; 
    }

    public int[] randomEmptyPos() { // deberia de ser privado pero lo necesito para ahora
        int[] pos = new int[2];
        do{
            pos[ROW] = Dice.randomPos(nRows);
            pos[COL] = Dice.randomPos(nCols);
        } while(!emptyPos(pos[ROW],pos[COL]));
            
        
        return pos; 
    }

    private Monster putPlayer2D(int oldRow, int oldCol, int row, int col, Player player) { 
        Monster monster = null;
        Player p;
        
        if(canStepOn(row,col)){
            if(posOK(oldRow,oldCol)){
                p = player_pos[oldRow][oldCol];
                
                if(p == player)
                    updateOldPos(oldRow,oldCol);
            }
            
            boolean mosterPos = monsterPos(row,col);
            
            if(mosterPos){
                set(row,col,COMBAT_CHAR); 
                monster = monster_pos[row][col];
            }
            else{
                char number = player.getNumber();
                set(row,col,number); 
                set(row,col,player);
            }

            player.setPos(row,col);
        }
        
        return monster;
    }

    private void set(int row, int col, char c) {
        if(posOK(row,col))
            grid[row][col] = c;
    }

    private void set(int row, int col, Player player) {
        if(posOK(row,col))
            player_pos[row][col] = player;
    }

}