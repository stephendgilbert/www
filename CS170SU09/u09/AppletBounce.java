import java.applet.*;
import java.awt.*;

/**
 *  An applet version of the bouncing ball program.
 *
 *  @author Stephen Gilbert
 *  @version Mar 13, 2009 2:27:37 PM
 */
public class AppletBounce extends Applet
{
    /*
     * Instance variables;
     */
    private Rectangle ball;     // the ball we'll bounce
    private int dx;             // how far it goes as x
    private int dy;             // how far in y
    
    // Time (in milliseconds) for each frame
    private static final int PAUSE_TIME = 33; 
    
    /**
     *  Initialize the animation.
     */
    public void init()
    {
        // A black background, yellow ball
        setBackground(Color.BLACK);
        setForeground(Color.YELLOW);
        
        // A 50 pixel ball
        ball = new Rectangle(getWidth() / 2 - 25, 
            getHeight() / 2 - 25, 50, 50);
        
        // A random velocity in both x and y
        dx = 3 + (int)(Math.random() * 10);
        dy = 3 + (int)(Math.random() * 10);
    }
    
    /**
     *  Advances one frame of the animation.
     */
    public void paint(Graphics pen)
    {
        // Move and then draw the ball
        ball.translate(dx, dy);
        pen.fillOval(ball.x, ball.y, ball.width, ball.height);
        
        // Check if we've encountered the edges
        if (ball.x < 0 || ball.x + ball.width >= getWidth())
            dx = -dx;
        if (ball.y < 0 || ball.y + ball.height >= getHeight())
            dy = -dy;
        
        // Pause for the next frame
        try {
            Thread.sleep(PAUSE_TIME);
        } catch (InterruptedException e) { /* do nothing */ }
        
        // Advance to the next frame
        repaint();
    }
}

