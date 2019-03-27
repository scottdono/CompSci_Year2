import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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
	private JMenuItem menuItem;
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

		menuItem = new JMenuItem("Open...", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Open...");
		menu.add(menuItem);
		menuItem = new JMenuItem("Save...", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Save...");
		menu.add(menuItem);
		
		menu.addSeparator();
		
		submenu = new JMenu("Files to include...");
		submenu.setMnemonic(KeyEvent.VK_S);
	
		menuItem = new JMenuItem("Choose a new file...");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);
		
		cbMenuItem = new JCheckBoxMenuItem("Library.txt");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		submenu.add(cbMenuItem);
		menu.add(submenu);
	
		cbMenuItem = new JCheckBoxMenuItem("Catalogue.txt");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		submenu.add(cbMenuItem);
		menu.add(submenu);
		
		this.setJMenuBar(menuBar);
	
		//-----------------------------------------------------------------
		
		//Create a section of screen that will hold some GUI components
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		search.addActionListener(this);
		
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