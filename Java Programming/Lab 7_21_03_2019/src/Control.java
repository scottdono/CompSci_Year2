
public class Control 
{

	public static void main(String[] args) 
	{
		// Test to instantiate Date/Job classes
		Date birthday = new Date(04,02,1999);
		Job bunsen = new Job(15000,"Waiter", 2072);

		//System.out.println(birthday.toString());
		//System.out.println(bunsen.toString());
		
		//Testing the Person and Employee classes
		Person Scott = new Person("Scott", "Donnelly", "Male", 04, 02, 1999);
		//Entering values into Employee goes First name, Surname, Gender, PersonnelNo, NextNo, DOB dd/mm/yy, Start date dd/mm/yy , Role, Salary, JobID
		Employee Dono = new Employee("Scott", "Donnelly", "Male", 2072, 04, 02, 1999, 01, 01, 2019, "Waiter", 15000, 2072);
		
		//System.out.println(Scott.toString());
		System.out.println(Dono.toString());
		
	}

}
