import acm.program.*;
import acm.util.*;
import java.util.*;
import static java.lang.String.*;
import static java.lang.Math.*;

/**
 *  A program guessing game using a flag-controlled loop.
 *
 *  @author Stephen Gilbert
 *  @version Jan 29, 2009 3:21:53 PM
 */
public class GuessOMatic extends ConsoleProgram
{
    /**
     *  Guess a random number between 1 and 100.
     */
    public void run()
    {
        printWelcome(); 
        
        double payout = 2.0;
        int tries = 0;
        boolean done = false;
        int theNumber = (int)(random() * 100) + 1;
        
        while (!done)
        {
            print(format("Payout is $%.2f. Your guess", payout));
            int theGuess = readInt("? ", 1, 100);
            tries++;
            
            if (theGuess == theNumber)
            {
                 done = true;
            }
            else
            {
                payout -= .25;
                if (theGuess < theNumber)
                    println(format("%d is too low.", theGuess));
                else
                    println(format("%d is too high.", theGuess));
            }
        }
        
        println("You guessed the the number (" + theNumber + ") in " 
            + tries + " tries.");
        println(format("Your $1.00 has payed back $%.2f", payout));
    }
    
    public void printWelcome()
    {
        println("The CS170 GuessOMatic");
        println("----------------------------------------------------");
        println("The GuessOMatic will think of a number from 1 to 100.");
        println("Each game costs $1 to play.");
        println("Each missed guess costs you .25");
        println("You can't lose more than you invest.");
        println("-----------------------------------------------------");
    }
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new GuessOMatic().start(args);
    }
}
