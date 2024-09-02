
/**
 * Write a description of class FactorialComparison here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FactorialComparison {

    public static long multiplyNumbers(int num)
      {
        if (num > 1)
            return num * multiplyNumbers(num - 1);
        else
            return 1;
      }

    public static long multiplyNumbersLooped(int num)
      {
        long result = 1;
        for (int i = 2; i <= num; i++) result *= i;
        return result;
      }

    public static void main(String[] args)
      {
        int num = 20; // You can change this to a larger number to test with a bigger input size
        int iterations = 10000; // Number of times each method is executed to average the results

        // Warming up the JVM
        for (int i = 0; i < iterations; i++)
          {
            multiplyNumbers(num);
            multiplyNumbersLooped(num);
          }

        // Measuring time for recursive method
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++)
          {
            multiplyNumbers(num);
         }
        long endTime = System.nanoTime();
        long recursiveTime = (endTime - startTime) / iterations;

        // Measuring time for iterative method
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++)
          {
            multiplyNumbersLooped(num);
          }
        endTime = System.nanoTime();
        long loopedTime = (endTime - startTime) / iterations;

        System.out.println("Average time for recursive method: " + recursiveTime + " nanoseconds");
        System.out.println("Average time for iterative method: " + loopedTime + " nanoseconds");
    }
}
