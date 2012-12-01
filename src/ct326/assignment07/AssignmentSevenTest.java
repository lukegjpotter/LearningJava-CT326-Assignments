/**
 * @Student_ID 07013418
 * @Author Luke Potter
 * @Course 3rd B.Sc. I.T.
 * @Date 06/November/2009
 */

package ct326.assignment07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignmentSevenTest {

	public static void main(String[] args) {
		
		//Create ArrayList and Rational types
		List <Rational> ratlst = new ArrayList <Rational> ();
		
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
		
		//Add the Rational types to the ArrayList
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
		
		//Print out the list
		System.out.println("The unsorted List is: " +ratlst);
		
		//Sort the List
		Collections.sort(ratlst);
		
		//Re-Print List
		System.out.println("The sorted List is: " +ratlst);
		
		//Shuffle the list
		Collections.shuffle(ratlst);
		
		//Print the List again
		System.out.println("The Shuffled List is: " +ratlst);
		
		//Sort List using Custom Comparator
		CustomComparator cc = new CustomComparator ();
		Collections.sort(ratlst, cc);
		
		//Print Resulting List
		System.out.println("The sorted List is: " +ratlst+ "\n");
		
		//Searching for elements
		searchForElement (ratlst, r3);
		System.out.print("\n");
		
		Rational r10 = new Rational ("10/25");
		searchForElement (ratlst, r10);
	}
	
	public static void searchForElement (List<Rational> rlst, Rational r) {
		
		//Search for fraction
		int location = Collections.binarySearch(rlst, r);
		
		System.out.println("Searching for " +r+ " in list...");
		
		if (location >= 0) 
			System.out.println("Element, " + r + ", found at position " + location);
		
		else
			System.out.println("Element, " + r + ", not found!!");
	}
}
