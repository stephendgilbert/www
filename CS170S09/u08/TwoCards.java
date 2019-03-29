import java.awt.Color;

import acm.program.*;
import acm.graphics.*;
/**
 *  A CS 170 Example Program.
 *
 *  @author Stephen Gilbert
 *  @version Mar 10, 2009 3:38:55 PM
 */
public class TwoCards extends GraphicsProgram
{
    /**
     *  Creates a table with some cards.
     */
    public void run()
    {
        // 1. Create a green "table" for our cards.
        final int T_WIDTH = 200;
        final int T_HEIGHT = 150;
        GRect table = new GRect(0, 0, T_WIDTH, T_HEIGHT);
        
        // 1a. Center the table
        int appWidth = getWidth();
        int appHeight = getHeight();
        table.setLocation(appWidth / 2 - T_WIDTH / 2,
            appHeight / 2 - T_HEIGHT / 2);
        
        // 1b. Fill with a dark green
        table.setFillColor(new Color(0, 128, 0));
        table.setFilled(true);
        add(table);
        
        // 1c. Label the table
        GLabel caption = new GLabel("Place your bet!");
        double capWidth = caption.getWidth();
        double capHeight = caption.getHeight();
        caption.setLocation(appWidth / 2 - capWidth /2,
            appHeight / 2 + T_HEIGHT / 2 + capHeight);
        add(caption);
        
        // 2. Let's create a card using the GImage class
        GImage card1 = new GImage("cards/as.gif");
        card1.setLocation(table.getLocation());
        card1.move(15, 15);
        add(card1);
        
        // 2b. Deal the second card with the back showing
        GImage card2 = new GImage("cards/b.gif");
        card2.setLocation(card1.getLocation());
        card2.move(25, 10);
        add(card2);
        
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new TwoCards().start(args);
    }
}
