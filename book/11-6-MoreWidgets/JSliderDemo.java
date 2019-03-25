import acm.program.*;
import acm.graphics.*;
import acm.gui.*;
import javax.swing.*;
import java.awt.*;
/**
 * Use some JSlider objects.
 * 
 * @author Steve Gilbert
 * @version Fall 2011
 */
public class JSliderDemo extends GraphicsProgram
{
    private GTurtle tim;
    private JSlider direction, speed;

    /**
     * Create the turtles and sliders.
     */
    public void init()
    {
        // If you want the native look-and-feel widgets
        //LAF.setSystemLAF(); 
        
        // Create the turtle
        tim = new GTurtle();
        tim.setDirection(Math.random() * 360);
        tim.setSpeed(.5);
        add(tim, getWidth() / 2, getHeight() / 2);
        
        // Create a speed and a direction slider
        speed = new JSlider(5, 25);
        speed.setMajorTickSpacing(5);
        speed.setMinorTickSpacing(1);
        speed.setPaintTicks(true);
        speed.setPaintLabels(true);
        
        direction = new JSlider(0, 360, (int)(Math.random() * 360));
        
        // Customize the direction slider
        direction.setMajorTickSpacing(90);
        direction.setMinorTickSpacing(15);
        direction.setPaintTicks(true);
        direction.setPaintLabels(true);
        
        // Change the layout manager for the slider
        getRegionPanel(SOUTH).setLayout(new TableLayout(2, 2));
        
        // Size the components
        Dimension size = direction.getMinimumSize();
        size.width = getWidth() / 3;
        direction.setMinimumSize(size);
        
        size = speed.getMinimumSize();
        size.width = getWidth() / 3;
        speed.setMinimumSize(size);

        // Add the labels
        add(new JLabel("Speed", JLabel.CENTER), SOUTH);
        add(new JLabel("Direction", JLabel.CENTER), SOUTH);
        add(speed, SOUTH);
        add(direction, SOUTH);
        
    }

    /**
     * Run the animation.
     */
    public void run()
    {
        final int FRAME_RATE = 1000 / 30;
        do {
            tim.setDirection(direction.getValue());
            tim.forward(speed.getValue() / 5.0);
            pause(FRAME_RATE);
        } while (true);
    }
    
    /**
     * Set the look and feel.
     */
    public static void main(String[] args)
    {
        LAF.setSystemLAF();
        new JSliderDemo().start(args);
    }
}