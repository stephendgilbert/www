import java.awt.*;
import java.io.*;
/**
 *  MySmallPicture - A CS 170 Homework Assignment.
 *
 *  @author (Put your name here)
 *  @version (Put today's date here)
 */
public class MySmallPicture
{
    /**
     * Open, scale, decorate and save your picture.
     */
    public static void main(String[] args)
    {
        // LEAVE THIS, BUT CHANGE THE FILE NAME
        String fileName = "StephenGilbert.jpg"; // Change this
        File file = new File(fileName);
        if (file.exists())
            fileName = file.getAbsolutePath();
        else
        {
            System.err.println(fileName + " not found in current folder.");
            return;
        }

        // 1. Open your large picture (in the current folder)
        // Do this by creating a Picture object
        // Use fileName as the variable for the file

        // 2. Find out how large it is and store in some variables

        // 3. Scale it to a smaller picture

        // 4. Draw on the smaller picture
        //  - get a Graphics2D pen from the smallPic
        //    Name your Graphics2D variable pen


        //  - uncomment these for smooth rendering
        //pen.setRenderingHint (RenderingHints.KEY_ANTIALIASING,
        //    RenderingHints.VALUE_ANTIALIAS_ON);

        //   - set the pen color to draw the frame as you like

        //  - draw a frame around the picture

        //  - paint your name on the bottom
        //    change the pen color and font if you like

        // 5. Save your new smaller picture with a new name
        //  - Modify the fileName variable and use it with write().
        fileName = fileName.substring(0, fileName.indexOf('.')) +
            "-smaller.jpg";
        small.write(fileName);

        // Let's just load the modified picture and look at it
        Picture modified = new Picture(fileName);
        modified.show();
    }
}
