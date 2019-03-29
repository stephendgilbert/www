/**
 * Inherit02: CS 170 inheritance example.
 *  - Overriding the toString() method in both classes
 *  @author Stephen Gilbert
 *  @version Apr 24, 2009 11:47:07 AM
 *
 */

class Person2
{
    private String name = "Unsub";
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public String toString() { return "Name: " + name; }
}

class Student2 extends Person2
{
    private long studentID;
    
    public Student2(String sname, long sid)
    {
        studentID = sid;
        setName(sname);
    }
    
    public long getID() { return studentID; }
    
    public String toString() 
    {
        return super.toString() + ", ID: " + studentID;
    }
}

public class Inherit02
{
    public static void main(String[] args) 
    {
        // Overridden methods
        Student2 steve = new Student2("Steve", 1007);
        Person2 pete = new Person2();
        pete.setName("Pete Peterson");

        System.out.println("pete is " + pete);
        System.out.println("steve is " + steve);
    }
}
