import java.awt.*;
import java.applet.*;
/**
 *  This is going to draw a house.
 *
 *  @author  (Add your name here)
 *  @version (Add the date here)
 */
public class Artist extends Applet
{
     /**
     * This will draw a house.
     *
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        // Caption
        g.drawString("(Your name)'s Dream House", 85, 310);

        // Roof
        g.drawLine(10, 110, 310, 110);
        g.drawLine(10, 110, 160, 10);
        g.drawLine(160, 10, 310, 110);

        // House
        g.drawRect(22, 111, 275, 175);

        // Door
        g.fillRect(130, 130, 60, 156);

        // Left window
        g.fillRect(38, 150, 75, 70);
        g.clearRect(58, 151, 35, 68);

        // Right window
        g.fillRect(206, 150, 75, 70);
        g.clearRect(209, 153, 69, 63);
    }

}










