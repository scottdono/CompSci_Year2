
import java.io.*;

public class FileProcessor
{
	
	final String[] roles = new String[5];
	private String FILENAME;
	
	public FileProcessor (String FILENAME)
	{
		this.FILENAME = FILENAME;
	}
	
	public void read()
	{
		BufferedReader br = null;
		FileReader fr = null;
		int i=0;
		String sCurrentLine;
		
		try
		{
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			
			while (br.readLine() != null)
			{
				sCurrentLine = br.readLine();
				roles[i] = sCurrentLine;
				i++;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if(br != null)
					br.close();
				
				if(fr != null)
					fr.close();
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public boolean checkRole()
	{
		int i = 0;
		Job j1 = new Job(i, FILENAME, i);
		
		while(i<5)
		{
			if(roles[i].equals(j1.getRole()))
			{
				break;
			}
			else
			{
				i++;
			}

		}
		return true;
	}
}
