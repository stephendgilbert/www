import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  Illustrates using mouse motion events in an applet.
 *
 *  @author Stephen Gilbert
 *  @version Mar 12, 2009 1:16:51 PM
 */
public class FirstEventApplet extends Applet 
                              implements MouseMotionListener
{
    /**
     *  Hook up mouse events in the applet.
     */
    public void init()
    {
        addMouseMotionListener(this);
    }
    
    /**
     *  Set background to a random color and display mouse location.
     */
    public void mouseMoved(MouseEvent e)
    {
        int color = (int)(Math.abs(Math.random() * Integer.MAX_VALUE));
        setBackground(new Color(color));
        
        showStatus("Mouse location: (" + e.getX() + "," + e.getY() + ")");
    }

    /**
     * Do nothing when dragged.
     */
    public void mouseDragged(MouseEvent arg0)
    {
        // Nothing to do.
    }
}
