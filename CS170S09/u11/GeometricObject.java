import java.awt.Color;
import java.util.Date;
/**
 * GeometricObject represents a basic shape class.
 * Based on GeometricObject1 Liang 7th
 * 
 * @author Stephen Gilbert
 * @version Apr 30, 2009 1:25:53 PM
 * 
 */
public class GeometricObject
{
    private Color color = Color.WHITE;
    private boolean filled;
    private Date dateCreated;

    /** 
     * Construct a default geometric object.
     */
    public GeometricObject()
    {
        dateCreated = new Date(); // System time.
    }
    
    /**
     * Constructs a GeometricObject with a given color and filled state.
     * @param color the initial color of the object
     * @param filled whether the object is filled
     */
    public GeometricObject(Color color, boolean filled)
    {
        this(); // set the date
        this.color = color;
        this.filled = filled;
    }

    /** 
     * Return current color.
     * @return current color.
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Return true if the object is filled.
     * @return true if the object is filled. 
     */
    public boolean isFilled()
    {
        return filled;
    }

    /** 
     * Set a new filled value. 
     * @param filled the new filled value.
     */
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }

    /** 
     * Get dateCreated.
     * @return the date the object was created.
     */
    public Date getDateCreated()
    {
        return dateCreated;
    }

    /** 
     * Return a string representation of this object.
     */
    public String toString()
    {
        return "created on " + dateCreated + "\ncolor: " + color
            + " and filled: " + filled;
    }
}
