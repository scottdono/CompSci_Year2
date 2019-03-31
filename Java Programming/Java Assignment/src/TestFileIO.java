/*This class is used to open and parse through the files desired by the user
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestFileIO 
{
	
	
	public void parseFile(String FILENAME,String searchStr) throws FileNotFoundException
	{
		System.out.println(FILENAME);
        Scanner scan = new Scanner(new File(FILENAME));
        while(scan.hasNext())
        {
            String line = scan.nextLine().toLowerCase().toString();
            if(line.contains(searchStr))
            {
                System.out.println(line);
            }
        }
    }


}

