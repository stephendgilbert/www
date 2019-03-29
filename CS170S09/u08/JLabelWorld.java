import acm.program.*;
import acm.graphics.*;
import javax.swing.*;
import java.awt.*;
/**
 *  Using JLabels in your GraphicsProgram.
 *
 *  @author Stephen Gilbert
 *  @version Mar 11, 2009 1:02:57 PM
 */
public class JLabelWorld extends GraphicsProgram
{
    // 1. Create the widget instance variables
    private JLabel myWidget;
    
    /**
     * Set up the widgets.
     */
    public void init()
    {
        // 2. Create and initialize your widget
        myWidget = new JLabel("This is the first widget!!!");
        myWidget.setBackground(Color.YELLOW);   // additional
        myWidget.setOpaque(true);               // solid background
        
        // 3. Add your widget to the surface of your program
        add(myWidget, NORTH);
        
        // 4. Create a local widget variable
        JLabel myWidget2 = new JLabel("Range Rover",
            new ImageIcon("car1.gif"), JLabel.CENTER);
        add(myWidget2, NORTH);
        
        // Align the label contents
        myWidget2.setVerticalAlignment(JLabel.CENTER);      // icon
        myWidget2.setHorizontalAlignment(JLabel.CENTER);    // icon
        myWidget2.setHorizontalTextPosition(JLabel.CENTER); // text
        myWidget2.setVerticalTextPosition(JLabel.BOTTOM);   // text
        myWidget2.setIconTextGap(5);                // 5 pixels gap
        
        // 5. Create and display an "un-named" widget
        add(new JLabel(new ImageIcon("cards/as.gif")), NORTH);
        
        // 6. Add a widget to the program's canvas
        JLabel myWidget3 = new JLabel();
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
        new JLabelWorld().start(args);
    }
}
