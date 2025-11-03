package Irrgarten;

import java.util.ArrayList;
/**
 *
 * @author aaron
 */
public class Player {
    private final static int MAX_WEAPONS = 2;
    private final static int MAX_SHIELDS = 3;
    private final static int INITIAL_HEALTH = 10;
    private final static int HITS2LOSE = 3;
    
    private String name = "Player# ";
    private final char number;
    private final float intelligence;
    private final float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits = 0;
    
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Shield> shields = new ArrayList<>();
    
    public Player(char _number, float _intelligence, float _strengh){
        number =  _number;
        intelligence = _intelligence;
        strength = _strengh;
        name += number; // establezco el nombre a Player# number
    }
    
    public void resurrect(){
        consecutiveHits = 0;
        health = INITIAL_HEALTH;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    public char getNumber(){
        return number;
    }
    
    public void setPos(int _row, int _col){
        row = _row;
        col = _col;
    }
    
    public boolean dead(){
        return !(health > 0);
    }
    
    public float attack(){
        return (strength + sumWeapons());
    }

    @Override
    public String toString(){
        return "\nName: " + name + "\nposicion: (" + row +"," + col + ")\nIntelligence: " + intelligence +
                "\nStrengh: " + strength +"\nHealth: " + health;
    }
    
    private void receiveWeapon(Weapon w){
        for(Weapon wi : weapons){
            boolean discard = wi.discard();
            
            if(discard)
                weapons.remove(wi);
        }
        
        int size = weapons.size();
        
        if(size < MAX_WEAPONS)
            weapons.add(w);
    }
    
    private void receiveShield(Shield s){
        for(Shield si : shields){
             boolean discard = si.discard();
             
             if(discard)
                 shields.remove(si);
        }
        
        int size = shields.size();
        
        if(size < MAX_SHIELDS)
            shields.add(s);
    }
    
    private Weapon newWeapon(){
        Weapon w = new Weapon(Dice.weaponPower(),Dice.usesLeft());
        return w;
    }
    
    private Shield newShield(){
        Shield s = new Shield(Dice.shieldPower(),Dice.usesLeft());
        return s;
    }
    
    private float sumWeapons(){
        float sum = 0;
        int size = weapons.size();
        
        for(int i = 0; i < size;i++)
            sum += weapons.get(i).attack();
        
        return sum;
    }
    
    private float sumShields(){
        float sum = 0;
        int size = shields.size();
        
        for(int i = 0; i < size;i++)
            sum += shields.get(i).protect();
        
        return sum;
    }
    
    private float defensiveEnergy(){
        return (intelligence + sumShields());
    }
    
    private boolean manageHit(float receivedAttack){
        float defense = defensiveEnergy();
        boolean lose = false;
        
        if(defense < receivedAttack){
            gotWounded();
            incConsecutiveHits();
        }
        else
            resetHits();
        
        if((consecutiveHits == HITS2LOSE) || dead())
            lose = true;
        
        return lose;
    }
    
    private void resetHits(){
        consecutiveHits = 0;
    }
    
    private void gotWounded(){
        --health;
    }
    
    private void incConsecutiveHits(){
        ++consecutiveHits;
    }

    public void receiveReward() {
        int wReward = Dice.weaponsReward();
        int sReward = Dice.shieldReward();
        
        for(int i = 0; i < wReward; i++){
            Weapon wnew = newWeapon();
            receiveWeapon(wnew);
        }
        
        for(int i = 0; i < sReward; i++){
            Shield snew = newShield();
            receiveShield(snew);
        }
        
        int extraHealth = Dice.healthReward();
        health += extraHealth;
    }
    
    public boolean defend(float receivedAttack){
        manageHit(receivedAttack);
        float defense = defensiveEnergy();
        boolean lose = false;
        
        if(defense < receivedAttack){
            gotWounded();
            incConsecutiveHits();
        }
        else
            resetHits();
        
        if((consecutiveHits == HITS2LOSE) || dead()){
            resetHits();
            lose = true;
        }
        
        return lose;
    }
    
    public Directions move(Directions direction,ArrayList<Directions> validMoves){
        int size = validMoves.size();
        boolean contained = validMoves.contains(direction);
        Directions result = direction;
        
        if((size > 0) && !contained){
            Directions firstElement = validMoves.get(0);
            result = firstElement;
        }
        
        return result;
    }
}