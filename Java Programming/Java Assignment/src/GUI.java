
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
	private JButton search;
	private JLabel instruction;
	private JTextField textBox;
	
	//public static String FILENAME = "C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\src\\test.txt";
	
	TestFileIO Test = new TestFileIO();
	
	// Constructor
  
	public GUI ()
	{
		super("My GUI");
		// sets the screen layout
		setLayout(new BorderLayout());
		
	
		instruction = new JLabel("Please enter a string to search for...");
		textBox = new JTextField("",20);
		search = new JButton("Search");

		
		//create a section of screen that will hold some GUI components
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();	
		
		search.addActionListener(this);
		
		//add the label/button we created to the panel
		northPanel.add(instruction);
		mainPanel.add(textBox);
		mainPanel.add(search);
		
		
		//add the panel to the screen
		add(mainPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		//set the location of the screen
		setLocation(650,250);
		
		//Define the size of the frame
		setSize(500,500);
		
		//Make the screen appear
		setVisible(true);
		
	}
/**********************************************************
 Event Programming
**********************************************************/	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		TestFileIO Test = new TestFileIO();
		
		if(arg0.getSource() == search)
		{
			String input = textBox.getText();
			input = input.toLowerCase();
			try 
			{
				Test.parseFile("C:\\Users\\Scott\\Documents\\GitHub\\CompSci_Year2\\Java Programming\\Java Assignment\\src\\ClassicBooks.txt", input);
			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
				JOptionPane.showMessageDialog(null, "You're guess of "+input+" is too low. Guess again.");
			*/
		}
	}
}