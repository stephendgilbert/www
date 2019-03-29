import java.awt.*;
/**
 *  A bouncing ball with methods.
 *
 *  @author Stephen Gilbert
 *  @version Mar 20, 2009 11:50:31 AM
 */
public class MethodBall
{
    /**
     * Let's have the ball "draw" itself.
     *
     *  @param pen used to draw the ball on the screen
     */
    public void draw(Graphics pen)
    {
        Color oldColor = pen.getColor();    // save original color
        
        pen.setColor(color);
        pen.fillOval(location.x - radius, location.y - radius, 
            radius * 2, radius * 2);
        
        pen.setColor(oldColor);             // restore original color
        
    }
    
    /////////////////////////////////////////////////////////
    //////////////////// MUTATOR METHODS ////////////////////
    /////////////////////////////////////////////////////////
    /**
     * Move the ball one "step" in both x and y directions.
     * @param boundary surrounding ball "playing field"
     */
    public void move(Rectangle boundary)
    {
        location.translate(dx, dy); // change it by dx and dy
        
        // See if we hit the sides and bounce accordingly
        if (location.x + radius >= boundary.width ||    // hit right wall
               location.x - radius < 0)                 // hit left wall
            bounceHorizontal();
        
        if (location.y + radius >= boundary.height ||   // hit "floor"
                location.y - radius < 0)                // hit "ceiling"
            bounceVertical();
    }
    
    /**
     * "Bounce" off of one of the walls by changing x velocity.
     */
    public void bounceHorizontal()
    {
        dx = -dx;
    }
    
    /**
     * "Bounce" off the floor or ceiling by changing y velocity.
     */
    public void bounceVertical()
    {
        dy = -dy;
    }


    // Instance variables -----------------------------------
    /** Radius of the ball */
    public int radius;
    
    /** Location of this ball */
    public Point location;
    
    /** Horizontal velocity of this ball */
    public int dx;
    
    /** Vertical velocity of this ball */
    public int dy;
    
    /** Color of this ball */
    public Color color;
}
