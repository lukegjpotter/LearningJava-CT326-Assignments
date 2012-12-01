/**
 * @studentid 07013418
 * @author Luke GJ Potter
 * @date 16th/October/2009
 */

package ct326.assignment04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class FileOperations {

	static LineNumberReader lnr;
	
	public static void main(String[] args) throws IOException {
		try {
			//Declare Variables
			int numberoflines = 0;
			String lastLine = "";
			
			//Set up InputStreamReader and BufferedReader
			InputStreamReader input = new InputStreamReader (System.in);
			BufferedReader reader = new BufferedReader (input);
			
			System.out.println("Input the name of the file that you would like to get details on.");
			String filename = reader.readLine();
			
			//Set up FileReader and LineNumberReader
			FileReader fr = new FileReader (filename);
			lnr = new LineNumberReader (fr);
			
			//A While loop to output the data
			while (lastLine != null) {
				
				lastLine = lnr.readLine();
				
				if (lastLine == null)
					break;
				
				else {
					
					System.out.println(lastLine);
					numberoflines ++;
				}
			}
			
			//Print out the number of lines in the document
			System.out.println("\nThe number of lines contained in this document is " + numberoflines);
		} catch (Exception e) {
			
			System.out.println("Weekly Salary must be positive");
			System.err.println(e.getMessage() + "\n");
			e.printStackTrace();
		} finally {
			lnr.close();
		}
		
	}
}
