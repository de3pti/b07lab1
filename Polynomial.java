public class Polynomial{
    //field
    double[] coefficients;
    //constructors
    public Polynomial(){
        coefficients = new double[1];
        coefficients[0] = 0;
    }
    public Polynomial(double[] array){
        coefficients = new double[array.length];
        for (int i = 0; i < array.length; i++){
            coefficients[i] = array[i];
        }
    }
    //methods
    public Polynomial add(Polynomial poly){
        double[] new_polynomial = new double[Math.max(this.coefficients.length, poly.coefficients.length)];
        for (int i = 0; i < new_polynomial.length; i++){
        if (i < this.coefficients.length) {
            new_polynomial[i] += this.coefficients[i];
        }
        if (i < poly.coefficients.length) {
            new_polynomial[i] += poly.coefficients[i];
        }
        }

        return new Polynomial(new_polynomial);
    }

    public double evaluate(double sub){
        double evaluated = this.coefficients[0];
        for (int i = 1; i < this.coefficients.length; i++){
            evaluated = evaluated + this.coefficients[i] * Math.pow(sub,i);
        }

        return evaluated;
    }

    public boolean hasRoot(double root){
        return (evaluate(root) == 0);
    }
}