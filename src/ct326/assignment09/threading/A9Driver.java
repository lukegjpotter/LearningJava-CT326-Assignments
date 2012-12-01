/**
 * @author 07013418 Luke Potter
 * @course 3rd B.Sc. I.T.
 * @date 22/January/2010
 */

package ct326.assignment09.threading;

public class A9Driver {

	public static void main(String[] args) {
		
		//Declare Variables
		Account a1, a2, a3;
		a1 = new Account (500);
		a2 = new Account (1000);
		a3 = new Account (1500);
		
		//Declare Threads
		Withdraw wt1, wt2, wt3;
		wt1 = new Withdraw (a1, 50);
		wt2 = new Withdraw (a2, 500);
		wt3 = new Withdraw (a3, 50);
		
		Deposit dt1, dt2, dt3;
		dt1 = new Deposit (a1, 500);
		dt2 = new Deposit (a2, 500);
		dt3 = new Deposit (a3, 500);
		
		TransferFunds tf1, tf2, tf3;
		tf1 = new TransferFunds (a1, a2, 300);
		tf2 = new TransferFunds (a2, a3, 400);
		tf3 = new TransferFunds (a3, a1, 500);
		
		//Start Threads
		wt1.start();
		wt2.start();
		wt3.start();
		
		dt1.start();
		dt2.start();
		dt3.start();
		
		tf1.start();
		tf2.start();
		tf3.start();
	}
}
