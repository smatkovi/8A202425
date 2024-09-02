
/**
 * Write a description of class JuliaSet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;

public class JuliaSet extends JPanel
  {
    private final int MAX_ITER = 300; // Maximum number of iterations
    private final double ZOOM = 1;    // Zoom level
    private final Complex c;          // Constant complex parameter for the Julia set

    public JuliaSet(Complex c)
      {
        this.c = c;
        setPreferredSize(new Dimension(800, 800)); // Set the size of the panel
      }

    // Recursive function to calculate the number of iterations
    private int julia(Complex z, int iter)
      {
        if (z.magnitude() > 2.0 || iter >= MAX_ITER)
          {
            return iter;
          }
        // Recursively apply the function: z = z^2 + c
        return julia(z.multiply(z).add(c), iter + 1);
      }

    // Method to render the Julia set
    @Override
    protected void paintComponent(Graphics g)
      {
        super.paintComponent(g);

        for (int x = 0; x < getWidth(); x++)
          {
            for (int y = 0; y < getHeight(); y++)
              {
                double zx = 1.5 * (x - getWidth() / 2) / (0.5 * ZOOM * getWidth());
                double zy = (y - getHeight() / 2) / (0.5 * ZOOM * getHeight());
                Complex z = new Complex(zx, zy);

                int iter = julia(z, 0);

                // Color the pixel based on the number of iterations
                g.setColor(new Color(iter % 255, iter % 255, 255 - iter % 255));
                g.drawRect(x, y, 1, 1);
              }
          }
      }

    public static void main(String[] args)
      {
        JFrame frame = new JFrame("Julia Set");
        Complex c = new Complex(-0.7, 0.27015); // You can change this value to generate different Julia sets
        JuliaSet juliaSet = new JuliaSet(c);
        frame.add(juliaSet);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
}
