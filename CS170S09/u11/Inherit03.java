/**
 * Inherit02: CS 170 inheritance example.
 *  - Overriding the toString() method in both classes
 *  @author Stephen Gilbert
 *  @version Apr 24, 2009 11:47:07 AM
 *
 */

class Person
{
    private String name = "Unsub";
    
    //public Person() { print("Person() constructor"); }
    public Person(String name)
    {
        this.name = name;
        print("Person(String) constructor");
    }
    
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public String toString() { return "Name: " + name; }
    
    private void print(String msg) { System.out.println(msg); }
}

class Student extends Person
{
    private long studentID;
    
    public Student(String sname, long sid)
    {
        super(sname);   // explicitly call Student(string) constructor     
        studentID = sid;
        // setName(sname);
        System.out.println("Student(String,long) constructor.");
    }
    
    public long getID() { return studentID; }
    
    public String toString() 
    {
        return super.toString() + ", ID: " + studentID;
    }
}

public class Inherit03
{
    public static void main(String[] args) 
    {
        // Using constructors
        Person pete = new Person("Pete");
        Student steve = new Student("Steve", 1007);
        System.out.println("pete is " + pete);
        System.out.println("steve is " + steve);
    }
}
