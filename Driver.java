public class Driver{
    public static void main(String [] args) {
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));
        double [] c1 = {6,0,0,5};
        Polynomial p1 = new Polynomial(c1);
        double [] c2 = {0,-2,0,0,-9};
        Polynomial p2 = new Polynomial(c2);
        Polynomial s = p1.add(p2);
        System.out.println("s(0.1) = " + s.evaluate(0.1));
        if(s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");

        double[] coeffs1 = {3, 2, 5}; // Represents 3 + 2x + 5x^2
        double[] coeffs2 = {4, -1}; // Represents 4 - x
        int[] exps2 = {0, 1}; // Custom exponents for second polynomial

        Polynomial poly1 = new Polynomial(coeffs1);
        Polynomial poly2 = new Polynomial(coeffs2, exps2);

        Polynomial sum = poly1.add(poly2);
        Polynomial product = poly1.multiply(poly2);

        System.out.println("Sum:");
        sum.saveToFile();

        System.out.println("Product:");
        product.saveToFile();
    
    }
}

