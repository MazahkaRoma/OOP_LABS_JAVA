package OOP_Labs;

public class Main
{
    public static void main(String[] args)
    {
        System.out.print("Простые числа от 0 до 100: ");
        for (int i=2;i<=100;i++)
        {
            if(isPrime(i))
            {
                System.out.print(i+", ");
            }
        }
    }
    public static boolean isPrime(int n) //Является ли чсло простым
    {
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
