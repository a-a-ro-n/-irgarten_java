package Irrgarten.Main;

/**
 *
 * @author aaron
 */
import Irrgarten.Game;
import Irrgarten.controller.Controller;
import Irrgarten.UI.UI;
import Irrgarten.UI.JFrame;

public class GAME {
    
    public static void main(String[] args) {
        
        System.out.println("\n--- JUEGO IRRGARTEN ---\n");

        int nPlayers = 3; 

        Game game = new Game(nPlayers);

        UI view = new JFrame();

        Controller controller = new Controller(game, view);
        controller.play();
        
        // Fin del juego
        System.out.println("\n*** ¡FIN DEL JUEGO! ***");
    }
}