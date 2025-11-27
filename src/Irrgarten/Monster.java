package Irrgarten;

/**
 *
 * @author aaron
 */
public class Monster extends LabyrinthCharacter{
    private final static int INITIAL_HEALTH = 5;
    
    public Monster(String _name, float _intelligence, float _strength, float _health){
        super(_name,_intelligence,_strength, INITIAL_HEALTH);
    }
    
    @Override
    public boolean dead(){
        return super.dead();
    }
    
    @Override
    public float attack(){
       return Dice.intensity(getStrength());
    }
    
    @Override
    public void setPos(int _row, int _col){
        super.setPos(_row, _col);
    }    
    
    @Override
    public String toString(){
        return super.toString();
    }
    
    @Override
    public void gotWounded(){
        super.setHealth(super.getHealth() - 1);
    }
    
    
    @Override
    public boolean defend(float receivedAttack){ // tiene que ser publico para poder usarlo en otras clases
        boolean isDead = dead();
        if(!isDead){
            float defensiveEnergy = Dice.intensity(getIntelligence());
            
            if(defensiveEnergy < receivedAttack){
                gotWounded();
                isDead = dead();
            }
        }
        
        return isDead; 
    }
}