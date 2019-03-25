
public class Job 
{
	//Declaring attributes
	private double salary;
	private String role;
	private int jobID;
	
	//Constructor
	public Job(double salary, String role, int jobID)
	{
		this.setSalary(salary);
		this.setRole(role);
		this.setJobID(jobID);
	}
	
	/*Getters/Setters
	***********************************************/
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) 
	{
		FileProcessor f1 = new FileProcessor("roles.txt");
		if(f1.checkRole()==true)
		{
			System.out.println("This is a valid role.");
			this.role = role;
		}
		else
			System.out.println("This is an invalid role.");
			
	}

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	//***************************************************
	
	public String toString()
	{
		return("Job ID: "+getJobID()+"\nRole: "+getRole()+"\nSalary: €"+getSalary());
	}
	
	//File i/o 
	
	
	
}
