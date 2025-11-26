package Irrgarten;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author aaron
 */
public abstract class CardDeck<T extends CombatElement>{
    private ArrayList<T> cardDeck = new ArrayList<>();
    
    public CardDeck(){}
    
    protected abstract T createCard();
    protected abstract void addCards();
    
    protected void addCard(T card){
        cardDeck.add(card);
    }
    
    public T nextCard(){
        if(cardDeck.isEmpty()){
            addCards();
            Collections.shuffle(cardDeck); // Barajar
        }
        
        T card = cardDeck.remove(0);
        return card;
    }
}
