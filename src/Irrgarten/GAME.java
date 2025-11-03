package Irrgarten;

/**
 *
 * @author aaron
 */
import Irrgarten.controller.Controller;
import Irrgarten.UI.TextUI;

/**
 * Clase principal para ejecutar el juego Irrgarten.
 */
public class GAME {
    
    public static void main(String[] args) {
        
        // --- 1. CONFIGURACIÓN ---
        
        // Número de jugadores para el inicio de la partida
        int nPlayers = 2; 

        // --- 2. MODELO ---
        
        // El Modelo (Game) se encarga de toda la lógica del juego.
        // **Asegúrese de haber aplicado las correcciones en Game.java y Dice.java**
        System.out.println("Iniciando juego Irrgarten con " + nPlayers + " jugadores...");
        Game game = new Game(nPlayers);
        
        // --- 3. VISTA ---
        
        // La Vista (TextUI) se encarga de la interacción con el usuario.
        TextUI view = new TextUI();
        
        // --- 4. CONTROLADOR ---
        
        // El Controlador (Controller) une el Modelo y la Vista.
        Controller controller = new Controller(game, view);
        
        // --- 5. INICIAR EL BUCLE DE JUEGO ---
        
        // El método play() contiene el bucle principal hasta que el juego finaliza.
        controller.play();
        
        // Después de que el juego termina
        System.out.println("\n*** ¡FIN DEL JUEGO! ***");
        if (game.finished()) {
             System.out.println("¡Tenemos un ganador!");
        } else {
             System.out.println("El juego ha terminado por otras causas.");
        }
    }
}