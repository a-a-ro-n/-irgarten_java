package Irrgarten;

import Irrgarten.CombatElement;
import Irrgarten.Dice;

/**
 *
 * @author aaron
 */
public class Shield extends CombatElement{
   public Shield(float _protection, int _uses){
       super(_protection,_uses);
   }

   @Override
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
        return ("S[" + getEffect() + ", " + getUses() + "]");
    }
    
    public boolean discard(){
        return Dice.discardElement(getUses());
    }
}
