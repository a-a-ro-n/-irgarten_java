package Irrgarten.controller;

import Irrgarten.irrgarten.Game;
import Irrgarten.irrgarten.Directions;
import Irrgarten.UI.TextUI;


public class Controller {
    
    private Game game;
    private TextUI view;
    
    public Controller(Game game, TextUI view) {
        this.game = game;
        this.view = view;
    }
    
    public void play() {
        boolean endOfGame = false;
        while (!endOfGame) {
            view.showGame(game.getGameState()); 
            Directions direction = view.nextMove(); 
            endOfGame = game.nextStep(direction);
        }
      view.showGame(game.getGameState());        
    }
    
}
