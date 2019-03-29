import acm.program.*;
import static java.lang.String.*;

/**
 *  Calculates the count, average and 
 *  sum of a sequence of positive integers.
 *
 *  @author Stephen Gilbert
 *  @version Jan 29, 2009 3:43:49 PM
 */
public class PositiveMean extends ConsoleProgram
{
    /**
     * Reads an indefinite series of positive integers.  
     */
    public void run()
    {
        println("Enter positive whole numbers.");
        println("End with a negative number.");
        
        // The preconditions
        int count = 0;
        int sum = 0;
        
        int num = readInt();    // read first number
        
        while (num >= 0)        // the loop bounds
        {
            // loop actions
            count++;            // increment counter
            sum += num;         // add to running total
            num = readInt();    // read next number
        }
        
        // postcondition
        if (count > 0)
            println(format("Count = %d, Sum = %d, Mean = %.2f",
                count, sum, (double)sum / count));
        else
            println("No positive integers entered.");
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new PositiveMean().start(args);
    }
}
