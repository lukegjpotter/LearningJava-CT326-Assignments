/**
 * @author Luke Potter
 * @studentid 07013418
 * @course 3rd B.Sc. I.T.
 * @date 12/02/2010 
 */

package ct326.assignment10;

public class Assignment10Driver {

	public static void main(String[] args) {
		
		//Create IntBuffer
		IntBuffer ib = new IntBuffer();
		
		//Create Producers
		Producer pro1 = new Producer (ib, 1);
		
		//Create Consumers
		Consumer con1 = new Consumer (ib, 1);
		
		//Start the threads
		pro1.start();
		con1.start();
	}
}
