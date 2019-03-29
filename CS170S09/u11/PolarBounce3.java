import acm.program.*;
import acm.graphics.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Bounce a new GBall using polar coordinates.
 *  Illustrates problems with extending GOval (contraction).
 *
 *  @author Stephen Gilbert
 *  @version Apr 24, 2009 4:41:56 PM
 */
public class PolarBounce3 extends GraphicsProgram
{
    /*
     * Instance variables;
     */
    private GBall[] bouncers;         // the balls we'll bounce
    
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
        
        // An array of six randomly sized & colored balls
        bouncers = new GBall[6];
        for (int i = 0; i < bouncers.length; i++)
        {
            bouncers[i] = new GBall(randSize(), randPos(), randColor());
            add(bouncers[i]);
        }
    }
    
    //------------ HELPER METHODS -----------------------------
    /**
     * Returns a random size from 10.0 to 39.99 for the ball.
     * @return random size from 10.0 to 39.99 for the ball.
     */
    private double randSize()
    {
        return 10 + (Math.random() * 30);
    }
    
    /**
     *  Returns a random location for the ball.
     *  @return random Point between 0 and width and 0 and height
     */
    private Point randPos()
    {
        return new GPoint(
            25 + Math.random() * (getWidth() - 50), 
            25 + Math.random() * (getHeight() - 50)).toPoint();
    }
    
    /**
     *  Generate a random color for ball.
     *  @return pastel colors all at least 128.
     */
    private Color randColor()
    {
        return new Color((int)(128 + Math.random() * 128),
            (int)(128 + Math.random() * 128),
            (int)(128 + Math.random() * 128));
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
        for (GBall ball: bouncers)
        {
            ball.move(getGCanvas());
            if (ball.getX() <= 0 || 
                ball.getX() + ball.getWidth() >= getWidth())
            {
                ball.setSize(ball.getWidth() * .9, ball.getHeight() * 1.1);
            }
            if (ball.getY() <= 0 || 
                ball.getY() + ball.getHeight() >= getHeight())
            {
                ball.setSize(ball.getWidth() * 1.1, ball.getHeight() * .9);
            }
        }
    }
    
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new PolarBounce3().start(args);
    }
}
