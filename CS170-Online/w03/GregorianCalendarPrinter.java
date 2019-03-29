// 1) Import the package(s) needed by this program.

/**
 * 	GregorianCalendarPrinter.java:
 *  CS 170 Homework 8 Starter Program.
 *  Based on Project 2.1 from Horstmann BigJava, 3rd (page 77).
 *
 *	@author <Put your name here>
 *	@version <Put today's date here>
 */

public class GregorianCalendarPrinter
{
    /**
     * The three GregorianCalendar variables.
     */
    GregorianCalendar future;       // Today's date and time + 100
    int futureDayOfWeek;            // What day does it fall on?
    GregorianCalendar birthday;     // My birthday February 2, 1950
    int birthdayOfWeek;             // Day of the week I was born on
    GregorianCalendar tenKBday;     // 10,000 days from my birthday


    /**
     * Add your code inside this method.
     */
    public void run()
    {
        // 2) Initialize future to 100 days from the day that
        //    the program is run. Use the GregorianCalendar
        //    class constructor and a mutator method.


        // 3) Initialize futureDayOfWeek to the week-day that
        //    future falls on.


        // 4) Initialize birthday to my birthday, February 2, 1950


        // 5) Initialize birthdayOfWeek to the day of the week that
        //    I was born on. This will just be a number with
        //    Sunday = 1, etc. You'll use an accessor.


        // 6) Initialize tenKBday to 10,000 days after my birthday.


        // Here's some code so you can see how your variables look
        System.out.printf("future : %tc%n", future);
        System.out.println("futureDayOfWeek : " + futureDayOfWeek);
        System.out.printf("birthday : %tc%n", birthday);
        System.out.println("birthdayOfWeek : " + birthdayOfWeek);
        System.out.printf("tenKBday : %tc%n", tenKBday);
    }

    /**
     *	Ignore the main() method. Put your code inside the run() method.
     *
     * 	@param args
     */
    public static void main(String[] args)
    {
        new GregorianCalendarPrinter().run();

    }
}
