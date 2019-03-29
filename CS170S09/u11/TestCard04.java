import acm.program.*;
import acm.graphics.*;
/**
 *  Creates several playing cards and put them on the surface.
 *
 *  @author Stephen Gilbert
 *  @version Apr 29, 2009 12:17:59 PM
 */
public class TestCard04 extends GraphicsProgram
{
    /**
     *  Adds a card to the surface.
     */
    public void init()
    {
        PlayingCard card1 = new PlayingCard();
        add(card1, 0, 0);
        
        PlayingCard card2 = new PlayingCard(Rank.TWO, Suit.DIAMONDS);
        PlayingCard card3 = new PlayingCard(Rank.TWO, Suit.CLUBS);
        PlayingCard card4 = new PlayingCard(Rank.JACK, Suit.CLUBS);

        double cWidth = card1.getWidth();
        double cHeight = card1.getHeight() + 25;

        add(card2, getWidth() - cWidth, 0);
        add(card3, 0, getHeight() - cHeight);
        add(card4, getWidth() - cWidth, getHeight() - cHeight);
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new TestCard04().start(args);
    }
}
