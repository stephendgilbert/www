import acm.program.*;
import acm.io.*;

/**
 *  Demonstrates basic array handling.
 *
 *  @author Stephen Gilbert
 *  @version Feb 4, 2009 1:58:12 PM
 */
public class BasicArray extends ConsoleProgram
{
    /**
     *  Creates an array, fills it with various integer 
     *  values, modifies one value, then prints them out.
     */
    public void run()
    {
        final int LIMIT = 15, MULTIPLE = 10;

        int[] list = new int[LIMIT];
        
        //  Initialize the array values
        for (int index = 0; index < LIMIT; index++)
           list[index] = index * MULTIPLE;
        
        list[5] = 999;  // change one array value
        
        //  Print the array values
        for (int value : list)
           print (value + "  ");
        println();
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new BasicArray().start(args);
    }
}
