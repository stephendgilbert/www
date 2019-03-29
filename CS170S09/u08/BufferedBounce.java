import java.applet.*;
import java.awt.*;

/**
 *  An applet version of the bouncing ball program
 *  that uses double-buffering.
 *
 *  @author Stephen Gilbert
 *  @version Mar 13, 2009 2:27:37 PM
 */
public class BufferedBounce extends Applet
{
    /*
     * Instance variables;
     */
    private Rectangle ball;     // the ball we'll bounce
    private int dx;             // how far it goes as x
    private int dy;             // how far in y
    
    // Double-buffering variables
    private Image canvas;       // The off-screen canvas
    private Graphics invisiPen; // The off-screen pen
    
    // Time (in milliseconds) for each frame
    private static final int PAUSE_TIME = 20; 
    
    /**
     *  Initialize the animation.
     */
    public void init()
    {
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
        // Create and draw the current frame
        createAFrame();                     // paint off-screen
        pen.drawImage(canvas, 0, 0, null);  // render the image
        
        // Pause for the next frame
        try {
            Thread.sleep(PAUSE_TIME);
        } catch (InterruptedException e) { /* do nothing */ }
        
        // Advance to the next frame
        repaint();
    }
    
    /**
     * Skip erasing when updating so we don't flicker.
     */
    public void update(Graphics pen)
    {
        paint(pen);
    }
    
    /**
     *  Paint the current frame on the off-screen image.
     */
    public void createAFrame()
    {
        int w = getWidth();
        int h = getHeight();
        
        // Initialize the off-screen canvas and pen just once
        if (invisiPen == null)
        {
            canvas = createImage(w, h);
            invisiPen = canvas.getGraphics();
        }
        
        // Draw a nice checkerboard on the screen
        invisiPen.setColor(Color.WHITE);
        invisiPen.fillRect(0, 0, w, h);
        invisiPen.setColor(Color.BLACK);
        invisiPen.fillRect(0, 0, w/3, h/2);
        invisiPen.fillRect(w/3, h/2, w/3, h/2);
        invisiPen.fillRect(w-w/3, 0, w/3, h/2);

        // Move and then draw the ball
        ball.translate(dx, dy);
        invisiPen.setColor(Color.RED);
        invisiPen.fillOval(ball.x, ball.y, ball.width, ball.height);
        
        // Check if we've encountered the edges
        if (ball.x < 0 || ball.x + ball.width >= getWidth())
            dx = -dx;
        if (ball.y < 0 || ball.y + ball.height >= getHeight())
            dy = -dy;        
    }
}

