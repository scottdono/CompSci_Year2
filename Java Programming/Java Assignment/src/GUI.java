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
	private JButton search;
	private JLabel instruction;
	private JTextField textBox;
	private JMenu menu;
	private JMenu submenu;
	private JMenuBar menuBar;
	private JMenuItem menuItem;
	private JCheckBoxMenuItem cbMenuItem;
	
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
		
		//-----------------MENU BAR STUFF---------------------------
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);

		menuItem = new JMenuItem("Select which files to include.", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Select which files to include.");
		menu.add(menuItem);
		
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);
	
		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);
		
		cbMenuItem = new JCheckBoxMenuItem("Library.txt");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		submenu.add(cbMenuItem);
		menu.add(submenu);
	
		cbMenuItem = new JCheckBoxMenuItem("whatever.txt");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		submenu.add(cbMenuItem);
		menu.add(submenu);
	
		//-----------------------------------------------------------------
		
		//create a section of screen that will hold some GUI components
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		//JFrame frame = new JFrame();
		
		search.addActionListener(this);
		
		//add the label/button we created to the panel
		mainPanel.add(instruction);
		mainPanel.add(textBox);
		mainPanel.add(search);
		northPanel.add(menuBar);
		
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