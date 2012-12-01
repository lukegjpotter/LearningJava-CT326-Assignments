/**
 * @studentid 07013418
 * @author Luke GJ Potter
 * @course 3rd B.Sc. I.T.
 * @date 23/October/2009
 */

//Import Package
package ct326.assignment05;

//Import all libraries in java.io
import java.io.*;

public class SerializedArray extends Rational implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		
		//Declare Variables
		final int SIZE = 5;
		Rational [] ratarr = new Rational [SIZE];
		Rational [] newarr = new Rational [SIZE];
		Rational time = new Rational ();
		String filename1 = "SerializedRationalArray.txt";
		String filename2 = "Part2.txt";
		
		//Declare Rational Types
		Rational r1 = new Rational ("1/2");
		Rational r2 = new Rational ("1/3");
		Rational r3 = new Rational ("1/4");
		Rational r4 = new Rational ("1/5");
		Rational r5 = new Rational ("1/6");
		
		//Put Rational Types into Array
		ratarr [0] = r1;
		ratarr [1] = r2;
		ratarr [2] = r3;
		ratarr [3] = r4;
		ratarr [4] = r5;
		
		try {
			
			//Declare the streams to be used
			FileOutputStream fos1 = new FileOutputStream (filename1);
			FileOutputStream fos2 = new FileOutputStream (filename2);
			ObjectOutputStream oos = new ObjectOutputStream (fos1);
			
			//Write array to file
			oos.writeObject(ratarr);
			
			//Change pointer of the Object Output Stream
			oos = new ObjectOutputStream (fos2);
			fos1.close();
			
			//Call the Write Object method to writ the time to a file
			time.writeObject(oos);
			
			//Flush and Close the Object Output Stream
			oos.flush();
			oos.close();
		}
		
		catch (FileNotFoundException e) {
			
			System.out.println("File Not Found");
			System.err.println(e.getMessage() + "\n");
			e.printStackTrace();
		}
		
		try {
			
			//Read from file
			FileInputStream fis1 = new FileInputStream (filename1);
			FileInputStream fis2 = new FileInputStream (filename2);
			ObjectInputStream ois = new ObjectInputStream (fis1);
			
			//Reconstruct in a new array
			newarr = (Rational[]) ois.readObject();
			
			//Change the pointer of the Input Stream
			ois = new ObjectInputStream (fis2);
			time.readObject(ois);
			fis1.close();
			
			//Close the Input Stream
			ois.close();
			
			//Print out the contents of new array
			System.out.println("The Rational Numbers that were written to the file were:");
			for (int i = 0; i < SIZE; i++) {
				System.out.println(newarr[i].toString());
			}
		}
		
		catch (FileNotFoundException e) {
			
			System.out.println("File Not Found");
			System.err.println(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
}
