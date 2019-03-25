/****************************************
* Program description: Demonstrating interfaces and using a GUI
* Author: Scott Donnelly
* Date: 21/02/2019
*****************************************/

public class DepositAccount extends Account
{
	private double interestRate;
	
	//Constructor
	public DepositAccount(String accountName, String sortCode, String branchName, boolean inCredit, double accountBalance, double interestRate)
	{
		super(accountName, sortCode, branchName, inCredit, accountBalance);
		this.interestRate = interestRate;
	}
	
	//Methods
	public void Withdraw(double takeAmount)
	{
		System.out.println("You can not withdraw from a deposit account.");
	}
	public void getDetails() 
	{
		System.out.println("This is a Deposit account.");
		
	}
}
	
	