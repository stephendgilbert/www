import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Displays a few JButtons using different constructors.
 *
 *  @author Stephen Gilbert
 *  @version Mar 11, 2009 9:06:04 AM
 */
public class JButtonWorld extends GraphicsProgram
{
    private GOval theDot;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    
    /**
     * Initialize the components.
     */
    public void init()
    {
        // Size the app itself
        setSize(400, 250);
        setBackground(new Color(196, 196, 255));
        
        // 1. Create three JButtons
        btn1 = new JButton(new ImageIcon("car1.gif"));
        btn2 = new JButton("Plain Text");
        btn3 = new JButton("car2.gif", new ImageIcon("car2.gif"));

        // 2. Set mnemonics & tooltips for JButtons
        btn1.setMnemonic(KeyEvent.VK_F1);
        btn1.setToolTipText("Click here to order a red Range Rover");
        btn2.setMnemonic('P');
        btn2.setToolTipText("This is only text");
        btn3.setMnemonic(KeyEvent.VK_1); // Alt-1
        btn3.setToolTipText("A green VW Touareg");

        // 3. Set the action commands for the buttons
        btn1.setActionCommand("RangeRover");
        btn2.setActionCommand("Contract");
        btn3.setActionCommand("Touareg");

        add(btn1, SOUTH);
        add(btn2, SOUTH);
        add(btn3, SOUTH);
        
        // Add the GOval to the center of the app
        theDot = new GOval(100, 100);
        theDot.setFilled(true);
        theDot.setFillColor(Color.YELLOW);
        add(theDot, getWidth() / 2 - 50, getHeight() / 2 - 70);
    }
    
    /**
     *  Place a one-sentence description of your run method here.
     *  The run() method is the entry-point for your program.
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
        new JButtonWorld().start(args);
    }
}
