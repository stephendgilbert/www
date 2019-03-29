import java.util.*;
/**
 * GasMileage.java - calculated mileage based on user input.
 *
 * @author Stephen Gilbert
 * @version Spring 2009
 */

public class GasMileage
{
   public static void main (String[] args)
   {
      Scanner scan = new Scanner (System.in);

      System.out.print ("Enter the number of miles: ");
      int miles = scan.nextInt();

      System.out.print ("Enter the gallons of fuel used: ");
      double gallons = scan.nextDouble();

      double mpg = miles / gallons;

      System.out.println ("Miles Per Gallon: " + mpg);
   }
}


