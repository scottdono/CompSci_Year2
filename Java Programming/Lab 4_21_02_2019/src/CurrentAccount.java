/****************************************
* Program description: Demonstrating interfaces and using a GUI
* Author: Scott Donnelly
* Date: 21/02/2019
*****************************************/

public class CurrentAccount extends Account
{
	private double penaltyAmount;
	
	//Constructor
	public CurrentAccount(String accountName, String sortCode, String branchName, boolean inCredit, double accountBalance, double penaltyAmount)
	{
		super(accountName, sortCode, branchName, inCredit, accountBalance);
		this.penaltyAmount = penaltyAmount;
	}
	
	//Methods
	public void checkCredit(double takeAmount)
	{
		//check if the withdraw brings the balance to less than €0.00
		if(getAccountBalance()-takeAmount<0)
		{
			setInCredit(false);
		}
		//prompt the user if they try to withdraw more than their balance
		if(isInCredit() == false)
		{
			System.out.println("Insufficient Funds!");
		}
		//prompt the user if their account balance is getting low
		if(getAccountBalance()>0 && getAccountBalance()<100)
		{
			System.out.println("Your Account balance is getting low.\n");
			valuableAccount();
		}
	}
	public void Withdraw(double takeAmount)
	{
		checkCredit(takeAmount);
		if(getAccountBalance()-takeAmount>0)
		{
			setAccountBalance((getAccountBalance()-takeAmount));
			valuableAccount();
		}
	}
	
	public void getDetails() 
	{
		System.out.println("This is a current account.");
		
	}
}
