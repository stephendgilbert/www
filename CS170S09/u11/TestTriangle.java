import java.awt.Color;

/**
 *  Basic test of the Triangle class.
 *
 *  @author Stephen Gilbert
 *  @version Apr 30, 2009 2:00:00 PM
 *
 */
public class TestTriangle
{
    /**
     *  Create three Triangle objects and calls various methods.
     *
     *  @param args
     */
    public static void main(String[] args)
    {
        Triangle t1 = new Triangle();
        System.out.println("\nt1: " + t1);
        System.out.println("t1.getArea() = " + t1.getArea());
        System.out.println("t1.getPerimeter() = " + t1.getPerimeter());
        
        Triangle t2 = new Triangle(5.0, 3.0, 6.0);
        System.out.println("\nt2: " + t2);
        System.out.println("t2.getArea() = " + t2.getArea());
        System.out.println("t2.getPerimeter() = " + t2.getPerimeter());
        
        Triangle t3 = new Triangle(3.0, 4.0, 5.0, Color.BLUE, true);
        System.out.println("\nt3: " + t3);
        System.out.println("t3.getArea() = " + t3.getArea());
        System.out.println("t3.getPerimeter() = " + t3.getPerimeter());
    }

    /*  EXPECTED OUTPUT (Dates of creation will change, of course.)

        t1: created on Thu Apr 30 14:02:44 PDT 2009
        color: java.awt.Color[r=255,g=255,b=255] and filled: false
        Triangle: side1 = 1.0, side2 = 1.0, side3 = 1.0
        t1.getArea() = 0.4330127018922193
        t1.getPerimeter() = 3.0
        
        t2: created on Thu Apr 30 14:02:44 PDT 2009
        color: java.awt.Color[r=255,g=255,b=255] and filled: false
        Triangle: side1 = 5.0, side2 = 3.0, side3 = 6.0
        t2.getArea() = 7.483314773547883
        t2.getPerimeter() = 14.0
        
        t3: created on Thu Apr 30 14:02:44 PDT 2009
        color: java.awt.Color[r=0,g=0,b=255] and filled: true
        Triangle: side1 = 3.0, side2 = 4.0, side3 = 5.0
        t3.getArea() = 6.0
        t3.getPerimeter() = 12.0
     
     */
}
