package Irrgarten;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class FuzzyPlayer extends Player{
    
    public FuzzyPlayer(Player other){
        super(other, other.getNumber());
        shields = other.shields;
        weapons = other.weapons;
    }
    
    @Override
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        return direction;
    }
    
    public float attack(){
        
    }
    
    abstract float defensiveEnergy(){
        
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}