/****************************************
* Program description: Demonstrating inheritance
* Author: Scott Donnelly
* Date: 14/02/2019
*****************************************/

public class commissionEmployee extends Employee
{
	private double commissionEarned;
	
	//Contructor
	public commissionEmployee(String firstName, String surName, int staffNumber, double annualSalary, double hourlyPay, double hoursWorked, double commissonEarned)
	{
		super(firstName, surName, staffNumber,annualSalary);
		this.setCommissionEarned(commissionEarned);
	}
	
	/*Getters&Setters
	 *******************************************************************/
	public double getCommissionEarned() {
		return commissionEarned;
	}

	public void setCommissionEarned(double commissionEarned) {
		this.commissionEarned = commissionEarned;
	}
	//*******************************************************************
	
	public float calculateWeeklyPay() //over-riding
	{
		
		return (float) (this.getAnnualSalary()/12 + this.getCommissionEarned());
	}
	
	public String toString()
	{
		return (super.toString() + "and commission earned is " + getCommissionEarned()); //you can inherit the toString class from earlier on
	}
}
