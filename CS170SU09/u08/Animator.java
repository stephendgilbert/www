import acm.program.*;
import acm.graphics.*;
/**
 * Stuff.
 *
 *  @author (your name goes here)
 *  @version (place the date here)
 *
 */
public class Animator extends GraphicsProgram
{
    // Instance variables for objects to be animated
    private static final int FRAME_TIME = 20;   // 20 milliseconds
    
    /** Initialize objects and animation state. */
    public void init()    { /* initialization */   }
    
    /** Animation loop */
    public void run()
    {
        while (true)
        {
            advanceOneFrame();
            pause(FRAME_TIME);
        }
    }
    
    /** Draw one frame of the animation */
    public void advanceOneFrame() { /* move objects */ }

}


