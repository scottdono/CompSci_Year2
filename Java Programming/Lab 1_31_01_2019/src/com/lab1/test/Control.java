/****************************************
* Program description: Control class that contains main function
* Author: Scott Donnelly
* Date: 31/01/2019
*****************************************/

package com.lab1.test;

public class Control
{

	public static void main(String[] args) 
	{
		
		Vehicle myCar = new Vehicle("Scott Donnelly");
		Vehicle hisCar = new Vehicle("Erik Grunner","07-D-14467", "Golf", "Volkswagen", "Black");
		System.out.println(myCar);
		System.out.println(hisCar);

	}

}
