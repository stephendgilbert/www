import acm.program.*;
import acm.graphics.*;
import java.awt.*;

/**
 * Display different GObject methods.
 * 
 * @author Stephen Gilbert
 * @version Mar 9, 2009 2:54:31 PM
 */
public class GObjectMethods extends GraphicsProgram
{
    /**
     * Create some GObjects and call some methods.
     */
    public void run()
    {
        // Create two GObject variables
        GObject a = new GRect(10, 100, 200, 300);
        GObject b = new GOval(150, 200, 180, 200);

        // Add a first, then b
        add(a);
        add(b);

        // Line Color
        a.setColor(Color.BLUE);
        b.setColor(Color.GREEN);

        // Get the location of the objects
        double x = a.getX(); // horizontal location
        double y = a.getY(); // vertical location

        GPoint pt = b.getLocation(); // both a and y

        // Print the location
        add(new GLabel(String.format("x=%.2f, y=%.2f", x, y), 50, 150));
        add(new GLabel("pt = " + pt.toString(), 50, 180));

        // Set the location of objects
        a.setLocation(pt);      // Set a to the point where b was located
        b.setLocation(0, 0);    // Set b to the origin

        b.move(50, 50);         // Move b 50 down from the origin
        a.movePolar(100, 120);  // Move a 100 units in the 120 degree direction
    
    
        // Get the size of different objects
        double width = a.getWidth();
        double height = a.getHeight();
        
        GDimension size = b.getSize();
        GRectangle rect = a.getBounds();
        
    
    }

    /**
     * The standard Java entry point. DON'T MODIFY.
     * 
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new GObjectMethods().start(args);
    }
}
