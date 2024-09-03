
/**
 * Write a description of class Complex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complex
  {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary)
      {
        this.real = real;
        this.imaginary = imaginary;
      }

    public double getReal()
      {
        return real;
      }

    public double getImaginary()
      {
        return imaginary;
      }

    public Complex add(Complex other)
      {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
      }

    public Complex multiply(Complex other)
      {
        double realPart = ;
        double imaginaryPart = ;
        return new Complex(realPart, imaginaryPart);
      }

    public double magnitude()
      {
        return Math.sqrt(real * real + imaginary * imaginary);
      }
  }

