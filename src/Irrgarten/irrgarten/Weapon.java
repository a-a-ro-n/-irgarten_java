package Irrgarten.irrgarten;

/**
 *
 * @author aaron
 */

public class Weapon {
    private final float power;
    private int uses;
    
    public Weapon(float _power,int _uses){
        power = _power;
        uses = _uses;
    }
    
    public float getPower(){
        return power;
    }
    
    public int getUses(){
        return uses;
    }

    public float attack(){
        float damage = 0;
        
        if(uses > 0){
            damage = power;
            --uses;
        }
        
        return damage;
    }
    
    @Override public String toString(){
        return ("W[" + power + ", " + uses + "]");
    }
    
    public boolean discard(){
        return Dice.discardElement(uses);
    }
}
