
/**
 * Write a description of class Factorial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Factorial
{
    public static void main(String[] args)
      {
        int num = 3;
        long start = System.nanoTime();
        long factorial = multiplyNumbers(num);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Factorial of " + num + " = " + factorial);
        System.out.printf("Time with recursion: %d ns%n", timeElapsed);

        start = System.nanoTime();
        factorial = multiplyNumbersLooped(num);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.printf("Time with loop: %d ns%n", timeElapsed);

      }
    public static long multiplyNumbers(int num)
      {
        if (num > 1)
            return num * multiplyNumbers(num - 1);
        else
            return 1;
      }
    public static int multiplyNumbersLooped(int num)
      {
          int result = 1;
          for(int i = 2; i<=num; i++) result *= i;
          return result;
      }

}
