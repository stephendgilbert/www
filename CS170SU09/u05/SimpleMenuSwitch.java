import acm.program.*;
import acm.io.*;

/**
 *  A simple menu using a switch statement.
 *
 *  @author Stephen Gilbert
 *  @version Jan 29, 2009 2:37:27 PM
 */
public class SimpleMenuSwitch extends ConsoleProgram
{
    /**
     *  Asks the user for a menu selection.
     */
    public void run()
    {
        println("The CS 170 Commissary");
        println("---------------------");
        println("  1) Twinkies");
        println("  2) Tofu");
        println("---------------------");
        int choice = readInt("  Your choice >>> ");
        println();
        
        // The switch statement
        switch (choice)
        {
            case 1:
                println("Here's your healthy Twinkies");
                break;
            case 2:
                println("Here's your tasty Tofu");
                break;
            default:
                println("What? Is " + choice + " on the menu?");
        }

    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new SimpleMenuSwitch().start(args);
    }
}
