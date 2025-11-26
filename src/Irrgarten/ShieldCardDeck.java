package Irrgarten;

/**
 *
 * @author aaron
 */
public class ShieldCardDeck extends CardDeck<Shield>{
    private static final int cartas = 3;
    public ShieldCardDeck(){}
    
    @Override
    protected Shield createCard(){
        return new Shield(Dice.shieldPower(),Dice.usesLeft());
    }

    @Override
    protected void addCards(){
        for (int i = 0; i < cartas; i++)
            addCard(createCard());
    }
}