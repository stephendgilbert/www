import acm.program.*;
import acm.graphics.*;
/**
 *  Creates a playing card and puts it on the surface.
 *
 *  @author Stephen Gilbert
 *  @version Apr 29, 2009 12:17:59 PM
 */
public class TestCard02 extends GraphicsProgram
{
    /**
     *  Adds a card to the surface.
     */
    public void init()
    {
        PlayingCard card = new PlayingCard("Ace", "Spades");
        add(card, getWidth() / 2 - card.getWidth() / 2, 
            getHeight() / 2 - card.getHeight() / 2);
        
        PlayingCard card2 = new PlayingCard("2", "Dimonds");
        PlayingCard card3 = new PlayingCard("10", "Cubs");
        PlayingCard card4 = new PlayingCard("Spades", "Queen");
        
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new TestCard02().start(args);
    }
}
