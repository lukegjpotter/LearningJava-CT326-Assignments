/**
 * @Student_ID 07013418
 * @Author Luke Potter
 * @Course 3rd B.Sc. I.T.
 * @Date 09/October/2009
 */

package ct326.assignment07;

import java.util.StringTokenizer;

public class Rational implements Comparable <Rational> {
	
	//Declare Variables
	private int numerator;
	private int denominator;
	public float decimalValue;
	
	//Constructor without arguments
	public Rational () {
		numerator = 1;
		denominator = 5;
		decimalValue = (float)((float)numerator/(float)denominator);
	}
	
	//Constructor with arguments
	public Rational (String fraction) {
		
		//Create the StringTokenizer 
		StringTokenizer st = new StringTokenizer(fraction, "/");
		
		try {
			
			if (st.countTokens() == 2) {
				
				//Assign the tokens to the variables
				numerator = Integer.parseInt(st.nextToken());
				denominator = Integer.parseInt(st.nextToken());
				decimalValue = ((float)numerator/(float)denominator);
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
		
		return numerator + "/" + denominator;
	}

	//Compare To method from the Comparable interface
	@SuppressWarnings("finally")
	public int compareTo(Rational r2) throws ClassCastException {
		
		int result = 0;
		
		try {
			
			if (! (r2 instanceof Rational)){
				
				throw new Exception ("Arguement not of correct type");
			}
			
			else {
				
				
				//If the decimal values are equal return 0
				if (this.decimalValue == r2.decimalValue)
					result = 0;
			
				//Else if r2's decimal value is bigger
				else if (this.decimalValue < r2.decimalValue)
					result = -1;
		
				//Else if the class calling this method's decimal value is greater
				else
					result = 1;
				
			}
		}
		
		catch (ClassCastException e) {
			
			System.out.println("Class Cast Exception");
			System.err.println(e.getMessage() + "\n");
			e.printStackTrace();
		}
		
		finally {
			
			return result;
		}
	}
}
