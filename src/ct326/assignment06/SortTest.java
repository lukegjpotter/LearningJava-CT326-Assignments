/**
 * @Student_ID 07013418
 * @Author Luke Potter
 * @Course 3rd B.Sc. I.T.
 * @Date 02/November/2009
 */
package ct326.assignment06;

import java.util.ArrayList;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {

		//Create the ArrayList of templated type Rational
		List <Rational> ratlst = new ArrayList <Rational> ();
		
		//Create some Rational type variables
		Rational r0 = new Rational ("1/1");
		Rational r1 = new Rational ("1/9");
		Rational r2 = new Rational ("1/3");
		Rational r3 = new Rational ("1/7");
		Rational r4 = new Rational ();
		Rational r5 = new Rational ("1/6");
		Rational r6 = new Rational ("1/4");
		Rational r7 = new Rational ("1/8");
		Rational r8 = new Rational ("1/2");
		Rational r9 = new Rational ("1/10");
		
		//Populate the ArrayList
		ratlst.add(r0);
		ratlst.add(r1);
		ratlst.add(r2);
		ratlst.add(r3);
		ratlst.add(r4);
		ratlst.add(r5);
		ratlst.add(r6);
		ratlst.add(r7);
		ratlst.add(r8);
		ratlst.add(r9);
		
		//Print out the unsorted ArrayList
		System.out.println("The unsorted list is : " + ratlst);
		
		//Call the "Put In Assending Order" method
		putInAscendingOrder(ratlst);
	}

	private static void putInAscendingOrder(List<Rational> ratlst) {
		
		//Declare variables
		int x;
		ArrayList <Rational> sortedlst = new ArrayList <Rational> ();
		Rational temp = new Rational();
		temp = ratlst.get(0);
		
		//Keep going until the unsorted list is empty
		while (ratlst.size() != 0) {
			
			//Give temp the value of the first element in the List
			temp = ratlst.get(0);
			x = 0;
			
			//Find the smallest value in unsorted list
			for (int i = 0; i < ratlst.size(); i++) {
				
				if (temp.compareTo(ratlst.get(i)) == 1) {
					
					temp = ratlst.get(i);
					x = i;
				}
			}
			
			//Add temp to the sorted list
			sortedlst.add(temp);
			
			//Remove the smallest value in the array
			ratlst.remove(x);
			
			//Print out the sorted list each time
			System.out.println("The sorted list is : " + sortedlst);
			
			if (ratlst.get(0) == null)
				break;
		}
	}
}
