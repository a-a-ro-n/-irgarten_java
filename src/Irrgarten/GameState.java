package Irrgarten;

/**
 *
 * @author aaron
 */
public class GameState {
    private String labyrinth;
    private String players;
    private String monstres;
    private int currentPlayer;
    private boolean winner;
    private String log;
    
    public GameState(String _labyrinth, String _players, String _monstres, int _currentPlayer, boolean _winner, String _log){
        labyrinth = _labyrinth;
        players = _players;
        monstres = _monstres;
        currentPlayer = _currentPlayer;
        winner = _winner;
        log = _log;
    }
    
    // -- Getters --
    public String getLabyrinth(){
        return labyrinth;
    }
    
    public String getPlayers(){
        return players;
    }
    
    public String getMonstres(){
        return monstres;
    }
    
    public int getCurrentPlayer(){
        return currentPlayer;
    }
    
    public boolean getWinner(){
        return winner;
    }
    
    public String getLog(){
        return log;
    }
    
    // -- Setters --
    public void setLabyrinth(String _labyrinth){
        labyrinth = _labyrinth;
    }
    
    public void setPlayers(String _players){
        players = _players;
    }
    
    public void setMonstres(String _monstres){
        monstres = _monstres;
    }
    
    public void setCurrentPlayer(int _currentPlayer){
        currentPlayer = _currentPlayer;
    }
    
    public void setWinner(boolean _winner){
        winner = _winner;
    }
    
    public void setLog(String _log){
        log = _log;
    }
}