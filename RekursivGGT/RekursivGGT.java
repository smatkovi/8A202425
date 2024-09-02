
/**
 * Write a description of class RekursivGGT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RekursivGGT
{
    public static void main(String[] args)
      {
        int num1 = 30;
        int num2 = 45;
        int T = ggT(num1, num2);
        System.out.println("ggT von " + num1 + " und " + num2 + ":" + T);
      }
    
     public static int ggT(int a, int b)
       {
         if(a < b)
           {
             return ggT(b, a);
           }
         if(0 == b)
           {
             return a;
           }
         return ggT(a % b, b);
       }
}
