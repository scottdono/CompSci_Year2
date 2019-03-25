

class Animals 
{
	//Attributes
	private String name;
	private String breed;
	private int age;
	private boolean domesticAnimal;
	private String colour;
	
	//Constructors
	public Animals(String name)
	{
		this.setName(name);
	}
	
	public Animals(String name, String breed, int age, boolean domesticAnimal, String colour)
	{
		this.setName(name);
		this.setBreed(breed);
		this.setAge(age);
		this.setDomesticAnimal(domesticAnimal);
		this.setColour(colour);
	}
	//Methods
	public String toString()
	{
		return("Name: "+getName()+".\n"
				+"Breed: "+getBreed()+".\n"
				+"Age: "+getAge()+".\n"
				+"Domesticated: "+isDomesticAnimal()+".\n"
				+"Colour: "+getColour()+".\n");
	}
	//Getters/Setters
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getBreed() 
	{
		return breed;
	}

	public void setBreed(String breed) 
	{
		this.breed = breed;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public boolean isDomesticAnimal() 
	{
		return domesticAnimal;
	}

	public void setDomesticAnimal(boolean domesticAnimal) 
	{
		this.domesticAnimal = domesticAnimal;
	}

	public String getColour() 
	{
		return colour;
	}

	public void setColour(String colour) 
	{
		this.colour = colour;
	}

	//Comparison method
	public void makeNoise()
	{
		if(getBreed().equals("Beagle"))
		{
			System.out.println("*Woof*");
		}
		else if(getBreed().equals("Lion"))
		{
			System.out.println("*ROOAAARRR*");
		}
	}
	public void makeNoise(boolean old)
	{
		if(old)
		{
			System.out.println("Quiet animal");
		}
		else
		{
			makeNoise();
		}
	}
	
}//end main()
