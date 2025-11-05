package Irrgarten;

/**
 *
 * @author aaron
 */
public class Monster {
    private final static int INITIAL_HEALTH = 5;
    
    private final String name;
    private final float intelligence;
    private final float strength;
    private float health;
    private int row;
    private int col;
    
    public Monster(String _name, float _intelligence, float _strength){
        name = _name;
        intelligence = _intelligence;
        strength = _strength;
        health = INITIAL_HEALTH;
    }
    
    public boolean dead(){
        return !(health > 0);
    }
    
    public float attack(){
        return Dice.intensity(strength);
    }
    
    public void setPos(int _row, int _col){
        row = _row;
        col = _col;
    }    
    
    @Override
    public String toString(){
        return "\n\nNombre: " + name + "\nPosicion: (" + row + "," + col + ")\nIntelligence: " + intelligence + 
                "\nStrength: " + strength + "\nHealth: " + health + "\n";
    }
    
    public void gotWounded(){
        --health;
    }
    
    
    public boolean defend(float receivedAttack){ // tiene que ser publico para poder usarlo en otras clases
        boolean isDead = dead();
        if(!isDead){
            float defensiveEnergy = Dice.intensity(intelligence);
            
            if(defensiveEnergy < receivedAttack){
                gotWounded();
                isDead = dead();
            }
        }
        
        return isDead;
    }
}
