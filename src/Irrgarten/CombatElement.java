package Irrgarten;

/**
 *
 * @author aaron
 */
public abstract class CombatElement {
    private float effect;
    private int uses;
    
    public CombatElement(float _effect, int _uses){
        effect = _effect;
        uses = _uses;
    }
    
    public boolean discad(){
       return Dice.discardElement(uses);
    }
    
    @Override
    public String toString(){
        return (effect + ", " + uses);
    }
    
    public float getEffect(){
        return effect;
    }
    
    public int getUses(){
        return uses;
    }
    
    public float produceEffect(){
        float result = 0;
        
        if(uses > 0){
            result = effect;
            --uses;
        }
        
        return result;
    }
}
