import java.awt.Color;

import acm.program.*;
import acm.graphics.*;
/**
 *  Display the coordinate system on the screen.
 *
 *  @author Stephen Gilbert
 *  @version Mar 9, 2009 1:11:51 PM
 */
public class Coordinates extends GraphicsProgram
{
    /**
     *  Display coordinates on the screen
     */
    public void run()
    {
        double width = getWidth();
        double height = getHeight();
        double columns = width / 10;
        double rows = height / 10;
        
        for (double i = columns; i < width; i+= columns)
        {
            add(new GLine(i, 0, i, height));
        }
        for (double i = rows; i < height; i += rows)
        {
            add(new GLine(0, i, width, i));
        }
        
        GRect rect = new GRect(columns * 2, rows * 2, width / 5, height/5);
        rect.setFillColor(Color.YELLOW);
        rect.setColor(Color.RED);
        rect.setFilled(true);
        add(rect);
        
        GRoundRect label = new GRoundRect(90, 35, 200, 40);
        label.setFillColor(Color.WHITE);
        label.setFilled(true);
        add(label);
        GLabel xy = new GLabel(String.format("x (%.2f), y (%.2f)", 
            columns * 2, rows * 2));
        xy.setFont("SansSerif-bold-18");
        add(xy, 100, 60);
        
        GOval point = new GOval(columns * 2 - 5, rows * 2 - 5, 10, 10);
        point.setFilled(true);
        point.setFillColor(Color.GREEN);
        add(point);
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new Coordinates().start(args);
    }
}
