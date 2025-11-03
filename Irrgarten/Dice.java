import java.util.Random;


/**
 *
 * @author aaron
 */
public class Dice {
    private static final int MAX_USES = 5; //maximo de usos de weapos o shields
    private static final double MAX_INTELLIGENCE = 10.0; // inteligencia maxima
    private static final double MAX_STRENGTH = 10.0; // fuerza maxima
    private static final double RESURRECT_PROB = 0.3; // prob. de resucitar un jugador por turno
    private static final int WEAPONS_REWARD = 2; // maximo de weapon tras combate
    private static final int SHIELDS_REWARD = 3; // maximo de shield tras combate
    private static final int HEALTH_REWARD = 5; // maximo de health añadida tras combate
    private static final int MAX_ATTACK = 3; // potencia maxima del weapon
    private static final int MAX_SHIELD = 2; // potencia maxima del shield
    
    private static final Random generator = new Random();
    
    public int randomPos(int max){
        return generator.nextInt(max + 1); // el + 1 es para que max este incluido en el rango de Random
    }
    
    public int whoStarts(int nplayer){
        return generator.nextInt(nplayer + 1);
    }    
    
    public float randomIntelligence(){
        return generator.nextFloat((float)MAX_INTELLIGENCE); // hago un cast de double a float
    }
    
    public float randomStrength(){
        return generator.nextFloat((float)MAX_STRENGTH); // hago un cast de double a float
    }
    
    public boolean resurrectPlayer(){
        return generator.nextFloat(1) < RESURRECT_PROB; // true si generator es < 0.3
    }
    
    public int weaponsReward(){
        return generator.nextInt(WEAPONS_REWARD + 1);
    }
    
    public int sheildReward(){
        return generator.nextInt(SHIELDS_REWARD + 1);
    }
    
    public int healthReward(){
        return generator.nextInt(HEALTH_REWARD + 1);
    }
    
    public float weaponPower(){
        return generator.nextFloat(MAX_ATTACK);
    }
    
    public float shieldPower(){
        return generator.nextFloat(MAX_SHIELD);
    }
    
    public int usesLeft(){
        return generator.nextInt(MAX_USES + 1);
    }
    
    public float intensity(float competence){
        return generator.nextFloat(competence);
    }
    
    public static boolean discardElement(int usesLeft){
        return (1 - (float)(usesLeft / MAX_USES)) > generator.nextFloat(1); 
        // al hacer (usesLeft / MAX_USES) se obtiene un valos entre 1-0 
        // entonces 1 - (usesLeft / MAX_USES) es lo inverso al (usesLeft / MAX_USES)
    }
}
