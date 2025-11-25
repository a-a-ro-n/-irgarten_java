package Irrgarten;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class FuzzyPlayer extends Player{
    
    public FuzzyPlayer(Player other){
        super.Player(other);
    }
    
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        return direction;
    }
}