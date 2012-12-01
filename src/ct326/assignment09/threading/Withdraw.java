/**
 * @author 07013418 Luke Potter
 * @course 3rd B.Sc. I.T.
 * @date 22/January/2010
 */

package ct326.assignment09.threading;

public class Withdraw extends Thread {

	//Declare Variables
	Account acc;
	double ammount;
	
	public Withdraw (Account a, double amm) {
		
		this.acc = a;
		this.ammount = amm;
	}
	
	public void Run () {
		
		acc.withdraw(ammount);
	}
}
