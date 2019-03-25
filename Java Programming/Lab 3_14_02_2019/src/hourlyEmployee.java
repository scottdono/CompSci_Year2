/****************************************
* Program description: Demonstrating inheritance
* Author: Scott Donnelly
* Date: 14/02/2019
*****************************************/

public class hourlyEmployee extends Employee
{
	private double hourlyPay;
	private double hoursWorked;
	
	public hourlyEmployee (String firstName, String surName, int staffNumber, double annualSalary, double hourlyPay, double hoursWorked)
	{
		super(firstName, surName, staffNumber,annualSalary);
		this.setHourlyPay(hourlyPay);
		this.setHoursWorked(hoursWorked);
	}
	
	/*Getters&Setters
	 *******************************************************************/
	public double getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	//*******************************************************************
	
	public float calculateWeeklyPay()
	{
		
		return (float) (getHourlyPay()*getHoursWorked());
	}
	
	public String toString()
	{
		return("This is employee is called "+getFirstName()+" "+getSurName()+" and has an annual salary of €"+getAnnualSalary()+". The weekly pay is €"+this.calculateWeeklyPay());
	}
}



