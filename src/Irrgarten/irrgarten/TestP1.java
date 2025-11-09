package Irrgarten.irrgarten;


/**
 *
 * @author aaron
 */

public class TestP1 {
    /*public static void main(String[] args){
        
        System.out.println("--------------------------------------------------");
        System.out.println("      INICIO DE PRUEBAS PARA LA PRÁCTICA 1        ");
        System.out.println("--------------------------------------------------");

        // -- Instancias a crear --
        Weapon weapon0 = new Weapon(8,5);
        Weapon weapon1 = new Weapon(4,10);
        
        Shield shield0 = new Shield(5,4);
        Shield shield1 = new Shield(3,5);
        
        // -- Prueba de Enumerados -- 
        GameCharacter player0 = GameCharacter.PLAYER;
        GameCharacter monster0 = GameCharacter.MONSTER;
        
        System.out.println("\n\n --- ENUMERADOS ---");
        System.out.println("\n Personaje: " + player0);
        System.out.println("\n Monstruo: " + monster0);
        System.out.println("\n Dirección de movimiento: " + Directions.UP);
        System.out.println("\n Orientación del tablero: " + Orientation.HORIZONTAL);
        
        
        // -- Prueba Weapons y Shield -- 
        System.out.println("\n\n --- WEAPONS / SHIELD ---");
        
        // Weapons
        System.out.println("\n -- W0 inicial: " + weapon0.toString()); // W[8.0, 5]
        
        for(int i = 0; i < 2; ++i){
            weapon0.attack(); // ataque
            int numero = i+1;
            System.out.println("\n W0 ataque " + numero + ": " + weapon0.toString());
        }
        
        System.out.println("\n W0.discard(): " + weapon0.discard()); // Descarte??
        
        // Weapon agotado
        System.out.println("\n\n -- Probando Weapon agotado (W1: " + weapon1.toString() + ")");
        
        int uses_weapon1 = weapon1.getUses();
        
        for(int i = 0; i < uses_weapon1; i++){
            weapon1.attack(); // ataque
            System.out.println("\n " + weapon1.toString()); // visualizacion del desgaste del arma
        }
        
        System.out.println("\n W1 Uses: " + weapon1.toString()); // Uses debe ser 0
        System.out.println("\n W1 intento de attack (debe ser 0.0): " + weapon1.attack()); 
        
        
        // Prueba de Shield
        System.out.println("\n -- S0 inicial: " + shield0.toString()); // S[5.0, 4]
        
        for(int i = 0; i < 2; ++i){
            shield0.protect(); // proteje
            int numero = i + 1;
            System.out.println("\n S0 defensa " + numero + ": " + shield0.toString());
        }
        
        System.out.println("\n S0.discard(): " + shield0.discard()); // Descarte??

        // Shield agotado
        System.out.println("\n\n -- Probando Shield agotado (S1: " + shield1.toString() + ")");
        
        int uses_shield1 = shield1.getUses();
        
        for(int i = 0; i < uses_shield1; i++){
            shield1.protect(); // proteje
            System.out.println("\n " + shield1.toString()); // visualizacion del desgaste del escudo
        }
        
        System.out.println("\n S1 Uses: " + shield1.toString()); // Uses debe ser 0
        System.out.println("\n S1 intento de protect (debe ser 0.0): " + shield1.protect()); 
        
        
        // -- Prueba GameState -- 
        GameState gameState = new GameState("1","3","2",2,false,"Comienzo de partida");
        
        System.out.println("\n\n --- GAMESTATE ---");
        System.out.println("\n Labyrinth: " + gameState.getLabyrinth()); 
        System.out.println("\n Players: " + gameState.getPlayers());
        System.out.println("\n Current Player: " + gameState.getCurrentPlayer());
        System.out.println("\n Winner: " + gameState.getWinner());
        
        
        // -- Prueba Dice -- 
        System.out.println("\n\n --- DICE (100 ITERACIONES) ---");

        int totalPruebas = 100;
        
        // resurrectPlayer()
        int resurrecciones = 0;
        
        for (int i = 0; i < totalPruebas; i++){
            if (Dice.resurrectPlayer()){ // pob. del 30% aproximadamentes
                resurrecciones++;
            }
        }
        
        float probResurrect = (float)resurrecciones / totalPruebas;
        System.out.printf("\n resurrectPlayer (percentage):" + probResurrect);
        
        // randomPos() y whoStarts()
        int maxPos = 10;
        int maxPlayers = 4;
        
        System.out.printf("\n randomPos:" + Dice.randomPos(maxPos));
        System.out.printf("\n whoStarts: " + Dice.whoStarts(maxPlayers));
        
        // rewards
        int maxW = 0;
        int maxS = 0;
        
        for (int i = 0; i < totalPruebas; i++){
            maxW = Math.max(maxW, Dice.weaponsReward());
            maxS = Math.max(maxS, Dice.shieldReward());
        }
        
        System.out.printf("\n weaponsReward:" + maxW); 
        System.out.printf("\n sheildReward: "+ maxS);
        
        // discardElement 
        System.out.println("\n discardElement(0): " + Dice.discardElement(0)); // usesLeft = 0 (debería devolver true con alta probabilidad)
        System.out.println(" discardElement(5): " + Dice.discardElement(5)); // usesLeft = 5 (debería devolver false con alta probabilidad) 
        
        System.out.println("\n\n--------------------------------------------------");
        System.out.println("                 FIN DE PRUEBAS                   ");
        System.out.println("--------------------------------------------------");
    }*/
}