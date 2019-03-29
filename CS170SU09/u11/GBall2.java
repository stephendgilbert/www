import acm.graphics.*;

import java.awt.*;
/**
 *  Create a bouncing ball using composition and GCompound.
 *
 *  @author Stephen Gilbert
 *  @version Apr 28, 2009 10:45:46 AM
 *
 */
public class GBall2 extends GCompound
{
    // Instance variables
    private GOval ball;
    private double distance;    // how far it goes
    private double direction;   // direction it is traveling

    /**
     * Working constructor.
     * @param radius radius of the ball.
     * @param location point where the center of the ball appears
     * @param color fill color of the ball
     */
    public GBall2(double radius, Point location, Color color)
    {
        // Center the ball over the GCompound origin
        ball = new GOval(-radius, -radius, radius * 2, radius * 2);
        add(ball);

        // Center the GCompound at location
        setLocation(new GPoint(location));
        
        ball.setFillColor(color);
        ball.setFilled(true);
        
        direction = Math.random() * 360;
        distance = 2 + Math.random() * 10;  // at least 2
    }

    /**
     * Move the ball distance units in direction.
     * @param canvas the GCanvas that the ball is bouncing on.
     */
    public void move(GCanvas canvas)
    {
        movePolar(distance, direction);

        // Locate the sides of the ball.
        double left = getX() - ball.getWidth() / 2;
        double right = left + ball.getWidth();
        double top = getY() - ball.getHeight() / 2;
        double bottom = top + ball.getHeight();
        
        // See where it is and adjust distance and direction
        // Hit the walls?
        if (left <= 0 || right >= canvas.getWidth())
        {
            direction = 180 - direction;
        }
        
        // Hit the floor or ceiling?
        if (top <= 0 || bottom >= canvas.getHeight())
        {
            direction = 360 - direction;
        }        
    }    
}







