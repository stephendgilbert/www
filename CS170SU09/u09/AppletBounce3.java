import java.applet.*;
import java.awt.*;

/**
 *  The bouncing ball program using a ball class with methods
 *
 *  @author Stephen Gilbert
 *  @version Mar 13, 2009 2:27:37 PM
 */
public class AppletBounce3 extends Applet
{
    /** A MethodBall contains fields and methods.  */
    private MethodBall ball;     // the ball we'll bounce
    
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
        ball = new MethodBall();    // Construct the object
        
        // Initialize the fields in the object
        ball.radius = 25;
        ball.location = new Point(getWidth() / 2, getHeight() / 2);
        ball.dx = 5 + (int)(Math.random() * 15);
        ball.dy = 5 + (int)(Math.random() * 15);
        ball.color = Color.YELLOW;
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



