/****************************************
* Program description: Class that contains all vehicle class info
* Author: Scott Donnelly
* Date: 31/01/2019
*****************************************/
package com.lab1.test;

public class Vehicle 
{
	//Declaring attributes
	private String ownerName;
	private String reg;
	private String model;
	private String make;
	private String colour;
	
	//Con 1 - initialise attributes
	public Vehicle(String ownerName) 
	{
		this.ownerName = ownerName;
	}
	
	//Con 2 - initialise attributes
	public Vehicle(String ownerName, String reg, String model, String make, String colour)
	{
		this.ownerName = ownerName;
		this.reg = reg;
		this.model = model;
		this.make = make;
		this.colour = colour;
		
		System.out.println("Name: "+ownerName+"\nRegistration: "+reg+"\nMake: "+make+"\nModel: "+model+"\nColour: "+colour);
	}

	//Con 3 - Return all vehicle info
	public String toString()
	{
		return("Vehicle Owner: "+ownerName+".\n"
				+"Vehicle Registration: "+reg+".\n"
				+"Vehicle Make: "+make+".\n"
				+"Vehicle Model: "+model+".\n"
				+"Vehicle Colour: "+colour+".\n");
	}
	
}
