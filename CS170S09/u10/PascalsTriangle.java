import java.util.Scanner;

/**
 *  A CS 170 homework assignment. 
 *  Compute Pascal's triangle and illustrate the use of 
 *  the Eclipse debugger.
 *  
 *  @author <your name goes here>
 *  @version <put the date here>
 *  
 *  The code below is chosen to illustrate the debugger.
 *  It is neither the most efficient nor the most reliable
 *  way to solve this problem.
 */
public class PascalsTriangle
{
    /**
     *     To skip n spaces on a line.
     *     @param n the number of spaces to skip
     * 
     *     n should be non-negative.
     */
    void skip(int n)
    {
        int i; // a counter

        for (i = 0; i <= n; i++)
            System.out.print(" ");
    }

    /**
     *     To calculate n factorial.
     *     @param n calculate the factorial of n
     *     @return n factorial
     * 
     *     n must be >= 0. Also if n is too large, overflow may result.
     */
    int factorial(int n)
    {
        int product; /*  accumulator for the running product  */
        int i; /*  a counter  */

        product = 1;
        for (i = 1; i <= n; i++)
        {
            product = product + i ;
        }
        return (product);
    }

    /**
     *  To calculate the number of combinations of n things taken.
     *  k at a time (n choose k)
     * 
     *  @param n the number of items to choose from
     *  @param k the number of items choosen
     *  @return n choose k
     * 
     *  n and k must be non-negative and k <= n.  This program uses
     *  the formula (n choose k) = n! / ( k! * (n-k)! ).
     */
    int combination(int n, int k)
    {
        int comb = factorial(n) / factorial(k) * factorial(n-k);

        return comb;
    }

    void run()
    {
        int nrows; /*  the number of rows to print  */
        int n; /*  a counter for the current row  */
        int k; /*  a counter for the current column  */
        int comb; /*  the number of combinations  */
        int spaces_to_skip; /*  spaces to skip  */

        System.out.print("Enter the number of rows (<=13)");
        System.out.print(" in Pascal's triangle: ");
        
        Scanner cin = new Scanner(System.in);
        nrows = cin.nextInt();
        System.out.print("\n\n\n");

        /*  print the title  * /
         skip(16);
         System.out.printf("TABLE 1: THE FIRST %d", nrows); 
         System.out.print(" ROWS OF PASCAL'S TRIANGLE\n\n");

         / *  start a loop over the number of rows  */
        spaces_to_skip = 36;

        for (n = 0; n < nrows - 1; n = n + 2)
        {
            skip(spaces_to_skip); /* space to make a triangle */
            spaces_to_skip = spaces_to_skip - 2;

            for (k = 0; k <= n; k++)
            {
                comb = combination(n, k);
                System.out.printf("%4d", comb);
            }

            System.out.println();
        }
    }
    
    /**
     * The main() method starts the program running.
     */
    public static void main(String[] args)
    {
        new PascalsTriangle().run();
    }
}
