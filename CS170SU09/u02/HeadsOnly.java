import java.util.*;
public class HeadsOnly
{
    public static void main(String[] args)
    {
        boolean isEcho = false;
        boolean startingLine = false;
        int tabs = 0;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext())
        {
            String word = cin.next();
            if (word.length() > 2 && word.toUpperCase().startsWith("<H") &&
                Character.isDigit(word.charAt(2)))
            {
                isEcho = true;
                startingLine = true;
                switch(word.charAt(2))
                {
                    case '1':
                    case '2': tabs = 0; break;
                    case '3': tabs = 1; break;
                    case '4': tabs = 2; break;
                    case '5': tabs = 3; break;
                }
            }
            else if (word.length() > 3 && word.toUpperCase().startsWith("</H") &&
                Character.isDigit(word.charAt(3)))
            {
                isEcho = false;
                System.out.println();
            }
            else if (isEcho)
            {
                if (startingLine)
                {
                    for (int i = 0; i < tabs; i++);
                        System.out.print("    ");
                    System.out.print(word);
                }
                else
                {
                    System.out.print(" " + word);
                }
            }
        }
    }
}
