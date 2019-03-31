import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
	private JMenu menu;
	private JMenu help;
	private JMenu exit;
	private JMenu submenu;
	private JMenuBar menuBar;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem about;
	private JMenuItem link;
	private JMenuItem end;
	private JCheckBoxMenuItem cbMenuItem;
	
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
		
		//-----------------MENU BAR STUFF---------------------------
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
		save = new JMenuItem("Save...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\save.png"));
		save.getAccessibleContext().setAccessibleDescription("Save...");
		menu.add(save);
		about = new JMenuItem("About this program...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\help.png"));
		about.getAccessibleContext().setAccessibleDescription("Gives a set of instructions about the program.");
		help.add(about);
		link = new JMenuItem("Video Explanation...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\video.png"));
		link.getAccessibleContext().setAccessibleDescription("Opens a webpage with a video about the program.");
		help.add(link);
		end = new JMenuItem("Terminate the program...", new ImageIcon("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\GUI Icons\\exit.png"));
		end.getAccessibleContext().setAccessibleDescription("Terminates the program.");
		exit.add(end);
		
		submenu = new JMenu("Files to include...");
		submenu.setMnemonic(KeyEvent.VK_S);
		
		this.setJMenuBar(menuBar);
	
		//-----------------------------------------------------------------
		
		//Create a section of screen that will hold some GUI components
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		search.addActionListener(this);
		open.addActionListener(this);
		link.addActionListener(this);
		end.addActionListener(this);
		about.addActionListener(this);
		
		//Add the label/button we created to the panel
		mainPanel.add(instruction);
		mainPanel.add(textBox);
		mainPanel.add(search);
		
		//Add the panel to the screen
		add(mainPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		//Set the location of the window to the middle of the screen.
		setLocation(650,250);
		
		//Define the size of the window.
		setSize(500,500);
		
		//Make the screen appear.
		setVisible(true);
		
	}
	
	//Method to add files that you can tick off.
	public void newfiles(String FILENAME)
	{
		cbMenuItem = new JCheckBoxMenuItem(FILENAME);
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		submenu.add(cbMenuItem);
		menu.add(submenu);
	}
/**********************************************************
 Event Programming
**********************************************************/	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		TestFileIO Test = new TestFileIO();
		String direct = null;
		String FILENAME;
		
		
		//This lets the user find files on their system to be searched.
		if(arg0.getSource() == open)
		{
			final JFileChooser fc = new JFileChooser();
			//This adds a filter to the file chooser so that only text files can be selected.
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			fc.setFileFilter(filter);
			
			int returnVal = fc.showOpenDialog(this);

	        if (returnVal == JFileChooser.APPROVE_OPTION) 
	        {
	            File file = fc.getSelectedFile();
	            direct = file.getAbsolutePath();
	            //System.out.println(direct);
	            
	            //call method to add the new file to the list.
	            FILENAME = file.getName();
	            newfiles(FILENAME);
	        } 
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
				d.browse(new URI("https://www.youtube.com/watch?v=C_Y6yrkj9Sg"));
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
		if(arg0.getSource() == search)
		{
			String input = textBox.getText();
			input = input.toLowerCase();
			try 
			{
				Test.parseFile(direct, input);
			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}