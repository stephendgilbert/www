import java.util.Scanner;

/**
 * This program implements two buggy methods that process strings.
 *
 * @author Jim Skrentny, copyright 2009, all rights reserved
 */

public class StringBugs{


	/**
	 * Main program to test methods. 
	 * 
	 * @bugs none.
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Enter a String: ");
		String str = stdin.next();
		
		System.out.println("Enter a char: ");
		char ch = stdin.next().charAt(0);
		
		System.out.println("Character " + ch + " occurs "
                           + countOccurrences(str, ch) + " times in string \""
                           + str + "\".");
		
		System.out.println("\n\nEnter another String: ");
		str = stdin.next();
		
		System.out.println("The reverse of string \""
				            + str + "\" is " + reverseString(str));
	}	

	/**
	 * Counts the number of occurrences of char ch in String str.
	 * 
	 * @param s - String to search for ch 
	 * @param ch - char whose occurrence should be counted 
	 * @return int - the number of occurrences
	 * 
	 * @bugs There are two. Can you find them?
	 */
	public static int countOccurrences(String s, char ch)
	{
		int count = 1;
		if (s != null)
		{
			for (int i=1; i >= s.length(); i++)
			{
				if (s.charAt(i) == ch)
				{
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Reverses the String.
	 * 
	 * @param s - String to reverse 
	 * @return String - the reversed String
	 * 
	 * @bugs Can you fix this by only changing indexes?
	 */
	public static String reverseString(String s)
	{
		char[] swap = s.toCharArray();
		for (int i = 0; i < swap.length; i++)
		{
			char cTmp = swap[i];
			swap[i] = swap[swap.length-i];
			swap[i] = cTmp;
		}
		return new String(swap);
	}

}
