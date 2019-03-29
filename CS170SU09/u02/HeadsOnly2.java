import java.util.*;
public class HeadsOnly2
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        cin.useDelimiter("<[hH]|</");
        while (cin.hasNext())
        {
            String word = cin.next();
            if (word.length() > 1)
            {
                if (Character.isDigit(word.charAt(0)))
                {
                    int tabs = Integer.parseInt(word.substring(0,1))-2;
                    for (int i = 0; i < tabs; i++)
                        System.out.print("  ");
                    System.out.println(word.substring(2));
                }
            }
        }
    }
}
