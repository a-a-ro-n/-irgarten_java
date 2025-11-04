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

        int nPlayers = 2; 

        Game game = new Game(nPlayers);

        TextUI view = new TextUI();

        Controller controller = new Controller(game, view);
        controller.play();
        
        // Fin del juego
        System.out.println("\n*** ¡FIN DEL JUEGO! ***");
        if (game.finished()) {
             System.out.println("¡Ha ganado un jugador!");
        } 
    }
}