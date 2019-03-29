import acm.program.*;
import static java.lang.String.*;

/**
 *  Calculates the count, average and 
 *  sum of a sequence of positive integers.
 *  Uses break instead of a primed loop.
 *
 *  @author Stephen Gilbert
 *  @version Jan 29, 2009 3:43:49 PM
 */
public class PositiveMean2 extends ConsoleProgram
{
    /**
     * Reads an indefinite series of positive integers.  
     */
    public void run()
    {
        println("This program adds a list of integers.");
        println("Enter values, one per line.");
        println("End by entering a negative number.");
        println();
        
        // The preconditions
        int count = 0;
        int sum = 0;
        
        while (true)        // infinite loop bounds
        {
            // 1. Get the input
            int num = readInt(" > ");
            
            // 2. Check the intentional loop bounds
            if (num < 0) break;
            
            // 3. Process this iteration
            count++;            // increment counter
            sum += num;         // add to running total
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
        new PositiveMean2().start(args);
    }
}
