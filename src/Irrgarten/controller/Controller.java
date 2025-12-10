package Irrgarten.controller;

import Irrgarten.Game;
import Irrgarten.Directions;
import Irrgarten.UI.UI;

public class Controller {
    
    private final Game game;
    private final UI view;
    
    public Controller(Game game, UI view) {
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
