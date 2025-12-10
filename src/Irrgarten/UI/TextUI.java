package Irrgarten.UI;

import Irrgarten.Directions;
import Irrgarten.GameState;
import java.util.Scanner;


public class TextUI implements UI {
    
    private static Scanner in = new Scanner(System.in);
    
    private char readChar() {
        String s = in.nextLine();     
        return s.charAt(0);
    }
    

    public Directions nextMove() {
        System.out.print("Where? ");
        
        Directions direction = Directions.DOWN;
        boolean gotInput = false;
        
        while (!gotInput) {
            char c = readChar();
            switch(c) {
                case 'w':
                    System.out.print(" UP\n");
                    direction = Directions.UP;
                    gotInput = true;
                    break;
                case 's':
                    System.out.print(" DOWN\n");
                    direction = Directions.DOWN;
                    gotInput = true;
                    break;
                case 'd':
                    System.out.print("RIGHT\n");
                    direction = Directions.RIGHT;
                    gotInput = true;
                    break;
                case 'a':
                    System.out.print(" LEFT\n");
                    direction = Directions.LEFT;
                    gotInput = true;    
                    break;
            }
        }    
        return direction;
    }
    
    public void showGame(GameState gameState) {
        if(!gameState.getWinner()){
            System.out.println("\n--- ESTADO ACTUAL DEL JUEGO ---\n");
            System.out.println(gameState.getLabyrinth());
            System.out.println("Jugadores -> " + gameState.getPlayers() +"\n");
            System.out.println("Monstruos -> " + gameState.getMonstres() + "\n");
            System.out.println("Turno de -> " + gameState.getCurrentPlayer() + "\n");
            System.out.println("log: " + gameState.getLog() + "\n");
            
        }
        else
            System.out.println("¡UN JUGADOR HA GANADO!");
    }
    
}
