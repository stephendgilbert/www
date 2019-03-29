import java.applet.*;
import java.awt.*;
/**
 *  Write a one-sentence summary of your program here.
 *  Follow it with additional details about its purpose, what
 *  it represents, and how to use it.
 *
 *  @author (your name goes here)
 *  @version (place the date here)
 */
public class WildOvals extends Applet
{
    // Width and height of your applet
    private int appWidth, appHeight;

    /**
     *  Set the background and initialize appWidth and appHeight.
     */
    public void init()
    {
        setBackground(Color.BLACK);
        appWidth = getWidth();
        appHeight = getHeight();
    }
    
    /**
     *  Paint random filled ovals on the screen.
     */
    public void paint(Graphics pen)
    {
        // Put your painting code here
        // 1. Create a Color object using random numbers
        //    Use one of the 3 or 4-parameter constructors.
        
        // 2. Calculate 4 random coordinates (x1, y1, x2, y2)
        // 3. Use the smallest of each for x,y
        // 4. Subtract x,y from the larger for width & height
        // 5. Set the drawing color using your Color object from 1
        // 6. Pain your filled oval using the position and coordinates
        //    you generated in steps 2-4

        wait(1); // wait one second before repainting
        repaint();
    }

    // This eliminates erasing of the previous image
    public void update(Graphics g)
    {
        paint(g);
    }

    // This delays for x seconds
    public void wait(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) { }
    }
}
