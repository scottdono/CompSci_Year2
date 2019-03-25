/****************************************
* Program description: Demonstrating inheritance
* Author: Scott Donnelly
* Date: 14/02/2019
*****************************************/


public class Control 
{

	public static void main(String[] args) 
	{
		Employee Scott = new Employee("Scott","Donnelly",17325426,80000);
		hourlyEmployee Aaron = new hourlyEmployee("Aaron","Mumbles", 69696969, 35000, 9.90, 40);
		commissionEmployee Erik = new commissionEmployee("Erik","You know the rules", 0000001, 20000, 100000);
		
		System.out.println(Scott);
		System.out.println(Aaron);
		System.out.println(Erik);

	}

}
