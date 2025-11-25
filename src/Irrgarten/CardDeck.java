package Irrgarten;
import java.util.ArrayList;
/**
 *
 * @author aaron
 */
public abstract class CardDeck<T extends CombatElement> {
    private ArrayList<T> cardDeck = new ArrayList<>();
    
    protected abstract T createCard();
    protected abstract void addCards();
    
    protected void addCard(T card){
        cardDeck.add(card);
    }
    
    public T nextCard(){
        if(cardDeck.isEmpty())
            addCards(); // Llenar la baraja
        
        T card = cardDeck.remove(0); // Seleccionar y eliminar la primera carta
        return card;
    }
}
