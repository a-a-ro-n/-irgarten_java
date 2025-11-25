package Irrgarten;

/**
 *
 * @author aaron
 */

public class Weapon extends CombatElement{    
    public Weapon(float _power,int _uses){
        super(_power,_uses);
    }
    
    public float getPower(){
        return super.getEffect();
    }
    
    @Override
    public int getUses(){
        return super.getUses();
    }

    public float attack(){
        return super.produceEffect();
    }
    
    @Override public String toString(){
        String aux = super.toString();
        String s ="W[ ";
        s += aux;
        s += "]";
        return s;
    }
    
    public boolean discard(){
        return Dice.discardElement(getUses());
    }
}
