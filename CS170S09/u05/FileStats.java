import acm.program.*;
import acm.io.*;

import acm.util.*;
import java.util.*;
import java.io.*;


/**
 *  Counts the lines, words and characters in a file.
 *
 *  @author Stephen Gilbert
 *  @version Jan 31, 2009 2:35:54 PM
 */
public class FileStats extends ConsoleProgram
{
    /**
     *  Asks the user for a file, opens it and then
     *  processes it using different Scanners.
     */
    public void run()
    {
        println("The FileStats program");
        String filename = readLine("File to open? ");
        
        // Check that a file exists
        File check = new File(filename);
        if (! check.exists())
        {
            println("File : " + filename + " does not exist.");
            return;
        }
        
        
        Scanner fileItr = new Scanner(
            MediaTools.openDataFile(filename));

        // Read the file, line by line
        int lines = 0;
        int words = 0;
        int characters = 0;
        while (fileItr.hasNextLine())
        {
            String line = fileItr.nextLine();
            
            // Count the lines and characters
            lines++;
            characters += line.length();
            
            // Count the words on the line
            Scanner wordItr = new Scanner(line);
            while (wordItr.hasNext())
            {
                words++;            // count it and then
                wordItr.next();    // throw it away
            }
        }
        
        // Print the results
        println(
            String.format("The file %s has %,d lines, " +
                "%,d words, and %,d characters.",
                filename, lines, words, characters));
        
    }
    
    /**
     * The standard Java entry point. DON'T MODIFY.
     * @param args the command-line arguments.
     */
    public static void main(String[] args)
    {
        new FileStats().start(args);
    }
}
