/**
 *  SimpleArrayClass.java
 *  @author Stephen Gilbert
 *  
 *  @version 2.0, 2009
 */
public class SimpleArrayClass
{
    // instance variables
    private int size = 0;
    private int capacity = 100;
    private double[] ar = new double[capacity];
    
    /**
     * Returns true if the array is full.
     * @return true if the array is full
     */
    public boolean isFull()
    {
        return size >= capacity;
    }
    
    /**
     * Adds a value to the array.
     * @param value the new value to be added to the array
     * @return true if the value could be added,
     *         false if the array was full
     */
    public boolean add(double value)
    {
        if (! isFull())
        {
            ar[size] = value;
            size++;
            return true;
        }
        return false;
    }
    
    /**
     * Prints the valid elements in this array.
     * @return string representation of the array.
     */
    public String toString()
    {
        String ret = "{";
        if (size == 0)
        {
            ret += "}";
        }
        else
        {
            for (int i = 0; i < size -1; i++)
                ret += ar[i] + ", ";
            ret += ar[size-1] + "}";
        }
        return ret;
    }
}
