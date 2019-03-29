import acm.program.*;
import acm.io.*;
import java.util.*;

/**
 *  InputArray.java.
 *  CS 170 Exercise 2009
 *  Adding items to a "partially filled" array
 *  
 *  @author Stephen Gilbert
 *  @version 3.0, Apr 16, 2009 2:01:04 PM
 */
public class InputArray extends ConsoleProgram
{
    /**
     *  Adds items to a partially filled array.
     */
    public void run()
    {
        // 1. Use a Scanner to read multiple numbers on one line
        Scanner scan = new Scanner(this.getReader());
        
        // 2. Here's our array, its capacity and its size
        double[] ar = new double[100];
        int capacity = ar.length;
        int size = 0;
        
        // 3. Tell the user what to do
        println("Enter up to " + capacity + " positive real numbers.");
        println("Enter 0 or a negative number to quit.");
        
        // Use a loop to control input
        while (size < capacity)
        {
            // 4. Read a number
            double num = scan.nextDouble();
            
            // 5. If the user wants to exit, then leave
            if (num <= 0)
                break;
            
            // 6. Otherwise store the number at size
            ar[size] = num;
            
            // 7. Increment the size
            size++;
        }
        
        // 8. Display results in array-literal form
        print("ar = {");        // Display  opening brace
        if (size > 0)
        {
            print(ar[0]);       // print first element

            // Then remaining elements with commas in front
            for (int i = 1; i < size; i++)
                print(", " + ar[i]);
        }        
        println("}");       // print closing brace and linefeed
        
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new InputArray().start(args);
    }
}
