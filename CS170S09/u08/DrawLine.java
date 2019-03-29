import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

/**
 *  Draws interactive lines using rubber-banding.
 *
 *  @author From the JTF tutorial
 *  @version Mar 12, 2009 4:28:40 PM
 */
public class DrawLine extends GraphicsProgram
{
    /**
     * Set up the mouse listeners.
     */
    public void init()
    {
        addMouseListeners();
    }

    // Used to refer to the line in mousePressed and mouseDragged
    private GLine line;
    
    /**
     * When mouse is pressed, create a new line at the mouse location.
     */
    public void mousePressed(MouseEvent e)
    {
        line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
        add(line);
    }
    
    /**
     * When the mouse is dragged, reset the end point.
     */
    public void mouseDragged(MouseEvent e)
    {
        line.setEndPoint(e.getX(), e.getY());
    }

    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new DrawLine().start(args);
    }
}
