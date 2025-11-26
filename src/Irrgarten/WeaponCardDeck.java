package Irrgarten;

/**
 *
 * @author aaron
 */
public class WeaponCardDeck extends CardDeck<Weapon>{
    private static final int cartas = 3;
    public WeaponCardDeck(){}
    
    @Override
    protected Weapon createCard(){
        return new Weapon(Dice.weaponPower(),Dice.usesLeft());
    }

    @Override
    protected void addCards(){
        for (int i = 0; i < cartas; i++)
            addCard(createCard());
    }
}
