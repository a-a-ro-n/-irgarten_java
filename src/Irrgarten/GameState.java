package Irrgarten;

/**
 *
 * @author aaron
 */
public class GameState {
    private final String labyrinth;
    private final String players;
    private final String monstres;
    private final int currentPlayer;
    private final boolean winner;
    private final String log;
    
    public GameState(String _labyrinth, String _players, String _monstres, int _currentPlayer, boolean _winner, String _log){
        labyrinth = _labyrinth;
        players = _players;
        monstres = _monstres;
        currentPlayer = _currentPlayer;
        winner = _winner;
        log = _log;
    }

    public String getLabyrinth(){
        return labyrinth;
    }
    
    public String getPlayers(){
        return players.toString();
    }
    
    public String getMonstres(){
        return monstres.toString();
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
}