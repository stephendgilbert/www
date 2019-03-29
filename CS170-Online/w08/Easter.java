import java.util.*;
/**
 * 	Easter.java
 *  Calculates the date of Easter for years 1900-2099.
 *
 *	@author (Add your name here)
 *	@version (Add the date here)
 */

public class Easter
{
    /**
     * The year being calculated.
     */
    private int year;

    /**
     * Constructs an Easter object given the year.
     */
    public Easter(int year)
    {
        this.year = year;
    }

    /**
     * Calculates the date that this Easter object falls on.
     * @return the date that Easter Sunday falls on.
     */
    public GregorianCalendar dateOfEaster()
    {
        /* Your code will go here. The algorithm for
         * calculating Easter Sunday is this:
         *
         * a is year % 19;
         * b is year % 4;
         * c is year % 7;
         * d is (19 * a + 24) % 30
         * e is (2 * b + 4 * c + 6 * d + 5) % 7
         *
         * day is 22 + d + e
         * If day is 31 or less, then it is in
         * March. If it is > 31 then it falls in April,
         * but you need to subtract 31 from the day.
         *
         * If the year is 1954, 1981, 2049 or 2076, then
         * this calculation is actually 7 days later than
         * it should be.
         *
         * If the year is < 1900 or greater than 2099, return
         * the value null.
         */

    }
}
