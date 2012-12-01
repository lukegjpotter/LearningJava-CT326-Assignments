/**
 * @author Luke Potter
 * @studentid 07013418
 * @course 3rd B.Sc. I.T.
 * @date 12/02/2010 
 */

package ct326.assignment10;

public class Consumer extends Thread {

	//Declare Variables
	private IntBuffer cubbyhole;
	private int num;
	private long starttime, runlength;
	
	//Constructor
 	public Consumer (IntBuffer c, int n) {
		
		setCubbyhole(c);
		setNum(n);
		starttime = System.currentTimeMillis();
		runlength = 10000;
	}
	
	//Set Cubbyhole method
	public void setCubbyhole (IntBuffer cubbyhole) {
		
		this.cubbyhole = cubbyhole;
	}
	
	//Get Cubbyhole method
	public IntBuffer getCubbyhole() {
		
		return cubbyhole;
	}
	
	//Set Num method
	public void setNum (int num) {
		
		this.num = num;
	}
	
	//Get Num method
	public int getNum() {
		
		return num;
	}
	
	//Run Method
	public void run() {
		
		int value = 0;
		
		while (System.currentTimeMillis() - starttime < runlength){
			
			value = cubbyhole.get();
			System.out.println("Consumer " + getNum() + " recieved: " + value);
		}
	}
}
