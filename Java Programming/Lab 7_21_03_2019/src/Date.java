
public class Date 
{
	//Declaring attributes
	private int day;
	private int month;
	private int year;
	
	//Constructor
	public Date(int day, int month, int year)
	{
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	
	/*Getters/Setters
	***********************************************/
	public int getDay() {
		return day;
	}

	public void setDay(int day) 
	{
		//Check to make sure days are valid.
		if(1<=day || day<=31)
		{
			this.day = day;
		}
		else
			System.out.println("Invalid day value! Must be in the range of 1-31 inclusive.");
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) 
	{	
		//Same error check.
		if(1<=month || month<=12)
		{
			this.month = month;
		}
		else
			System.out.println("Invalid month value! Must be in the range of 1-12 inclusive.");
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	//***************************************************
	
	public String toString()
	{
		return(getDay()+"/"+getMonth()+"/"+getYear());
	}
}
