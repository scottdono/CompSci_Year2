
public class Employee extends Person
{
	//Declaring attributes
	private Job job;
	private int personnelNum;
	private Date startDate;
	private static int nextNum = 0;
	
	//Constructor
	public Employee(String firstName, String surName, String gender, int personnelNum, int day, int month, int year, int sDay, int sMonth, int sYear, String role, double salary, int JobID) 
	{
		super(firstName, surName, gender, day, month, year);
		
		this.job = new Job(salary, role, JobID);
		this.setNextNum(nextNum);
		this.setPersonnelNum(personnelNum);
		this.startDate = new Date(sDay, sMonth, sYear);
		nextNum+=1;
	}
	
	/*Getters/Setters
	***********************************************/

	public int getPersonnelNum() {
		return personnelNum;
	}

	public void setPersonnelNum(int personnelNum) {
		this.personnelNum = nextNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	//***************************************************
	
	public String toString()
	{
		return("First name: "+getFirstName()+"\nSurname: "+getSurName()+"\nDOB: "+getDateOfBirth()+"\nGender: "+getGender()+"\n"+job+"\nPersonnel Number: "+getPersonnelNum()+"\nStart Date: "+startDate);
	}
}
