import java.applet.*;
import java.awt.*;

/**
 *  The bouncing ball program using a ball class private fields.
 *
 *  @author Stephen Gilbert
 *  @version Mar 13, 2009 2:27:37 PM
 */
public class AppletBounce4 extends Applet
{
    /*
     * Instance variables;
     */
    private EncapsulatedBall ball;     // the ball we'll bounce
    
    // Time (in milliseconds) for each frame
    private static final int PAUSE_TIME = 1000 / 12; 
    
    /**
     *  Initialize the animation.
     */
    public void init()
    {
        // A black background, yellow ball
        setBackground(Color.BLACK);
        
        // A 50 pixel, yellow ball
        ball = new EncapsulatedBall();    // Construct the object
        
        // Initialize the fields in the object
        ball.setRadius(25);
        ball.setLocation(new Point(getWidth() / 2, getHeight() / 2));
        ball.setSpeed(5 + (int)(Math.random() * 15),
                      5 + (int)(Math.random() * 15));
        ball.setColor(Color.YELLOW);        
    }
    
    /**
     *  Advances one frame of the animation.
     */
    public void paint(Graphics pen)
    {
        // Move and then draw the ball
        ball.move(getBounds());
        ball.draw(pen);
        
        // Pause for the next frame
        try {
            Thread.sleep(PAUSE_TIME);
        } catch (InterruptedException e) { /* do nothing */ }
        
        // Advance to the next frame
        repaint();
    }
}

