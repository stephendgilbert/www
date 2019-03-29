import acm.program.*;
import static java.lang.String.*;

/**
 *  Calculates letter grades from a grade percentage.
 *
 *  @author Stephen Gilbert
 *  @version Jan 29, 2009 12:22:01 PM
 */
public class GradeCalculator extends ConsoleProgram
{
    /**
     *  .
     */
    public void run()
    {
        println("Grade Calculator");
        println("----------------");
        
        // 1. Read the student's name and the number of scores
        String student = readLine("Student's name: ");
        int numScores = readInt("How many scores to record? ");
        
        // 2. Store the total points in two variables
        double pointsPossible = 0.0;
        double pointsEarned = 0.0;
        
        // 3. Use a for loop to get the input from the grader
        for (int i = 1; i <= numScores; i++)
        {
            // Current exam or quiz scores
            double possible = readDouble("# " + i + ": possible points: ");
            double earned = readDouble("# " + i + ": actual points: ");
            
            // Add the current scores to the total
            pointsPossible += possible;
            pointsEarned += earned;
            println();
        }

        // 4. Calculate the results
        double percent = getPercentage(pointsPossible, pointsEarned);
        String letterGrade = getLetterGrade(percent);
        
        // 5. Print the results
        println(format("%-20s: %.3f%% or %s", percent, letterGrade));
    }
    
    /**
     * Calculate the percentage grade. If there are no possible points,
     * then the function returns 0.
     *
     *  @param possible points that could be earned
     *  @param earned points
     *  @return percentage or 0 if 0 possible points
     */
    public double getPercentage(double possible, double earned)
    {
        if (possible == 0)
            return 0;
        else
            return earned / possible;
    }

    /**
     * Returns the letter grade based on the percentage.
     *
     *  @param percent on a scale of 0-100 (or more?)
     *  @return a letter grade (A-F)
     */
    public String getLetterGrade(double percent)
    {
        return "NOT DEFINED";
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new GradeCalculator().start(args);
    }
}
