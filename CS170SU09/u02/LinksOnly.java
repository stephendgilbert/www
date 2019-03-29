import java.util.*;
public class LinksOnly
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine())
        {
            String line = cin.nextLine().trim();
            if (line.length() > 0)
            {
                Scanner sin = new Scanner(line);
                sin.useDelimiter("<[^>]+>");
                String result = "";
                while (sin.hasNext())
                {
                    result += sin.next();
                }
                if (result.trim().length() > 0)
                    System.out.println(result);
            }
        }
    }
}
