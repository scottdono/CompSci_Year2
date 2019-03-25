
public class Person 
{
	
	//Declaring attributes
	private String firstName;
	private String surName;
	private Date dateOfBirth; //Date type is from the date class
	private String gender;
	
	//Constructor
	public Person(String firstName, String surName, String gender, int day, int month, int year) 
	{
		this.setFirstName(firstName);
		this.setSurName(surName);
		this.setGender(gender);
		this.setDateOfBirth(new Date(day, month, year));
	}
	
	/*Getters/Setters
	***********************************************/
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	//***************************************************
	
	public String toString()
	{
		return("First name: "+getFirstName()+"\nSurname: "+getSurName()+"\nDOB: "+getDateOfBirth()+"\nGender: "+getGender());
	}
	
}
