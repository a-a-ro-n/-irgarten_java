package Irrgarten.controller;

import Irrgarten.Game;
import Irrgarten.Directions;
import Irrgarten.UI.TextUI;


public class Controller {
    
    private final Game game;
    private final TextUI view;
    
    public Controller(Game game, TextUI view) {
        this.game = game;
        this.view = view;
    }
    
    public void play() {
        boolean endOfGame = false;
        while (!endOfGame) {
            view.showGame(game.getGameState()); 
            Directions direction = (Directions) view.nextMove(); 
            endOfGame = game.nextStep(direction);
        }
      view.showGame(game.getGameState());        
    }
    
}
