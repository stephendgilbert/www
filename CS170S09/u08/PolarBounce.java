import acm.program.*;
import acm.graphics.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Bounce a ball using polar coordinates.
 *
 *  @author Stephen Gilbert
 *  @version Mar 13, 2009 11:03:42 AM
 */
public class PolarBounce extends GraphicsProgram
{
    /*
     * Instance variables;
     */
    private GOval ball;         // the ball we'll bounce
    private double distance;    // how far it goes
    private double direction;   // direction it is traveling
    
    // Time (in milliseconds) for each frame
    private static final int PAUSE_TIME = 20; 

    /**
     * Initialize the variables and the screen
     */
    public void init()
    {
        // A black background
        setBackground(Color.BLACK);
        add(new JLabel("Click to start bouncing."), NORTH);
        
        // A 50 pixel solid yellow ball, centered on display
        ball = new GOval(50, 50);   
        ball.setColor(Color.YELLOW);
        ball.setFillColor(Color.YELLOW);
        ball.setFilled(true);
        add(ball, getWidth() / 2 - 25, getHeight() / 2 - 25);
        
        // A random direction and velocity
        direction = Math.random() * 360;
        distance = 2 + Math.random() * 10;  // at least 2
        
        // Hook up mouse events
        ball.addMouseListener(this);
        // addMouseListeners();
    }
    
    /**
     *  The basic animation loop for every program.
     */
    public void run()
    {
        waitForClick(); // wait for a mouse click to start
        while (true)
        {
            advanceOneFrame();
            pause(PAUSE_TIME);
        }
    }
    
    /**
     * Move the ball. If the ball hits any of the
     * walls, then adjust the direction of travel.
     */
    public void advanceOneFrame()
    {
        // Move the ball
        ball.movePolar(distance, direction);
        
        // See where it is and adjust distance and direction
        double left = ball.getX();
        double right = left + ball.getWidth();
        double top = ball.getY();
        double bottom = top + ball.getHeight();
        
        // Hit the walls?
        if (left <= 0 || right >= getWidth())
        {
            direction = 180 - direction;
        }
        
        // Hit the floor or ceiling?
        if (top < 0 || bottom > getHeight())
        {
            direction = 360 - direction;
        }
    }
    
    /**
     * Click the ball and set it off in a random direction.
     */
    public void mousePressed(MouseEvent e)
    {
        direction = Math.random() * 360;
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new PolarBounce().start(args);
    }
}
