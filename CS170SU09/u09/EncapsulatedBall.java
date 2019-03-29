import java.awt.*;
/**
 *  A bouncing ball with private fields.
 *
 *  @author Stephen Gilbert
 *  @version Mar 20, 2009 11:50:31 AM
 */
public class EncapsulatedBall
{
    /**
     * Let's have the ball "draw" itself.
     *
     *  @param pen used to draw the ball on the screen
     */
    public void draw(Graphics pen)
    {
        Color oldColor = pen.getColor();    // save original color
        
        pen.setColor(getColor());
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

    /**
     * This mutator modifies both dx and dy
     *
     *  @param dx the new value for dx
     *  @param dy the new value for dy
     */
    public void setSpeed(int dx, int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }
    
    /**
     *  This mutator modifies the radius using radius
     *
     *  @param radius the radius to set
     */
    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    /**
     *  This mutator modifies the location using location
     *
     *  @param location the location to set
     */
    public void setLocation(Point location)
    {
        this.location = location;
    }

    /**
     *  This mutator modifies the color using color
     *
     *  @param color the color to set
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     *  This accessor returns the color
     *  
     *  @return the color
     */
    public Color getColor()
    {
        return color;
    }




    // Instance variables -----------------------------------
    /** Radius of the ball */
    private int radius;
    
    /** Location of this ball */
    private Point location;
    
    /** Horizontal velocity of this ball */
    private int dx;
    
    /** Vertical velocity of this ball */
    private int dy;
    
    /** Color of this ball */
    private Color color;

}
