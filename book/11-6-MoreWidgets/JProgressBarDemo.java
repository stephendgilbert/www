import acm.program.*;
import acm.graphics.*;
import acm.gui.*;
import javax.swing.*;
import java.awt.*;
/**
 * Use a JProgressBar object.
 * 
 * @author Steve Gilbert
 * @version Fall 2011
 */
public class JProgressBarDemo extends GraphicsProgram
{
    private GTurtle tim;
    private JSlider direction;
    private JProgressBar progress = new JProgressBar();

    /**
     * Create the turtles and sliders.
     */
    public void init()
    {
        // Create the turtle
        tim = new GTurtle();
        tim.setDirection(Math.random() * 360);
        tim.setSpeed(.5);
        add(tim, getWidth() / 2, getHeight() / 2);
        
        // Customize the progress bar
        progress.setBorderPainted(true);
        progress.setStringPainted(true);


        // Direction slider
        direction = new JSlider(0, 360, (int)(Math.random() * 360));
        direction.setMajorTickSpacing(90);
        direction.setMinorTickSpacing(15);
        direction.setPaintTicks(true);
        direction.setPaintLabels(true);
        
        // Change the layout manager for the slider
        getRegionPanel(SOUTH).setLayout(new TableLayout(2, 2, 25, 5));
        
        // Size the components
        Dimension size = direction.getMinimumSize();
        size.width = getWidth() / 3;
        direction.setMinimumSize(size);
        
        // Add the labels
        add(new JLabel("Direction", JLabel.CENTER), SOUTH);
        add(new JLabel("Progress", JLabel.CENTER), SOUTH);
        add(direction, SOUTH);
        add(progress, SOUTH);
        
    }

    /**
     * Run the animation.
     */
    public void run()
    {
        waitForClick();
        
        int jobLength = 30 * 60;             // 1 minute
        progress.setMaximum(jobLength);
        progress.setString(null);            // display % while painting
        
        int curVal = 0;
        progress.setValue(curVal);           // start at 0
        
        final int FRAME_RATE = 1000 / 30;
        do {
            tim.setDirection(direction.getValue());
            tim.forward(2.5);
            progress.setValue(++curVal);     // update the progress
            
            pause(FRAME_RATE);
        } while (progress.getValue() < jobLength);  // stop when finished
        
        progress.setValue(jobLength);          // report when finished
        progress.setString("All Finished");
    }
    
    /**
     * Set the look and feel.
     */
    public static void main(String[] args)
    {
        //LAF.setSystemLAF();
        new JProgressBarDemo().start(args);
    }
}