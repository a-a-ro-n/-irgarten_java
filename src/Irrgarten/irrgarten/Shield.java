package Irrgarten.irrgarten;

/**
 *
 * @author aaron
 */
public class Shield extends CombatElement{
   public Shield(float _protection, int _uses){
       super(_protection,_uses);
   }

    public int getUses(){
        return super.getUses();
    }
    
    public float getProtection(){
        return super.getEffect();
    }
   
    public float protect(){
        return super.produceEffect();
    }
    
    @Override 
    public String toString(){
        return ("S[" + protection + ", " + uses + "]");
    }
    
    public boolean discard(){
        return Dice.discardElement(uses);
    }
}
