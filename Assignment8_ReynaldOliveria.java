package compmeth.Oliveria_R.assignment8;
/**
 * Assignment 8: Regression
 * <p>
 * Pd. 6
 * <p>
 * Computational Methods
 * @author Reynald
 */
public class Assignment8_ReynaldOliveria {
	
	/**
	 * Holds variables, and applies the formula for regression
	 * <p>
	 * Given a set of r's and a corresponding surjective set of s's,
	 * output a value for a and b such that q = as/(b+s), and
	 * the sum of (r-q) squared is the least.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//the variables
		double [] r = {1, 4, 5, 6, 6};
		double [] s = {1, 2, 3, 4, 5};
		double [] o = {1, 1, 1, 1, 1};//made for the sum method
		
		double [] z = new double[5]; double[] w = new double [5];
		
		//inverses r and s
		for(int i = 0; i < r.length; i++){
			z[i] = 1.0/r[i];
			w[i] = 1.0/s[i];
		}
		
		//the final calculations
		System.out.println(sum(w,z) + "\t" + sum(z,o) + "\t" + sum(w,w) + "\t" + sum(w,o));
		double a1 = (5* sum(w,z) - sum(w,o) * sum(z,o))/(5 * sum(w,w) - Math.pow(sum(w,o),2));
		double a0 = (sum(w,w)*sum(z,o) - sum(w,o)*sum(w,z))/(5 * sum(w,w) - Math.pow(sum(w,o),2));
		System.out.println(a1 + "\t"+  a0);
		
		//inversing from earlier reversed here
		System.out.println("a = "+1/a0 + "\nb = "+a1/a0);
		
		System.out.println("error = " + error(s, r,1/a0, a1/a0));
	}
	
	/**
	 * Takes a sum
	 * <p>
	 * Designed this way to minimize number of methods
	 * <p>
	 * @param a a series
	 * @param b another series
	 * @return returns the sum of a_i * b_i
	 */
	public static double sum(double [] a, double [] b){
		assert a.length == b.length;
		double sum = 0;
		for(int i = 0; i < a.length; i ++){
			sum += (a[i] * b[i]);
		}
		return sum;
	}
	
	/**
	 * Calculates the error
	 * <p>
	 * Returns the sum of the residuals squared in the form of regression:
	 * r = ax/(b+x)
	 * <p>
	 * @param s the function input
	 * @param r the function output
	 * @param a regressive multiplicative
	 * @param b regressive additive
	 * @return sum of residuals squared
	 */
	public static double error(double [] s, double []r, double a, double b){
		double sum = 0;
		for(int i = 0; i < r.length; i++){
			sum += Math.pow(r[i]-(s[i]*a/(s[i] + b)), 2);
		}
		return sum;
	}

}
