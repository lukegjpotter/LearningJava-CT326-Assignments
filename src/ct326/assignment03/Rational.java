/**
 * 07013418
 * Luke Potter
 * 3rd B.Sc. I.T.
 * 09/October/2009
 */

package ct326.assignment03;	//Use package "assignment3" as required

import java.util.StringTokenizer;

public class Rational {
	
	//Declare Variables
	private int numerator;
	private int denominator;
	
	//Constructor without arguments
	public Rational () {
		numerator = 1;
		denominator = 5;
	}
	
	//Constructor with arguments
	public Rational (String fraction) {
		
		//Create the StringTokenizer 
		StringTokenizer st = new StringTokenizer(fraction, "/");
		
		try {
			
			if (st.countTokens() == 2) {
				
				while (arePositive() == true && st.hasMoreTokens() == true) {
					
					//Assign the tokens to the variables
					numerator = Integer.parseInt(st.nextToken());
					denominator = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		catch (Exception exception) {
			
			if (st.countTokens() != 2) {
				
				System.out.println("There must be exactly two parts to the fraction");
				System.err.println(exception.getMessage() + "\n");
				exception.printStackTrace();
			}
			
			if (numerator <= 0 || denominator <= 0) {
				
				System.out.println("Both the numerator and the denominator must be greater than zero");
				System.err.println(exception.getMessage() + "\n");
				exception.printStackTrace();
			}
			
		}
		
		
	}
	
	//Addition of two rational numbers
	public void add (Rational r2) {
			
		//If the denominators are the same
		if (denominator == r2.denominator){
			//Add numerators
			numerator += r2.numerator;
		}
		
		else {
			
			//Multiply numerator by the other fraction's denominator
			numerator = ((numerator * r2.denominator) + (r2.numerator * denominator));
			//Find common denominator
			denominator = denominator * r2.denominator;
		}
	}
	
	//Subtraction of two rational numbers
	public void subtract (Rational r2) {
		
		//If the denominators are the same
		if (denominator == r2.denominator){
			//Add numerators
			numerator -= r2.numerator;
		}
		
		else {
			
			//Multiply numerator by the other fraction's denominator
			numerator = ((numerator * r2.denominator) - (r2.numerator * denominator));
			//Find common denominator
			denominator = denominator * r2.denominator;
		}
	}
	
	//Multiplication of two rational numbers
	public void multiply (Rational r2) {
			
			//Multiply numerator by the other fraction's denominator
			numerator = numerator * r2.numerator;
			//Find common denominator
			denominator = denominator * r2.denominator;
	}
	
	//Division of two rational numbers
	public void divide (Rational r2) {
		
		//Flip second fraction's numerator and denominator
		int temp;
		temp = r2.numerator;
		r2.numerator = r2.denominator;
		r2.denominator = temp;
		
		//Now that the fraction is inverted multiply normally
		multiply (r2);
	}
	
	//A method for printing a rational number in the form "numerator / denominator"
	public String toString () {
		
		return numerator + " / " + denominator;
	}
	
	//A method to check that the numerator and the denominator are greater than zero
	public boolean arePositive () {
		
		if (numerator <= 0 || denominator <= 0)
			return true;
		
		else
			return false;
	}
}
