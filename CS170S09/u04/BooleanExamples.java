import acm.program.*;
import acm.io.*;

/**
 *  Some short Boolean and Relational Examples.
 *
 *  @author Stephen Gilbert
 *  @version Spring 2009
 */
public class BooleanExamples extends ConsoleProgram
{
    /**
     *  Create and display some boolean varaibles and values.
     */
    public void run()
    {
        // Boolean variables
        String fileName = readLine("Enter a file name:");
        boolean isSourceCode = fileName.endsWith(".java");
        println(fileName + " ends with .java? " + isSourceCode);

        String answer = readLine("Continue (Yes or No)? ");
        boolean isDone = answer.equalsIgnoreCase("No");
        println(answer + " means you are done? " + isDone);

        // 1. Comparing different types
        float a = 2.34F;
        double b = 2.34;

        println("a == b is " + ( a == b));
        println("a > b is " + (a > b));
        println("a < b is " + (a < b));

        // 2. Comparing two mathematically equivalent values
        double c = .1 * 10.0;
        double d = .1 + .1 + .1 + .1 + .1 + .1+ .1+ .1+ .1+ .1;

        println("c == 1.0 is " + (c == 1.0));
        println("d == 1.0 is " + (d == 1.0));
        println("c == d is " + (c == d));

        // 3. Another example (from Cay Horstmann's Big Java, p. 196)
        double root = Math.sqrt(2);         // square root of 2
        double result = root * root - 2;    // subtract 2 from 2
        println("Subtracting 2 from 2 gives " + result);

        // 4. A check to see if numbers are "close enough"
        final double EPSILON = 10E-14;
        boolean isEqual = Math.abs(c - d) <= EPSILON;
        println("c and d 'isEqual' ? " + isEqual);
        println("result is effectively 0 ? " +
                           (result <= EPSILON));
    }


    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new BooleanExamples().start(args);
    }
}
