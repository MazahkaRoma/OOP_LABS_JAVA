package OOP_Labs;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNextLine())
        {
            String s=scanner.nextLine();
            System.out.println("Исходная срока: "+s);

            System.out.println("Полиндром: "+polindrome(s));
        }
    }
    public static String polindrome(String upcomingString)
    {
        for(int i=upcomingString.length()-1;i>=0;i--)
        {
            upcomingString+=upcomingString.charAt(i);
        }
        return upcomingString;

    }

}
