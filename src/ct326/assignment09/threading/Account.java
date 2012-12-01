/**
 * @author 07013418 Luke Potter
 * @course 3rd B.Sc. I.T.
 * @date 22/January/2010
 */

package ct326.assignment09.threading;

public class Account {

	//Declare Variables
	double balance;
	
	//Constructor
	public Account (double bal) {
		
		this.balance = bal;
	}
	
	//Get Balance Method
	public String getBalance () {
		
		return "Balance : " + balance;
	}
	
	//Deposit Method
	public synchronized void deposit (double ammount) {
		
		balance += ammount;
		System.out.println("€" + ammount + " deposited! " +getBalance ());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Withdraw Method
	public synchronized void withdraw (double ammount) {
		
		if (balance - ammount < 0)
			System.out.println("Insuffencent Funds " + getBalance());
		
		else{
			balance -= ammount;
			System.out.println("€" + ammount + " withdrawn! " +getBalance ());
		}
	}
	
	//Transfer Method
	public synchronized void transfer (Account to, double ammount) {
		
		withdraw(ammount);
		to.deposit(ammount);
	}
}
