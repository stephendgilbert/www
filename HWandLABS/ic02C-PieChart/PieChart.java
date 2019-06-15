import java.applet.*;
import java.awt.*;
import javax.swing.*;
/**
 *  PieChart - an applet that displays graphics.
 *
 *  @author (place your name here)
 *  @version (put the date here)
 */
public class PieChart extends Applet
{
    // USE THESE INSTANCE VARIABLES FOR PERCENTAGES
    double rent = .25 + Math.random() * .2;
    double education = .15 + (Math.random() * .15);
    double misc = .05 + (Math.random() * .05);
    double food = (1 - (rent + education + misc)) * (.75 * Math.random());
    double transportation = 1 - (rent + education + food + misc);


    /**
     *  Color the background or set the font here.
     */
    public void init()
    {
        // Leave this line alone.
        setFrameSize();
        //TODO: add your program code here
    }

    /**
     *  Draw your pie chart and legend here.
     */
    public void paint(Graphics g)
    {
        // NOTE: Leave these two lines. They allow
        // your drawings (using pen, NOT g) to appear
        // without the "jaggies" you get from raw graphics.
        Graphics2D pen = (Graphics2D) g;
        pen.setRenderingHint (RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

    
    }

    /**
     * Just ignore this; it lets me set the size in DrJava.
     */
    private void setFrameSize()
    {
        Container c = this;
        while (c != null && ! (c instanceof JFrame))
            c = c.getParent();
        // Assume 96 DPI for this assignment
        if (c != null) {
            c.setSize(new Dimension(500, 375));
        }
    }

}
