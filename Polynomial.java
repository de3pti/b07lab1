public class Polynomial {
    // Fields for coefficients and exponents
    private double[] coeffs; // Coefficients
    private int[] exps; // Exponents

    // Default constructor (zero polynomial)
    public Polynomial() {
        coeffs = new double[]{0.0};
        exps = new int[]{0};
    }

    // Constructor with coefficients (default exponents 0, 1, 2, ...)
    public Polynomial(double[] coefficients) {
        this.coeffs = new double[coefficients.length];
        this.exps = new int[coefficients.length];

        for (int i = 0; i < coefficients.length; i++) {
            this.coeffs[i] = coefficients[i];
            this.exps[i] = i; // Assign default exponents 0, 1, 2, ...
        }
    }

    // Constructor with both coefficients and exponents
    public Polynomial(double[] coefficients, int[] exponents) {
        this.coeffs = coefficients;
        this.exps = exponents;
    }

    // Method to add two polynomials
    public Polynomial add(Polynomial other) {
        int maxExp = Math.max(this.exps[this.exps.length - 1], other.exps[other.exps.length - 1]);

        double[] resultCoeffs = new double[maxExp + 1];
        int[] resultExps = new int[maxExp + 1];

        // Fill in the current polynomial
        for (int i = 0; i < this.coeffs.length; i++) {
            resultCoeffs[this.exps[i]] = this.coeffs[i];
        }

        // Add the other polynomial
        for (int i = 0; i < other.coeffs.length; i++) {
            resultCoeffs[other.exps[i]] += other.coeffs[i];
        }

        // Fill result exponents (0 to maxExp)
        for (int i = 0; i <= maxExp; i++) {
            resultExps[i] = i;
        }

        return new Polynomial(resultCoeffs, resultExps);
    }

    // Method to multiply two polynomials
    public Polynomial multiply(Polynomial other) {
        int maxExp = this.exps[this.exps.length - 1] + other.exps[other.exps.length - 1];

        double[] resultCoeffs = new double[maxExp + 1];
        int[] resultExps = new int[maxExp + 1];

        // Multiply each term from the first polynomial by each term of the second
        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j < other.coeffs.length; j++) {
                int exp = this.exps[i] + other.exps[j];
                resultCoeffs[exp] += this.coeffs[i] * other.coeffs[j];
            }
        }

        // Fill result exponents
        for (int i = 0; i <= maxExp; i++) {
            resultExps[i] = i;
        }

        return new Polynomial(resultCoeffs, resultExps);
    }

    // Method to evaluate the polynomial for a given value of x
    public double evaluate(double x) {
        double result = 0.0;

        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, exps[i]);
        }

        return result;
    }

    // Method to check if the polynomial has a root at a given value
    public boolean hasRoot(double root) {
        return evaluate(root) == 0.0;
    }

    // Method to save the polynomial to a file (printing to console instead of file)
    public void saveToFile() {
        StringBuilder polyStr = new StringBuilder();

        for (int i = 0; i < coeffs.length; i++) {
            double coeff = coeffs[i];
            int exp = exps[i];

            // Append sign (+ or -)
            if (i > 0 && coeff > 0) {
                polyStr.append("+");
            }

            polyStr.append(coeff);

            // Append the variable and exponent
            if (exp == 1) {
                polyStr.append("x");
            } else if (exp > 1) {
                polyStr.append("x^").append(exp);
            }
        }

        // Print the polynomial (simulating file write)
        System.out.println(polyStr.toString());
    }
}
