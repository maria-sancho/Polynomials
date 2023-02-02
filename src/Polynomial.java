import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polynomial {

    private double[] coeffs;

    public Polynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public Polynomial(String filename) {
        Scanner in = null;
        try {
            in = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int degree = in.nextInt();
        coeffs = new double[degree+1];
        for (int i=0; i<coeffs.length; ++i) {
            coeffs[i] = in.nextDouble();
        }
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=coeffs.length-1; i>=0; --i) {
            sb.append(coeffs[i]);
            if (i > 0) {
                if (i == 1) {
                    sb.append("x");
                } else {
                    sb.append("x^").append(i);
                }
                if (i > 1) {
                    sb.append("+");
                }
            }
        }

        if (coeffs.length > 3) {
            sb.insert(sb.length() - 3, "+");
        }

        return sb.toString();
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i=coeffs.length-1; i>=0; --i) {
            result = result * x + coeffs[i];
        }
        return result;
    }

    public Polynomial add(Polynomial another) {
        int resultDegree = Math.max(this.getDegree(), another.getDegree());

        double[] result = new double[resultDegree + 1];

        for (int i=0; i<result.length; ++i) {
            double thisCoeff = (i < this.coeffs.length) ? this.coeffs[i] : 0;
            double anotherCoeff = (i < another.coeffs.length) ? another.coeffs[i] : 0;
            result[i] = thisCoeff + anotherCoeff;
        }

        return new Polynomial(result);
    }

    public Polynomial multiply(Polynomial another) {
        int length = this.coeffs.length + another.coeffs.length - 1;

        double[] result = new double[length];

        for (int i=0; i<this.coeffs.length; ++i) {
            for (int j=0; j<another.coeffs.length; ++j) {
                result[i+j] += this.coeffs[i] * another.coeffs[j];
            }
        }
        return new Polynomial(result);
    }
}