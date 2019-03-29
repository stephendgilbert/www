import acm.program.*;
import acm.graphics.*;
/**
 *  My first ACM graphical application.
 *
 *  @author Stephen Gilbert
 *  @version Mar 4, 2009 4:08:09 PM
 */
public class FirstGUIApp extends GraphicsProgram
{
    /**
     *  Uses objects to display a message on the screen.
     */
    public void run()
    {
        GLabel helloLabel = new GLabel("Hello. I love you!", 25, 25);
        add(helloLabel);
        
        GLabel question = new GLabel("Won't you tell me your name?");
        add(question, 25, 40);
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new FirstGUIApp().start(args);
    }
}
