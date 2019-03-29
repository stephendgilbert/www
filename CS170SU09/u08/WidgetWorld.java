import acm.program.*;
import acm.graphics.*;
import javax.swing.*;
import java.awt.*;
/**
 *  Using Widgets in your GraphicsProgram.
 *
 *  @author (your name goes here)
 *  @version (place the date here)
 */
public class WidgetWorld extends GraphicsProgram
{
    // 1. Create the widget instance variables
    private Widget myWidget;
    
    /**
     * Set up the widgets.
     */
    public void init()
    {
        // 2. Create and initialize your widget
        myWidget = new Widget();
        myWidget.setBackground(Color.YELLOW);  // additional
        
        // 3. Add your widget to the surface of your program
        add(myWidget, NORTH);
        
        // 4. Create a local widget variable
        Widget myWidget2 = new Widget();
        add(myWidget2, NORTH);
        
        // 5. Create and display an "un-named" widget
        add(new Widget(), NORTH);
        
        // 6. Add a widget to the program's canvas
        Widget myWidget3 = new Widget();
        GCanvas canvas = this.getGCanvas();
        canvas.add(myWidget3, 100, 100);
    }
    
    /**
     *  Add some widgets.
     */
    public void run()
    {
        //TODO: add your program code here
        
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new WidgetWorld().start(args);
    }
}
