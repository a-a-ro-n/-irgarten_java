package Irrgarten;

/**
 *
 * @author aaron
 */
public class LabyrinthCharacter{
    private final String name;
    private final float intelligence;
    private final float strength;
    private float health;
    private int row;
    private int col;
    
    LabyrinthCharacter(String _name, float _intelligence, float _strength, float _health){
        name = _name;
        intelligence = _intelligence;
        strength = _strength;
        health = _health;
    }
    
    LabyrinthCharacter(LabyrinthCharacter other){
        name = other.name;
        intelligence = other.intelligence;
        strength = other.strength;
        row = other.row;
        col = other.col;
    }
    
    public boolean dead(){
        return !(health > 0);
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    protected float getIntelligence(){
        return intelligence;
    }
    
    protected float getStrength(){
        return strength;
    }
    
    protected float getHealth(){
        return health;
    }
    
    protected void setHealth(float _health){
        health = _health;
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
    
    protected void gotWounded(){
        health--;
    }
    
    public float attack(){
       return Dice.intensity(strength);
    }
    
    public boolean defend(float attack){
                boolean isDead = dead();
        if(!isDead){
            float defensiveEnergy = Dice.intensity(intelligence);
            
            if(defensiveEnergy < attack){
                gotWounded();
                isDead = dead();
            }
        }
        
        return isDead; 
    }
}
