package Irrgarten.irrgarten;

/**
 *
 * @author aaron
 */

public class Weapon extends CombatElement{
    private final float power;
    private int uses;
    
    public Weapon(float _power,int _uses){
        super(_power,_uses);
        power = _power;
        uses = _uses;
    }
    
    public float getPower(){
        return super.getEffect();
    }
    
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
        return Dice.discardElement(uses);
    }
}
