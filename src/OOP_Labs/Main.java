package OOP_Labs;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Исходная срока: ");
        if(scanner.hasNextLine())
        {

            String s=scanner.nextLine();

            System.out.println("Возможный палиндром: "+reverseString(s));
            boolean bIsPalindrome= isPalindrome(reverseString(s),s);
            if (bIsPalindrome)
            {
                System.out.println("Палиндром");
            }
            else System.out.println("Не палиндром");
        }
    }
    public static String reverseString(String upcomingString)//заполнить новую строку символами в обратном порядке оригинальной строки
    {
        String sPalindrome= "";
        for(int i=upcomingString.length()-1;i>=0;i--)
        {
            sPalindrome+=upcomingString.charAt(i);
        }
        return sPalindrome;

    }

    public static boolean isPalindrome(String sPalindrome,String originString)//проверка является ли строка палиндромом
    {
        return originString.equals(sPalindrome);
    }

}
