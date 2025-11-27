package Irrgarten;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class FuzzyPlayer extends Player{
    
    public FuzzyPlayer(Player other){
        super(other);
    }
    
    @Override
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        return Dice.nextStep(direction, validMoves, super.getIntelligence());
    }
    
   @Override 
    public float attack(){
        return (super.sumWeapons() + Dice.intensity(super.getStrength()));
    }
    
    @Override
    protected float defensiveEnergy(){
        return (super.sumShields() + Dice.intensity(super.getIntelligence()));
    }
    
    @Override
    public String toString(){
        return ("\nFuzzy " + super.toString());
    }
} 