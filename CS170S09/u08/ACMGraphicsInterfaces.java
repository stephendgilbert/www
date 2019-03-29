import java.awt.Color;

import acm.program.*;
import acm.graphics.*;
/**
 *  Illustrates the ACM graphics interfaces.
 *
 *  @author Stephen Gilbert
 *  @version Mar 9, 2009 7:53:22 PM
 */
public class ACMGraphicsInterfaces extends GraphicsProgram
{
    /**
     *  Illustrate some ACM graphical interfaces.
     */
    public void run()
    {
        GOval ovalA = new GOval(10, 10, 100, 75);
        GOval ovalB = new GOval(60, 40, 100, 75);
        add(ovalA);
        add(ovalB);
        
        // The GFillable interface
        ovalA.setFillColor(Color.RED);
        ovalA.setColor(Color.BLUE);
        ovalA.setFilled(true);
        
        ovalB.setFillColor(Color.GREEN);
        ovalB.setColor(Color.CYAN);
        // Note that setFilled is false by default
        
        // The GResizable interface
        ovalA.setSize(75, 100); // switch width and height
        
        GDimension newSize = new GDimension(50, 25); // GDimension object
        ovalB.setSize(newSize); // change to new size

        // The GScalable interface
        ovalA.scale(.5); // shrink in both dimensions by 50%
        ovalB.scale(1.5, 2.0); // expand by different width and height factors
        
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new ACMGraphicsInterfaces().start(args);
    }
}
