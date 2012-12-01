/**
 * @author Luke Potter
 * @studentid 07013418
 * @course 3rd B.Sc. I.T.
 * @date 12/02/2010 
 */

package ct326.assignment10;

public class IntBuffer {

	//Declare Variables
	private int contents;
	private boolean available = false;
	
	//Get method
	public synchronized int get() {
		
		while (!available) {
			
			try {
				
				//Wait for a value to be inserted by the Producer
				wait();
			}
			catch (InterruptedException e) {
				
				System.out.println("Wait interrupted");
			}
		}
		
		available = false;
		//Notify all producers that a value has been inserted
		notifyAll();
		
		//Return the contents of the IntBuffer
		return contents;
	}
	
	//Put method
	public synchronized void put(int val) {
		
		while (available) {
			
			try {
				
				//Wait for a Consumer to get a value
				wait();
			}
			catch(InterruptedException e) {
				
			}
		}
		
		contents = val;
		available = true;
		
		//Notify all Consumers that a value has been set
		notifyAll();
	}
}
