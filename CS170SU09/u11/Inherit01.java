/**
 * Inherit01: CS 170 inheritance example.
 *  - Simple extension and using inherited methods
 *  @author Stephen Gilbert
 *  @version Apr 24, 2009 11:47:07 AM
 *
 */

class Person1
{
    private String name = "Unsub";
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
}

class Student1 extends Person1
{
    private long studentID;
    
    public Student1(String sname, long sid)
    {
        studentID = sid;
        setName(sname);
    }
    
    public long getID() { return studentID; }
}

public class Inherit01
{
    public static void main(String[] args) 
    {
        // Inherited methods
        Student1 steve = new Student1("Steve", 1007);
        
        steve.setName("Stephen");
        System.out.println("getName() = " + steve.getName());
        System.out.println("getID() = " + steve.getID());


        Person1 pete = new Person1();
        pete.setName("Pete Peterson");
        System.out.println("pete is " + pete);
        System.out.println("steve is " + steve);
    }
}
