/**
 * @studentid 07013418
 * @author Luke GJ Potter
 * @course 3rd B.Sc. I.T.
 * @date 23/October/2009
 */

//Package
package ct326.assignment05;

//List of Imports
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileAccessExample {

	public static void main(String[] args) throws IOException {
		
		//Declare Variables
		String filename = "RandomFileAccess.txt";
		String str1 = "This is " + filename + "!!\n";
		long l = System.currentTimeMillis();
		String str2 = "The Current System time is " + l + ".\n";
		float f = (float) 0.765;
		int y = 456;
		int x = 123;
		short s = 21;
		
		//Instantiate the Random Access File for writing
		RandomAccessFile raf = new RandomAccessFile (filename, "rw");
		
		//Write to file
		raf.writeChars(str1);
		raf.writeChars(str2);
		raf.writeFloat(f);
		raf.writeInt(y);
		raf.writeInt(x);
		raf.writeShort(s);
		
		//Close the file
		raf.close();
		
		//Instantiate the Random Access File for reading
		raf = new RandomAccessFile (filename, "r");
		
		//Start reading from the file
		System.out.println(raf.readLine());
		System.out.println(raf.readLine());
		System.out.println(raf.readFloat());
		System.out.println(raf.readInt());
		System.out.println(raf.readInt());
		System.out.println(raf.readShort());
		
		//Close the file
		raf.close();
	}
}