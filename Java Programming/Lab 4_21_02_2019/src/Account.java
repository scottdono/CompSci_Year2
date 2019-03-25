/****************************************
* Program description: Demonstrating interfaces and using a GUI
* Author: Scott Donnelly
* Date: 21/02/2019
*****************************************/

public class Account implements ValidatedAccount
{
	//Attributes
	private String accountName;
	private int accountNumber;
	private String sortCode;
	private String branchName;
	private boolean inCredit;
	private double accountBalance;
	//This attribute is static so there is only one copy of it
	private static int currentNumber = 100;
	
	//Constructor
	public Account(String accountName, String sortCode, String branchName, boolean inCredit, double accountBalance)
	{
		currentNumber = currentNumber+1;
		
		this.setAccountName(accountName);
		this.setAccountNumber(currentNumber);
		this.setSortCode(sortCode);
		this.setBranchName(branchName);
		this.setInCredit(inCredit);
		this.setAccountBalance(accountBalance);
	}
	//Methods
	//Takes in an amount to be deposited, and adds this amount to the account balance
	public void Deposit(double depositAmount)
	{
		setAccountBalance((getAccountBalance()+depositAmount));
	}
	/*Takes in an amount to be deposited, and reduces the account balance by this amount. 
	If the account balance goes below zero, set inCredit to false.*/
	public void Withdraw(double takeAmount)
	{
		setAccountBalance((getAccountBalance()-takeAmount));
		System.out.println("Your balance is now €"+getAccountBalance()+"\n");
		if(getAccountBalance()<0)
		{
			inCredit = false;
		}
	}
	
	/***********************************************************************************
	 								Getters & Setters
	 **********************************************************************************/
	
	public String getAccountName() 
	{
		return accountName;
	}
	public void setAccountName(String accountName) 
	{
		this.accountName = accountName;
	}
	public int getAccountNumber() 
	{
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) 
	{
		this.accountNumber = accountNumber;
	}
	public String getSortCode() 
	{
		return sortCode;
	}
	public void setSortCode(String sortCode) 
	{
		this.sortCode = sortCode;
	}
	public String getBranchName() 
	{
		return branchName;
	}
	public void setBranchName(String branchName) 
	{
		this.branchName = branchName;
	}
	public boolean isInCredit() 
	{
		return inCredit;
	}
	public void setInCredit(boolean inCredit) 
	{
		this.inCredit = inCredit;
	}
	public double getAccountBalance() 
	{
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) 
	{
		this.accountBalance = accountBalance;
	}
	public static int getCurrentNumber() 
	{
		return currentNumber;
	}
	public static void setCurrentNumber(int currentNumber) 
	{
		Account.currentNumber = currentNumber;
	}
	
	/***********************************************************************************
	 **********************************************************************************/
	
	//Methods from interface
	@Override
	public void getDetails() 
	{
		System.out.println("This is a normal account.");
		
	}
	@Override
	public void valuableAccount() 
	{
		
		System.out.println("The account balance is €"+getAccountBalance());
	}
	
}
