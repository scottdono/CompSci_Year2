/*This class is used to open and parse through the files desired by the user
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestFileIO 
{
	//initialising the variables
	private Scanner scan;
	private int counter = 0;
	private String line;
	
	public TestFileIO()
	{
		this.setScan(scan);
		this.setCounter(counter);
		this.setLine(line);
	}
	
	public String parseFile(String FILENAME,String searchStr) throws FileNotFoundException
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
        String test = "The string appears <b><u>"+getCounter()+"</b></u> times in this file.";
        //Reset the counter for the next search.
        counter=0;
        return test;
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


}

