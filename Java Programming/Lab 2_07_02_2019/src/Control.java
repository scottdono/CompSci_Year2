/****************************************
* Program description: Control class
* Author: Scott Donnelly
* Date: 07/02/2019
*****************************************/
import java.util.Scanner;

public class Control 
{

	public static void main(String[] args) 
	{
		Animals A1 = new Animals("Spot");
		Animals A2 = new Animals("Spot","Beagle",5,true,"Brown");
		Animals A3 = new Animals("Leo","Lion",10,false,"Gold/Brown");
		
		//Testing user input from keyboard
		Scanner input = new Scanner(System.in); 
 	 	System.out.print("Enter a name > "); 
 	 	String inputString = input.nextLine(); 
 	 	System.out.println(inputString); 
 	 	
 	 	//Testing getters & setters
 	 	A1.setName(inputString);

		
		System.out.println(A1);
		System.out.println(A2);
		A2.makeNoise();
		System.out.println(A3);
		A3.makeNoise(true);
		
		//Testing Encapsulation
		 
		/*A1.name = "Scott";
		
		System.out.println(A1.name);
		System.out.println(A2.colour);
		System.out.println(A3.breed);
		*/
		
		
	}

}
