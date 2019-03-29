import java.util.Scanner;

/**
 *  LoopBuilding.java: A CS 170 example program.
 *  Building a loop step, by step using Cooper's
 *  loop-building strategy.
 *
 *    @author (Put your name here)
 *    @version (Put today's date here)
 */

public class LoopBuilding
{
    /**
     * Counts the characters in a String until a period
     * is encountered. Assumes the String contains a period.
     *
     * @param str the String to count.
     */
    public int charsInFirstSentence(String str)
    {
        // You'll write your code here
        return 0;
    }

    /**
     *  Runs the program.
     */
    public static void main(String[] args)
    {
        LoopBuilding app = new LoopBuilding();
        Scanner cin = new Scanner(System.in);

        System.out.println("Enter one or more sentences. Enter to quit.");
        String line = cin.nextLine();
        while (line.length() > 0)
        {
            System.out.print("There are ");
            System.out.print(app.charsInFirstSentence(line));
            System.out.println(" chars in the first sentence.");

            line = cin.nextLine();
        }
    }

}
