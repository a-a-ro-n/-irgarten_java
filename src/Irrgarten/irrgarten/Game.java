package Irrgarten.irrgarten;

import java.util.ArrayList;
import static java.util.Arrays.asList;

/**
 *
 * @author aaron
 */
public class Game {
    private final static int MAX_ROUNDS = 10;
    private final static int N_ROWS = 10;
    private final static int N_COLS = 10;
    
    private int currentPlayerIndex;
    private String log;
    
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    Labyrinth lab;
    
    public int getPlayers(){
        return players.size();
    }
    
    public int getMonsters(){
        return monsters.size();
    }
   
    public Game(int nplayers){
        for(int i = 0; i < nplayers; i++){
            Player player = new Player((char)('0' + i),Dice.randomIntelligence(),Dice.randomStrength()); 
            players.add(player);
        }
                    
        int exitRow = Dice.randomPos(N_ROWS);
        int exitCol = Dice.randomPos(N_COLS);
        lab = new Labyrinth(N_ROWS,N_COLS,exitRow,exitCol);
        configureLabyrinth();
        currentPlayerIndex = Dice.whoStarts(nplayers); 
        lab.spreadPlayers(players.toArray(new Player[0])); 
        log = "--- Start_Game ---\n";  
    }
    
    public boolean finished(){
        return lab.haveAWinner();
    }
    
    
    public GameState getGameState(){
        return new GameState(lab.toString(),players.toString(),monsters.toString(),currentPlayerIndex,finished(),log);
    }
    
    private void configureLabyrinth(){
        for(int i = 0; i < 3; i++){
            Monster monster = new Monster("Monster# " + i, Dice.randomIntelligence(), Dice.randomStrength()); 
            int[] pos = lab.randomEmptyPos();
            
            lab.addMonster(pos[0], pos[1], monster);
            
            monster.setPos(pos[0], pos[1]);
            monsters.add(monster);
        }

        addBlock(Orientation.VERTICAL,1,3,5);
        addBlock(Orientation.HORIZONTAL,5,1,4);
        log += "Labyrinth configured: Blocks added\n"; 
        log += "Labyrinth configured: " + monsters.size() + " monsters added.\n";
    }
    
    private void nextPlayer(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
    
    
    
    private void manageReward(GameCharacter winner){
        if(winner == GameCharacter.PLAYER){
            players.get(currentPlayerIndex).receiveReward();
            logPlayerWon();
        }
        else
            logMonsterWon();
    }
    
    private void manageResurrection(){
        boolean resurrect = Dice.resurrectPlayer();
        if(resurrect){
            players.get(currentPlayerIndex).resurrect();
            logResurrected();
        }
        else
            logPlayerSkipTurn();
    }
    
    private void logPlayerWon(){
        log += "Player# " + players.get(currentPlayerIndex).getNumber() + " Won the combat!!!\n";
    }
    
    private void logMonsterWon(){
        log += "Monster Won the combat!!!\n";
    }
    
    private void logResurrected(){
        log += "Resurect: Player# " + players.get(currentPlayerIndex).getNumber() + "\n";
    }
    
    private void logPlayerSkipTurn(){
        log += "Skip Turn: Player# " + players.get(currentPlayerIndex).getNumber() + "\n";
    }
    
    private void logPlayerNoOrders(){
        log += "Player# " + players.get(currentPlayerIndex).getNumber() + " un spected order\n";
    }
    
    private void logNoMonster(){
        log += "Player# " + players.get(currentPlayerIndex).getNumber() + " move\n";
    }
    
    private void logRounds(int rounds, int max){
        log += "Done " + rounds +" of " + max + "\n";
    }
    
    
    private Directions actualDirection(Directions preferredDirection){
        Player currentPlayer = players.get(currentPlayerIndex);
        int currentRow = currentPlayer.getRow();
        int currentCol = currentPlayer.getCol();
        
        Directions[] valid = validMoves(currentRow, currentCol);
        ArrayList<Directions> direcion = new ArrayList<>(asList(valid));
        
        return currentPlayer.move(preferredDirection,direcion);  
    }
    
    private Directions[] validMoves(int row, int col){
        return lab.validMoves(row, col);
    }
    
    private GameCharacter combat(Monster monster){
        Player currentPlayer = players.get(currentPlayerIndex);
        int rounds = 0;
        GameCharacter winner = GameCharacter.PLAYER;
        float playerAttack = currentPlayer.attack();
        boolean lose = monster.defend(playerAttack);
        
        while(!lose && (rounds < MAX_ROUNDS)){
            winner = GameCharacter.MONSTER;
            rounds++;
            float monsterAttack = monster.attack();
            lose = currentPlayer.defend(monsterAttack);
            
            if(!lose){
                playerAttack = currentPlayer.attack();
                winner = GameCharacter.PLAYER;
                lose = monster.defend(playerAttack);
            }
        }
        
        logRounds(rounds,MAX_ROUNDS);
        
        return winner;
    }
    
    public boolean nextStep(Directions preferredDirection){ // no me deja usarlo sino en el controler
        boolean dead = players.get(currentPlayerIndex).dead();
        GameCharacter winner;
        
        if(!dead){
            Directions direction = actualDirection(preferredDirection);
            if(direction != preferredDirection)
                logPlayerNoOrders();
            
            Monster monster = putPlayer(direction,players.get(currentPlayerIndex));
            
            if(monster == null)
                logNoMonster();
            else{
                winner = combat(monster);
                manageReward(winner);
            }
        }
        else
            manageResurrection();
        
        boolean endGame = finished();
        
        if(!endGame)
            nextPlayer();
        
        return endGame;
    }
    
    private void addBlock(Orientation orientation, int startRow, int startCol, int length){
        lab.addBlock(orientation,startRow,startCol,length);
    } 
    
    private Monster putPlayer(Directions direction, Player player){
        return lab.putPlayer(direction, player);
    }
}
