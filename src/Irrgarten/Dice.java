package Irrgarten;

import java.util.ArrayList;
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
    
    public static int randomPos(int max){
        return generator.nextInt(max); // el + 1 es para que max este incluido en el rango de Random
    }
    
    public static int whoStarts(int nplayer){
        return generator.nextInt(nplayer);
    }    
    
    public static float randomIntelligence(){
        return generator.nextFloat((float)MAX_INTELLIGENCE); // hago un cast de double a float
    }
    
    public static float randomStrength(){
        return generator.nextFloat((float)MAX_STRENGTH); // hago un cast de double a float
    }
    
    public static boolean resurrectPlayer(){
        return generator.nextFloat() < RESURRECT_PROB; // true si generator es < 30%
    }
    
    public static int weaponsReward(){
        return generator.nextInt(WEAPONS_REWARD + 1);
    }
    
    public static int shieldReward(){
        return generator.nextInt(SHIELDS_REWARD + 1);
    }
    
    public static int healthReward(){
        return generator.nextInt(HEALTH_REWARD + 1);
    }
    
    public static float weaponPower(){
        return generator.nextFloat(MAX_ATTACK);
    }
    
    public static float shieldPower(){
        return generator.nextFloat(MAX_SHIELD);
    }
    
    public static int usesLeft(){
        return generator.nextInt(MAX_USES + 1);
    }
    
    public static float intensity(float competence){
        return generator.nextFloat(competence);
    }
    
    public static boolean discardElement(int usesLeft){
        return (1 - (float)(usesLeft / MAX_USES))*10 > generator.nextFloat(10); 
        // al hacer (usesLeft / MAX_USES) se obtiene un valos entre 1-0 
        // entonces 1 - (usesLeft / MAX_USES) es lo inverso al (usesLeft / MAX_USES)
    }
    
    public static Directions nextStep(Directions preference,ArrayList<Directions> validMoves,float intelligence){
        Directions result = (generator.nextFloat((float) MAX_INTELLIGENCE) < intelligence)? preference : validMoves.get(Dice.randomPos(validMoves.size()));
        
        return result;
    }

}
