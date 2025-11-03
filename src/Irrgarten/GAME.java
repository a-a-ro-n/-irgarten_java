package Irrgarten;

/**
 *
 * @author aaron
 */
import Irrgarten.controller.Controller;
import Irrgarten.UI.TextUI;

public class GAME {
    
    public static void main(String[] args) {
        
        System.out.println("\n--- JUEGO IRRGARTEN ---\n");
        
        // Número de jugadores
        int nPlayers = 2; 

        // 1. Crear el Modelo (Juego)
        Game game = new Game(nPlayers);
        
        // 2. Crear la Vista (Interfaz de Texto)
        TextUI view = new TextUI();
        
        // 3. Crear el Controlador
        Controller controller = new Controller(game, view);
        
        // 4. Iniciar el juego
        controller.play();
        
        // Fin del juego
        System.out.println("\n*** ¡FIN DEL JUEGO! ***");
        if (game.finished()) {
             System.out.println("¡Ha ganado un jugador!");
        } 
    }
}