/**
 *
 * @author aaron
 */
public class Shield {
   private final float protection;
   private int uses;
   
   public Shield(float _protection, int _uses){
       protection = _protection;
       uses = _uses;
   }

    public int getUses(){
        return uses;
    }
    
    public float getProtection(){
        return protection;
    }
   
    public float protect(){
        float result = 0;
        
        if(uses > 0){
            result = protection;
            --uses;
        }
        
        return result;
    }
    
    public String toString(){
        return ("S[" + protection + ", " + uses + "]");
    }
    
    public boolean discard(){
        return Dice.discardElement(uses);
    }
}
