package compmeth.Oliveria_R.assignment7;
/**
 * Assignment 7: Numerical Differential Equations
 * <p>
 * Pd. 6
 * <p>
 * Computational Methods
 * @author Reynald Oliveria
 */
public class Assignment7_ReynaldOliveria {
	/**
	 * Just output
	 * @param args
	 */
	public static void main(String [] args){
		System.out.println("Step Size\t\tEuler Estimate\t\tEuler Error\t\tRunge-Kutta Estimate\t\tRunge-Kutta Error");
		for(int i = 1; i < 6; i++){
			double h = Math.pow(10.0, -i);
			//System.out.format("$10^{-%d}$ & %.5f & %.5f & %.5f & %.5f \\\\%n",i, euler(h), rk4(h), euler(h)/t(11), rk4(h)/t(11));
			System.out.format("10^-%d\t\t\t%.5f\t\t\t%.5f\t\t\t%.5f\t\t\t\t%.5f%n",i,euler(h),euler(h)/t(11), rk4(h), rk4(h)/t(11));
		}//end for loop i
		//rk4(0.2);
	}//end main
	
	/**
	 * Solves for dx/dt in the differential equation
	 * 
	 * @param x the current amount
	 * @return the derivative of the function at that location
	 */
	public static double f(double x){
		return 37.5 - 3.5*x;
	}//end f
	
	/**
	 * The explicit definition of x1 based on t
	 * 
	 * @param t represents time
	 * @return the exact value of x1 at the instance of t
	 */
	public static double x1(double t){
		return 37.5/3.5 + (50.0 - 37.5/3.5)*Math.exp(-3.5*t);
	}//end x1
	
	/**
	 * The inverse of the x1(t) function
	 * <p>
	 * This works because x1 is injective
	 * 
	 * @param x1 the value
	 * @return the time at which the value is attained
	 */
	public static double t(double x1){
		return Math.log((x1 - 37.5/3.5)/(50.0 - 37.5/3.5))/-3.5;
	}//end t
	
	/**
	 * Euler's Method
	 * <p>
	 * <ol> <li> Plug in initial vars and calculate for missing </li>
	 * <li> Increment time by h </li>
	 * <li> Calculate new x1 by assuming the rate of change dx1/dt is constant </li>
	 * <li> Calculate new dx1/dt using x1</li>
	 * <li> Repeat until achieved value necessary </li></ol>
	 * <p>
	 * The commented out code is meant to show step by step calculations
	 * @param h The step size
	 * @return the time estimate at which x1 reaches 11
	 */
	public static double euler(double h){
		double[] vals = {0, 50.0, 37.5-3.5*50.0};//holds time, x1 estimate, and dx1/dt
		//System.out.println("t\t\tx1\t\t\tdx1/dt");
		while(vals[1] > 11){
			//System.out.format("%.3f\t\t%.5f\t\t%.5f%n", vals[0], vals[1], vals[2]);
			vals[0] += h;
			vals[1] += vals[2]*h; //mulitply by h because it is change of time and vals[2] is rate of change, assumes constant rate
			vals[2] = 37.5-3.5*vals[1];
		}//end while
		//System.out.format("%.3f\t\t%.5f\t\t%.5f%n", vals[0], vals[1], vals[2]);
		return vals[0];
	}//end euler
	
	/**
	 * Runge-Kutta 4th Order
	 * <p>
	 * Like Euler's Method but uses 4 partitions each of which are weighted
	 * <p>
	 * The commented out code is meant to show step by step calculations
	 * 
	 * @param h the step size
	 * @return the time estimate at which x1 reaches 11
	 */
	public static double rk4(double h){
		double [] k = new double[4];//holds partition values
		double [] vals = {0, 50};//holds time and x1 estimate
		k[0] = f(vals[1]);
		k[1] = f(vals[1]+h*k[0]/2.0);
		k[2] = f(vals[1]+h*k[1]/2.0);
		k[3] = f(vals[1]+h*k[2]);
		//System.out.println("t\t\tx1\t\t\tk1\t\t\tk2\t\t\tk3\t\t\tk4");
		while(vals[1] > 11){
			//System.out.format("%.3f\t\t%.5f\t\t%.5f\t\t%.5f\t\t%.5f\t\t%.5f%n", vals[0], vals[1], k[0], k[1], k[2], k[3]);
			vals[0] += h;
			vals[1] += h/6*(k[0]+2*k[1]+2*k[2]+k[3]);
			k[0] = f(vals[1]);
			k[1] = f(vals[1]+h*k[0]/2.0);
			k[2] = f(vals[1]+h*k[1]/2.0);
			k[3] = f(vals[1]+h*k[2]);
		}//end while
		//System.out.format("%.3f\t\t%.5f\t\t%.5f\t\t%.5f\t\t%.5f\t\t%.5f%n", vals[0], vals[1], k[0], k[1], k[2], k[3]);
		return vals[0];
	}//end rk4

}//end class
