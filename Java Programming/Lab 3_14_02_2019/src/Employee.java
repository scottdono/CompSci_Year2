/****************************************
* Program description: Demonstrating inheritance
* Author: Scott Donnelly
* Date: 14/02/2019
*****************************************/

public class Employee 
{
	
	//Declaring Attributes
	private String firstName;
	private String surName;
	private int staffNumber;
	private double annualSalary;


	//Constructors & Methods
	//Constructing the attributes
	public Employee(String firstName, String surName, int staffNumber, double annualSalary)
	{
		this.setFirstName(firstName);
		this.setSurName(surName);
		this.setStaffNumber(staffNumber);
		this.setAnnualSalary(annualSalary);
		
	}
	/*Getters/Setters
	***********************************************/
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getSurName() 
	{
		return surName;
	}

	public void setSurName(String surName) 
	{
		this.surName = surName;
	}

	public int getStaffNumber() 
	{
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber) 
	{
		this.staffNumber = staffNumber;
	}

	public double getAnnualSalary() 
	{
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) 
	{
		this.annualSalary = annualSalary;
	}
	//***************************************************
	
	public float calculatePay()
	{
		
		return (float) (this.getAnnualSalary()/12);
	}
	
	
	public String toString()
	{
		return("This is employee is called "+getFirstName()+" "+getSurName()+" and has an annual salary of €"+getAnnualSalary()+". The monthly pay is €"+this.calculatePay());
	}
}


