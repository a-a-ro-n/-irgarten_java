package Irrgarten.UI;

import Irrgarten.Directions;
import Irrgarten.GameState;
/**
 *
 * @author aaron
 */


public interface UI {
    public Directions nextMove();
    public void showGame(GameState gameState);
}