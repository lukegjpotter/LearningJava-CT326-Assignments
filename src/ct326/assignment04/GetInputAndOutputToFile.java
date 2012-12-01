/**
 * @studentid 07013418
 * @author Luke GJ Potter
 * @date 16th/October/2009
 */

package ct326.assignment04;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GetInputAndOutputToFile {

	public static void main(String[] args) throws IOException {

		try {
			//Declare String for the file name
			String filename = "StudentDetails.txt";
			//Set up InputStreamReader and BufferedReader
			InputStreamReader input = new InputStreamReader (System.in);
			BufferedReader reader = new BufferedReader (input);
			
			//Get input
			//For Name
			System.out.println("Input Name:");
			String name = reader.readLine();
			
			while (name == "" || name == null) {
				
				System.out.println("Your input is invalid, Please Input Name:");
				name = reader.readLine();
			}
			
			//For Address
			System.out.println("Input Address:");
			String address = reader.readLine();
			
			while (address == "" || address == null) {
				
				System.out.println("Your input is invalid, Please Input Address:");
				address = reader.readLine();
			}
			
			//For Student Number
			System.out.println("Input Student Number:");
			String stdnum = reader.readLine();
			
			while (address == "" || address == null) {
				
				System.out.println("Your input is invalid, Please Input Student Number:");
				stdnum = reader.readLine();
			}
			
			System.out.println("Thank you");
			
			//Set up FileWriter and PrintWriter
			FileWriter fw = new FileWriter(filename);
			PrintWriter pw = new PrintWriter(fw);
			
			//Write input to file
			pw.println(name);
			pw.println(address);
			pw.println(stdnum);
			
			//Close the file
			pw.close();
			System.exit(0);
		}
		
		catch (Exception e) {
			
			System.out.println("Weekly Salary must be positive");
			System.err.println(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
}