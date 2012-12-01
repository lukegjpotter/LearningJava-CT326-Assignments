/**
 * 07013418
 * Luke Potter
 * 3rd B.Sc. I.T.
 * 09/October/2009
 */

package ct326.assignment03;	//Use package "assignment3" as required

public class Driver {

	public static void main(String[] args) {
		
		//Instantiate Rational types
		Rational r1 = new Rational ("3/7");
		Rational r2 = new Rational ("1/2");
		Rational r3 = new Rational ("3/4");
		Rational r4 = new Rational ("5/16");
		Rational r5 = new Rational ("8/9");
		Rational r6 = new Rational ("1/6");
		Rational r7 = new Rational ("5/9");
		Rational r8 = new Rational ();
		
		//Perform actions on each Rational type
		//Addition
		System.out.println("Adding R1 and R2\n");
		System.out.println("R1: " + r1.toString());
		System.out.println("R2: " + r2.toString());
		r1.add(r2);
		System.out.println("ANS: " + r1.toString() + " \n");
		
		//Subtraction
		System.out.println("\nSubtracting R4 from R3\n");
		System.out.println("R3: " + r3.toString());
		System.out.println("R4: " + r4.toString());
		r3.subtract(r4);
		System.out.println("ANS: " + r3.toString() + " \n");
		
		//Multiplication
		System.out.println("\nMultipling R5 and R6\n");
		System.out.println("R5: " + r5.toString());
		System.out.println("R6: " + r6.toString());
		r5.multiply(r6);
		System.out.println("ANS: " + r5.toString() + " \n");
		
		//Division
		System.out.println("\nDividing R8 by R7\n");
		System.out.println("R7: " + r7.toString());
		System.out.println("R8: " + r8.toString());
		r7.divide(r8);
		System.out.println("ANS: " + r7.toString() + " \n");
	}

}
