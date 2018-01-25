/**
 * @author Shwetha Kunnam
 * @author Jenny Mei
 * Period 6
 * 
 * This program implements a method to stabilize infusions of insulin, and then glucose, to implement
 * the hyperinsulinemic-glycemic glucose clamp. Though the effect is difficult to assess as we cannot
 * actually send data to a patient and see how they are responding, 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FinalProject {
	
	/**
	 * Method used to stabilize each substance
	 * @param being - beginning glucose concentration
	 * @param minError - minimum error needed 
	 * @param desired - desired concentration
	 * @param p - control for insuring the desired amount is not overshot 
	 * @param i - sum of the previous errors
	 * @param d - predict future value of error and change the speed accordingly
	 * @param time - unit of time at which each 
	 * @return rate of infusion of the substance when it is stabilized
	 * @throws FileNotFoundException 
	 */
	public static double stabilizeSubstance(double begin, double minError, double desired, double p, double i, double d, double time) throws FileNotFoundException {
			double actual = begin;
			double error = 0, lastError = 0;
			double integral = 0;
			double derivative = 0;
			double output = 0;
			double outputForDisplay = 0;
			while (Math.abs(desired - actual) > minError) {
				actual +=4;
				error = desired - actual;
				//Computational Methods: numerical determining integral
				integral = integral + (error*time);
				if (error == 0 || Math.abs(integral) >= 50) {
					integral = 0;
				}
				//Computational Methods: numerical determining derivative
				derivative = (error - lastError)/time;
				output = p * error + i * integral + d * derivative;
				if(output<0) {
					outputForDisplay = 0;
				} else {
					outputForDisplay = output;
				}
				lastError = error;
				actual += outputForDisplay;
				System.out.println("Glucose Level: " + actual);
				System.out.println("Infusion: " + outputForDisplay);
			}
			
			return output;
	}
	
	public static void main(String[] args) throws FileNotFoundException {		
		/**
		 * Determining Values of p, i, and d:
		 * 1. Set each of them to 0.
		 * 2. Increase p until the error is fairly small.
		 * 3. Increase k until overshoot is minimal. 
		 * 4. Increase i until error is eliminated. It shouldn't be surprising even if i is really really small. 
		 */
		//For purposes of running the program, PID values are just guessed - likely not optimal
		double p = 1, i = 0.00001, d = 0.1;
		
		//Stabilization for glucose
		stabilizeSubstance(50, 0.001, 100, p, i, d, 1);	
	}

}
