import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
//import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
	
	//Declaring attributes.
	private JButton search;
	private JLabel instruction;
	private JTextField textBox;
	private JLabel output;
	private JMenu menu;
	private JMenu help;
	private JMenu exit;
	private JMenuItem clear;
	private JMenuBar menuBar;
	private JMenuItem open;
	private JMenuItem about;
	private JMenuItem link;
	private JMenuItem end;
	//private JCheckBoxMenuItem cbMenuItem;
	
	private String results = "<html>Results will be displayed here when you search.</html>";
	private String directory;
	private String FILENAME;
	private int i;
	//Instantiating the file class
	TestFileIO Test = new TestFileIO();
	List<String> files = new ArrayList<String>();
	List<String> names = new ArrayList<String>();
	
	
	// Constructor method.
	public GUI ()
	{
		//Title of the window
		super("Search Engine");
		
		//Sets the screen layout scheme.
		setLayout(new BorderLayout());
		
		//Instantiating elements on the screen.
		instruction = new JLabel("Please enter a string to search for...");
		textBox = new JTextField("",20);
		search = new JButton("Search");
		output = new JLabel(results);
		
/**********************************************************
 Menu Bar
**********************************************************/	
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("File chooser.");
		menuBar.add(menu);
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_A);
		help.getAccessibleContext().setAccessibleDescription("Access info about the application.");
		menuBar.add(help);
		exit = new JMenu("Exit");
		exit.setMnemonic(KeyEvent.VK_A);
		exit.getAccessibleContext().setAccessibleDescription("Exit the program.");
		menuBar.add(exit);
		open = new JMenuItem("Open...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\open.png"));
		open.getAccessibleContext().setAccessibleDescription("Opens the file chooser.");
		menu.add(open);
		about = new JMenuItem("About this program...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\help.png"));
		about.getAccessibleContext().setAccessibleDescription("Gives a set of instructions about the program.");
		help.add(about);
		link = new JMenuItem("Video Explanation...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\video.png"));
		link.getAccessibleContext().setAccessibleDescription("Opens a webpage with a video about the program.");
		help.add(link);
		end = new JMenuItem("Terminate the program...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\exit.png"));
		end.getAccessibleContext().setAccessibleDescription("Terminates the program.");
		exit.add(end);
		clear = new JMenuItem("Clear loaded files...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\clear.png"));
		clear.setMnemonic(KeyEvent.VK_S);
		end.getAccessibleContext().setAccessibleDescription("Clears all the loaded files.");
		menu.add(clear);
		
		this.setJMenuBar(menuBar);
		
/**********************************************************
 Adding setting size, panel location, etc.
**********************************************************/	
		
		//Create a section of screen that will hold some GUI components
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		//adding action listeners to various items in the GUI
		search.addActionListener(this);
		open.addActionListener(this);
		link.addActionListener(this);
		end.addActionListener(this);
		about.addActionListener(this);
		textBox.addActionListener(this);
		
		//Add the label/button we created to the panel
		northPanel.add(instruction);
		northPanel.add(textBox);
		northPanel.add(search);
		mainPanel.add(output);
		
		//Add the panel to the screen
		add(mainPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		//Set the location of the window to the middle of the screen.
		setLocation(650,250);
		
		//Define the size of the window.
		setSize(700,500);
		
		//Make the screen appear.
		setVisible(true);
		
		//Adding some default search files.
		files.add("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\Library\\A Clash of Kings.txt");
		files.add("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\Library\\A Dance with Dragons.txt");
		files.add("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\Library\\A Feast for Crows.txt");
		files.add("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\Library\\A Game of Thrones.txt");
		files.add("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\Library\\A Storm of Swords.txt");
		newFiles("A Clash of Kings");
		newFiles("A Dance with Dragons");
		newFiles("A Feast of Crows");
		newFiles("A Game of Thrones");
		newFiles("A Storm of Swords");
		//this has to be at the bottom because the item doesn't exist until the newFiles() method is called.
		clear.addActionListener(this);
		
	}
	
	//Method to add files that you can tick off.
	public void newFiles(String FILENAME)
	{
		//Originally the menu items were added to a clear.
		//"true" sets the boxes to be checked by default.
		//cbMenuItem = new JCheckBoxMenuItem(FILENAME, true);
		//cbMenuItem.setMnemonic(KeyEvent.VK_C);
		names.add(FILENAME);
	}
	
	//Method to open JFileChooser which allows users to browse their system for files.
	public void openFile(String directory, String FILENAME)
	{
		final JFileChooser fc = new JFileChooser();
		//allows multiple file selection.
		fc.setMultiSelectionEnabled(true);
		//This adds a filter to the file chooser so that only text files can be selected.
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fc.setFileFilter(filter);
		
		int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
        	//Get the file name and file directory and assign them to variables.
            File[] file = fc.getSelectedFiles();
            for(i=0;i<file.length;i++)
            {
	            setDirectory(file[i].getAbsolutePath());
	            files.add(getDirectory());
	            
	            //call method to add the new file to the list.
	            FILENAME = file[i].getName();
	            newFiles(FILENAME);
            }
        } 
	}
	
	//This method is called from within the action listener.
	public void searchFile()
	{
		String input;
		input = textBox.getText();
		input = input.toLowerCase();
		results = "<html><font size=\"4\"><u>Here are your results:</u><br><br>";
		for(i=0;i<files.size();i++)
		{
			//if...else checks if the text box is empty or not
			//the results variable starts with html tags and then information is concatenated to the string
			if(input != null && !input.isEmpty())
			{
				results = results.concat(names.get(i)+" | ").concat(Test.parseFile(files.get(i), input)).concat("<br><br>");
			}
			else
			{
				results = results.concat("Please enter a valid search string.");
				i=files.size();
			}
		}
		//the end of the results variable then gets the rest of the closing tags and the Jlabel is updated.
		results.concat("</font></html>");
		output.setText(results);
	}
	
/**********************************************************
 Event Programming
**********************************************************/	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		
		//This lets the user find files on their system to be searched.
		if(arg0.getSource() == open)
		{
			openFile(getDirectory(), FILENAME);
		}
		
		//This allows you to terminate the program during runtime from within the GUI.
		if(arg0.getSource() == end)
		{
			JOptionPane.showConfirmDialog(null, "Are you sure?", "Are you sure?", JOptionPane.YES_OPTION);
			System.exit(10);
		}
		
		//A simple set of instructions on how to use the program.
		if(arg0.getSource() == about)
		{
			JOptionPane.showMessageDialog(null, "HOW TO USE THE SEARCH ENGINE. \n"
												+ "1. Open a text file using the 'File' >>> 'Open' menu. \n"
												+ "2. Browse for a .txt file on your system that you would like to search through. \n"
												+ "3. Enter your search term into the text box in the program and click 'Search'.");
		}
		
		//This opens a link to a video explaining the program with the user's default browser.
		if(arg0.getSource() == link)
		{
			Desktop d = Desktop.getDesktop();
			try 
			{
				//This will open a new window in the default browser on your system with a specified link.
				d.browse(new URI("https://youtu.be/0Wowb-SKB4g"));
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (URISyntaxException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		//Calls the searching methods to find certain text in a file(s).
		if(arg0.getSource() == search || arg0.getSource() == textBox)
		{
			searchFile();
		}
		
		//This allows the user to dump everything thats currently loaded. I originally wanted to allow users to pick and choose but
		// couldn't figure out the proper functionality.w
		if(arg0.getSource() == clear)
		{
			
			JOptionPane.showConfirmDialog(null, "Would you like to remove the current search files?", "Are you sure?", JOptionPane.YES_OPTION);
			for(i=0;i<files.size();i++)
			{
				files.removeAll(files);
				names.removeAll(names);
			}
		}
	}

/**********************************************************
 Getters/Setters
**********************************************************/
	
public String getDirectory() {
	return directory;
}

public void setDirectory(String directory) {
	this.directory = directory;
}


}