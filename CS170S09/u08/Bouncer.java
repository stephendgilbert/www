import acm.program.*;
import acm.graphics.*;

import java.awt.*;
import java.awt.event.*;

/**
 *  Bounce a ball using polar coordinates.
 *
 *  @author (your name goes here)
 *  @version (place the date here)
 */
public class Bouncer extends GraphicsProgram
{
    /**
     *  Place a one-sentence description of your run method here.
     *  The run() method is the entry-point for your program.
     */
    public void run()
    {
        double velocity = 5;
        double friction = .001;
        double angle = 270 + Math.random() * 90;
        
        GOval ball = new GOval(0, 0, 30, 30);
        ball.setFilled(true);
        ball.setFillColor(Color.RED);
        add(ball);
        //TODO: add your program code here
        while (velocity > 0)
        {
            ball.movePolar(velocity, angle);
            pause(10);
            if (velocity > 0) velocity -= friction;
            friction -= .0000001;
            if (ball.getX() + ball.getWidth() >= getWidth() || ball.getX() <= 0)
            {
                angle = 360 - angle + 180;
            }
            if (ball.getY() + ball.getHeight() >= getHeight() || ball.getY() <= 0)
            {
                angle = 360 - angle;
            }
        }
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new Bouncer().start(args);
    }
}
