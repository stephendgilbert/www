import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Toolbar.java. Illustrates using arrays of object variables.
 *
 * @author Stephen Gilbert
 * @version 3.0, 2009
 */

public class Toolbar extends JApplet implements ActionListener
{
    // Attributes
    private String slogan = "CS 170 : Java, Java Java!!!";
    private JButton[] toolBar = new JButton[5];
    private JPanel canvas = new JPanel();

    /**
     * Initialize the toolbar and layout the applet.
     */
    public void init()
    {
        // 1. Toolbar Panel
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        p.setBackground(Color.lightGray);

        // 2. Create the toolBar Buttons
        String[] captions = { "Red", "Blue", "Green", "Yellow", "Black" };

        // 3. Create each button
        for (int i = 0; i < toolBar.length; i++)
        {
            toolBar[i] = new JButton(captions[i]);
            toolBar[i].addActionListener(this);
            p.add(toolBar[i]);
        }

        // 5. Add the Panel to the top of the applet
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(p, BorderLayout.NORTH);
        c.add(canvas, BorderLayout.CENTER);
    }

    /**
     * Paint the slogan on the the screen.
     * @param pen is the Graphics pen used to paint with.
     */
    public void paint(Graphics pen)
    {
        super.paint(pen);
        int height = getHeight();
        int width = getWidth();

        pen.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 36));
        FontMetrics fm = pen.getFontMetrics();
        int strWidth = fm.stringWidth(slogan);

        int x = width / 2 - (strWidth / 2);
        int y = height / 2 + (fm.getHeight() / 2);

        pen.setColor(Color.white);
        pen.drawString(slogan, x, y);
    }

    /**
     * Handle the clicks on the different buttons in the toolBar array.
     * @param ae is the ActionEvent parameter
     */
    public void actionPerformed(ActionEvent ae)
    {
        // 1. Retrieve source of click
        Object obj = ae.getSource();

        // 2. Match it with toolBar Button
        int clicked;
        for (clicked = 0; clicked < toolBar.length; clicked++)
        {
            if (obj == toolBar[clicked]) break;
        }

        // 3. Take action based upon Button pressed
        switch (clicked)
        {
            case 0:
                canvas.setBackground(Color.RED);
                break;
            case 1:
                canvas.setBackground(Color.BLUE);
                break;
            case 2:
                canvas.setBackground(Color.GREEN);
                break;
            case 3:
                canvas.setBackground(Color.YELLOW);
                break;
            case 4:
                canvas.setBackground(Color.BLACK);
                break;
        }

        repaint();
    }
}
