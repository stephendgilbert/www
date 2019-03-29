import acm.program.*;
import acm.graphics.*;
/**
 *  Creates a playing card and puts it on the surface.
 *
 *  @author Stephen Gilbert
 *  @version Apr 29, 2009 12:17:59 PM
 */
public class TestCard03 extends GraphicsProgram
{
    /**
     *  Adds a card to the surface.
     */
    public void init()
    {
        PlayingCard card = new PlayingCard();
        add(card, getWidth() / 2 - card.getWidth() / 2, 
            getHeight() / 2 - card.getHeight() / 2);
        
        PlayingCard card2 = new PlayingCard(
            PlayingCard.TWO, PlayingCard.DIAMONDS);
        
        PlayingCard card3 = new PlayingCard(
            PlayingCard.CLUBS, PlayingCard.TWO);
        
        PlayingCard card4 = new PlayingCard(
            PlayingCard.CLUBS, PlayingCard.JACK);
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new TestCard03().start(args);
    }
}
