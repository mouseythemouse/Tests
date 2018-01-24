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
	 * @param filename - filename with concentrations of insulin/glucose
	 * @param minError - minimum error needed 
	 * @param desired - desired concentration
	 * @param p - control for insuring the desired amount is not overshot 
	 * @param i - sum of the previous errors
	 * @param d - predict future value of error and change the speed accordingly
	 * @param time - unit of time at which each 
	 * @return rate of infusion of the substance when it is stabilized
	 * @throws FileNotFoundException 
	 */
	public static double stabilizeSubstance(String filename, double minError, double desired, double p, double i, double d, double time) throws FileNotFoundException {
			Scanner reader = new Scanner(new File(filename));
			double actual = reader.nextDouble();
			double error = 0, lastError = 0;
			double integral = 0;
			double derivative = 0;
			double output = 0;
			
			while ((desired - actual) > minError) {
				error = desired - actual;
				integral = integral + (error*time);
				if (error == 0 || Math.abs(integral) >= 50) {
					integral = 0;
				}
				derivative = (error - lastError)/time;
				output = p * error + i * integral + d * derivative;
				lastError = error;
				actual = reader.nextDouble();
			}
			
			reader.close();
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
		double p = 0, i = 0, d = 0;
		double p2 = 0, i2 = 0, d2 = 0;
		
		//Stabilization for insulin
		stabilizeSubstance("file", 0.001, 100, p, i, d, 1);
		stabilizeSubstance("file", 0.001, 100, p2, i2, d2, 1);	
	}

}
public class FinalProject {
	
	/**
	 * Method used to stabilize each substance
	 * @param filename - filename with concentrations of insulin/glucose
	 * @param minError - minimum error needed 
	 * @param desired - desired concentration
	 * @param p - control for insuring the desired amount is not overshot 
	 * @param i - sum of the previous errors
	 * @param d - predict future value of error and change the speed accordingly
	 * @param time - unit of time at which each 
	 * @return rate of infusion of the substance when it is stabilized
	 * @throws FileNotFoundException 
	 */
	public static double stabilizeSubstance(String filename, double minError, double desired, double p, double i, double d, double time) throws FileNotFoundException {
			Scanner reader = new Scanner(new File(filename));
			double actual = reader.nextDouble();
			double error = 0, lastError = 0;
			double integral = 0;
			double derivative = 0;
			double output = 0;
			
			while ((desired - actual) > minError) {
				error = desired - actual;
				integral = integral + (error*time);
				if (error == 0 || Math.abs(integral) >= 50) {
					integral = 0;
				}
				derivative = (error - lastError)/time;
				output = p * error + i * integral + d * derivative;
				lastError = error;
				actual = reader.nextDouble();
			}
			
			reader.close();
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
		double p = 0, i = 0, d = 0;
		double p2 = 0, i2 = 0, d2 = 0;
		
		//Stabilization for insulin
		stabilizeSubstance("file", 0.001, 100, p, i, d, 1);
		stabilizeSubstance("file", 0.001, 100, p2, i2, d2, 1);	
	}

}
public class FinalProject {
	
	/**
	 * Method used to stabilize each substance
	 * @param filename - filename with concentrations of insulin/glucose
	 * @param minError - minimum error needed 
	 * @param desired - desired concentration
	 * @param p - control for insuring the desired amount is not overshot 
	 * @param i - sum of the previous errors
	 * @param d - predict future value of error and change the speed accordingly
	 * @param time - unit of time at which each 
	 * @return rate of infusion of the substance when it is stabilized
	 * @throws FileNotFoundException 
	 */
	public static double stabilizeSubstance(String filename, double minError, double desired, double p, double i, double d, double time) throws FileNotFoundException {
			Scanner reader = new Scanner(new File(filename));
			double actual = reader.nextDouble();
			double error = 0, lastError = 0;
			double integral = 0;
			double derivative = 0;
			double output = 0;
			
			while ((desired - actual) > minError) {
				error = desired - actual;
				integral = integral + (error*time);
				if (error == 0 || Math.abs(integral) >= 50) {
					integral = 0;
				}
				derivative = (error - lastError)/time;
				output = p * error + i * integral + d * derivative;
				lastError = error;
				actual = reader.nextDouble();
			}
			
			reader.close();
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
		double p = 0, i = 0, d = 0;
		double p2 = 0, i2 = 0, d2 = 0;
		
		//Stabilization for insulin
		stabilizeSubstance("file", 0.001, 100, p, i, d, 1);
		stabilizeSubstance("file", 0.001, 100, p2, i2, d2, 1);	
	}

}
