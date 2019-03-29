import acm.graphics.*;
/**
 *  Represents a playing card.
 *
 *  @author Stephen Gilbert
 *  @version Apr 29, 2009 12:11:39 PM
 *
 */
public class PlayingCard extends GCompound
{
    private Suit suit;
    private Rank rank;
    private GImage front;
    private GImage back;
    
    /**
     * Constructs a playing card.
     */
    public PlayingCard()
    {
        suit = Suit.values()[(int) (Math.random() * 4)];
        rank = Rank.values()[(int) (Math.random() * 13)];
        back = new GImage("b.gif");     // in images folder
        front = new GImage(getCardImage());
        add(front);
        add(back);
    }
    
    /**
     * Working constructor.
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public PlayingCard(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
        back = new GImage("b.gif");
        front = new GImage(getCardImage());
        add(front);
        add(back);
    }

    /**
     * Private name of a card in the images folder.
     * @return random name with parts combined.
     */
    private String getCardImage()
    {
        String suits = "cshd";
        String ranks = "a23456789tjkqa";
        
        return "" + ranks.charAt(rank.ordinal()) + 
            suits.charAt(suit.ordinal()) + ".gif";
    }    
}
