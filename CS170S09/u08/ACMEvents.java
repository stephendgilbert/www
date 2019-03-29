import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
/**
 *  Shows how to use the mouse to resize an object on screen.
 *
 *  @author Stephen Gilbert
 *  @version Mar 12, 2009 4:21:46 PM
 */
public class ACMEvents extends GraphicsProgram
{
    private GOval circle;
    
    public void init()
    {
        circle = new GOval(50, 50);
        circle.setFilled(true);
        circle.setFillColor(Color.RED);
        add(circle, getWidth() / 2 - circle.getWidth() / 2, 
            getHeight() / 2 - circle.getHeight() / 2);
        
        addMouseListeners();
    }
    
    
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new ACMEvents().start(args);
    }
}
