// Interfaces in Java

//NOTE: Not to be mixed up with Graphical User Interfaces (GUI), although they are related.

public Interface PrintDetails
{
	//Interfaces mainly consist of empty methods...
	public void printVATNum(String name);
	{
		
	}
	public void printFormatted();
	{

	}	
}

/*Your classes can "implement the interface". 
This gives programmers a guide for what they should implement in their classes.
*/

public class Person implements PrintDetails
{
	//Attributes
	private String name;
	.
	.
	//Constructor
	.
	.
	.
	public void printVATNum(String name)
	{
		System.out.println("PEPE SILVIA");
	}
	public void printFormatted()
	{
		//etc.
	}
	
/***************************************************************************************

Example

***************************************************************************************/

public Interface Details
{
	//methods - they don't need any operations, theyre just method headers
	public int CalculateAge();
	
	public String stateJobRole();
}

public class Employee implements Details
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
	***************************************************
	***************************************************/
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
	/***************************************************
	***************************************************/
	
	public float calculatePay()
	{
		
		return (float) (this.getAnnualSalary()/12);
	}
	public int CalculateAge()
	{
		//Operations
	}
	
	public String stateJobRole()
	{
		//Operations
	}
	
	public String toString()
	{
		return("This is employee is called "+getFirstName()+" "+getSurName()+" and has an annual salary of €"+getAnnualSalary()+". The monthly pay is €"+this.calculatePay());
	}
}

	