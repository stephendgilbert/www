import java.util.*;

/**
 *  Represents a deck of playing cards.
 *
 *  @author Stephen Gilbert
 *  @version Apr 30, 2009 11:18:44 AM
 *
 */
public class Deck
{
    private ArrayList<PlayingCard> cards;

    /**
     * Creates the new list of cards.
     */
    public Deck()
    {
        cards = new ArrayList<PlayingCard>();
    }
    
    /**
     *  Add a card to the end of the deck.
     *  @param card the PlayingCard to add to the deck.
     */
    public void addCard(PlayingCard card)
    {
        cards.add(card);
    }
    
    /**
     *  Deals the top card off the deck. 
     *  Returns null if deck is empty.
     *  @return top card or null if deck is empty.
     */
    public PlayingCard dealCard()
    {
        return hasMore() ? cards.remove(0) : null;
    }
    
    /**
     *  Empties the deck of cards.
     */
    public void removeAllCards()
    {
        cards.clear();
    }
    
    /**
     *  Shuffles the deck of cards.
     */
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
    
    
    /**
     *  Get the number of cards remaining in the deck.
     *  @return  the number of cards remaining in the deck.
     */
    public int getCardsRemaining()
    {
        return cards.size();
    }
    
    /**
     *  Returns true if there are more cards left in the deck.
     *  @return true if there are more cards left in the deck.
     */
    public boolean hasMore()
    {
        return ! cards.isEmpty();
    }
}
