/*This class is used to open and parse through the files desired by the user
 * 
 * I keep all the attributes private and use getters and setters to access them.
 * 
 * I thought about more efficient ways to search through the text files in case speed was an issue
 * but the results are instant by just going line by line. If speed was an issue I would've implemented
 * a hashmap data structure.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestFileIO 
{
	//Initialising the variables
	private Scanner scan;
	private int counter = 0;
	private String line;
	//Constructor
	public TestFileIO()
	{
		this.setScan(scan);
		this.setCounter(counter);
		this.setLine(line);
	}
	
	public String parseFile(String FILENAME,String searchStr)
	{
        try
        {	
        	setScan(new Scanner(new File(FILENAME)));
	        while(getScan().hasNext())
	        {
	            setLine(getScan().nextLine().toLowerCase().toString());
	            if(getLine().contains(searchStr))
	            {
	            	setCounter(getCounter() + 1);
	                //System.out.println(getLine()+"\n");
	            }
	        }
        }
        catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String amount = "The string appears <b><u>"+getCounter()+"</b></u> times in this file.";
        //Reset the counter for the next search.
        counter=0;
        return amount;
    }
	
	
	
	
/**********************************************************
 Getters/Setters
**********************************************************/
	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}


} //end of class

