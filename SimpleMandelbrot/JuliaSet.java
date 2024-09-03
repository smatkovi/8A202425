public class JuliaSet
{
    // Maximum iterations to determine if the point belongs to the Julia set
    private static final int MAX_ITER = 1000;

    // Constant C for the Julia set
    private static final double C_REAL = -0.7;
    private static final double C_IMAGINARY = 0.27015;

    // Recursive function to calculate whether the point belongs to the Julia set
    public static int
    julia (double real, double imaginary, int iter)
    {
        /* Base case: if max iterations reached or the magnitude is greater than 2. */
        if (iter == 0 || real * real + imaginary * imaginary > 4.0)
        {
            return iter;
        }

        /* The current complex number is represented by (real, imaginary).
           Calculate Z^2 + C where C is the constant complex number. */
        double real_new = real * real - imaginary * imaginary + C_REAL;
        double imaginary_new = 2 * real * imaginary + C_IMAGINARY;

        /* Recursively call julia with the new real and imaginary parts. */
        return julia (real_new, imaginary_new, iter - 1);
    }

    public static void
    main (String[] args)
    {
        /* Define the area of the complex plane to visualize. */
        double real_start = -1.5;
        double real_end = 1.5;
        double imaginary_start = -1.5;
        double imaginary_end = 1.5;
        
        /* Define the resolution. */
        int width = 800;
        int height = 800;

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                double real = real_start + x * (real_end - real_start) / width;
                double imaginary = imaginary_start + y * (imaginary_end - imaginary_start) / height;

                int iterations = julia (real, imaginary, MAX_ITER);

                /* Output or visualize the result. */
                if (iterations == 0)
                {
                    System.out.print ("#"); /* Point is outside the Julia set. */
                }
                else
                {
                    System.out.print (" "); /* Point might be inside the Julia set. */
                }
            }
            System.out.println ();
        }
    }
}
