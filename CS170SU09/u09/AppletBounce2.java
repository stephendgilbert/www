import java.applet.*;
import java.awt.*;

/**
 *  The bouncing ball program using a simple ball class.
 *
 *  @author Stephen Gilbert
 *  @version Mar 13, 2009 2:27:37 PM
 */
public class AppletBounce2 extends Applet
{
    /*
     * Instance variables;
     */
    private SimpleBall ball;     // the ball we'll bounce
    
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
        ball = new SimpleBall();    // Construct the object
        
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
        ball.location.x += ball.dx;
        ball.location.y += ball.dy;
        
        pen.setColor(ball.color);
        pen.fillOval(ball.location.x - ball.radius, 
            ball.location.y - ball.radius, 
            ball.radius * 2, ball.radius * 2);
        
        // Check if we've encountered the edges
        if (ball.location.x - ball.radius < 0 || 
            ball.location.x + ball.radius >= getWidth())
            ball.dx = -ball.dx;
        if (ball.location.y - ball.radius < 0 || 
            ball.location.y + ball.radius >= getHeight())
            ball.dy = -ball.dy;
        
        // Pause for the next frame
        try {
            Thread.sleep(PAUSE_TIME);
        } catch (InterruptedException e) { /* do nothing */ }
        
        // Advance to the next frame
        repaint();
    }
}

