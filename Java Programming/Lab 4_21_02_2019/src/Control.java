/****************************************
* Program description: Demonstrating interfaces and using a GUI
* Author: Scott Donnelly
* Date: 21/02/2019
*****************************************/

public class Control 
{

	public static void main(String[] args) 
	{
		//Instantiating each type of account
		Account Scott = new Account("Scott Donnelly","EBSII2011","EBS",true, 420);
		CurrentAccount Rob = new CurrentAccount("Robert Ichim","BOII2929", "Bank Of Ireland", true, 69, 0);
		DepositAccount Dan = new DepositAccount("Dan Connell", "KBCI4242", "KBC", true, 3000, 0.7);
		
		System.out.println("The Account number is "+Scott.getAccountNumber());
		Scott.getDetails();
		Scott.Withdraw(50);
		
		System.out.println("The Account number is "+Rob.getAccountNumber());
		Rob.getDetails();
		Rob.Withdraw(80);
		
		System.out.println("The Account number is "+Dan.getAccountNumber());
		Dan.getDetails();
		Dan.Withdraw(50);
		
	}

}
