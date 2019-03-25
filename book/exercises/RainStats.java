import java.util.*; // Scanner, Random
import java.io.*;
/**
 * RainStats - calculates rainfall statistics.
 *
 * @author (your name goes here)
 * @version (place the date here)
 */
public class RainStats
{
    public static final String INPUT_FILE = "rainfall-stats.txt";
    public static final String OUTPUT_FILE = "rainfall-summary.txt";
    /**
     * Writes and then reads the rainfall statistics.
     */
    public static void main(String[] args) throws IOException
    {
        // PART I - Creates the Rainfall stats file.
        Random gen = new Random();
        PrintWriter out = new PrintWriter(INPUT_FILE);
        out.println("RAINFALL STATISTICS YEAR " + (gen.nextInt(2000)));

        for (int month = 1; month <= 12; month++)
        {
            int samples = 1 + gen.nextInt(28);
            out.print(samples); // Start each line with number of samples
            out.print('\t');    // Separate values with tabs
            for (int i = 0; i < samples; i++)
            {
                out.print(gen.nextDouble());  // Print out each sample.
                out.print('\t');
            }
            out.println(); // end each line.
        }
        out.close();

        /**
         * Read the INPUT_FILE and Write to the OUTPUT_FILE
         * Print the first line.
         * On each subsequent lines, find out how many entries by
         * reading the first value as an int. Then read that many
         * entries as double values. Print the sum for each line
         * in your output file.
         */
         // Your code goes here
    }
}
