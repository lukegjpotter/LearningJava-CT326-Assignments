/**
 * @author 07013418 Luke Potter
 * @course 3rd B.Sc. I.T.
 * @date 22/January/2010
 */

package ct326.assignment09.threading;

public class TransferFunds extends Thread {
	
	//Declare Variables
	Account acc1, acc2;
	double ammount;
	
	public TransferFunds (Account a1, Account a2, double amm) {
		
		this.acc1 = a1;
		this.acc2 = a2;
		this.ammount = amm;
	}
	
	public void Run () {
		
		acc1.transfer(acc2, ammount);
	}
}
