import java.awt.*;
import acm.graphics.*;

/**
 *  Represents an ACM bouncing ball.
 *
 *  @author Stephen Gilbert
 *  @version Apr 25, 2009 2:21:42 PM
 *
 */
public class GBall extends GOval
{
    private double distance;    // how far it goes
    private double direction;   // direction it is traveling
    
    /**
     * Working constructor.
     * @param radius radius of the ball.
     * @param location point where the center of the ball appears
     * @param color fill color of the ball
     */
    public GBall(double radius, Point location, Color color)
    {
        // Call the superclass constructor using the parameters
        super(location.x - radius, location.y - radius,
            radius * 2, radius * 2);
        
        setFillColor(color);
        setFilled(true);
        
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
        
        // See where it is and adjust distance and direction
        // Hit the walls?
        if (getX() <= 0 || getX() + getWidth() >= canvas.getWidth())
        {
            direction = 180 - direction;
        }
        
        // Hit the floor or ceiling?
        if (getY() <= 0 || getY() + getHeight() >= canvas.getHeight())
        {
            direction = 360 - direction;
        }        
    }
}


