
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI extends JFrame implements ActionListener, MouseListener
{
	private JButton search;
	private JButton help;
	private JLabel instruction;
	private JTextField textBox;
	private JLabel heading;
	private JOptionPane error;
	private JOptionPane tips;
	private JLabel mouse;
	
	//String messages for mouse panel
	private String mouseMessage = "Interactive Mouse Panel";

	 
	// Constructor
  
	public GUI ()
	{
		super("Dictionary");
		// sets the screen layout
		setLayout(new BorderLayout());
		
	
		instruction = new JLabel("Enter a word to find the meaning.");
		search = new JButton("Search");
		textBox = new JTextField("  Enter any valid word  ");
		heading = new JLabel("Dictionary Search");
		help = new JButton("Help");
		mouse = new JLabel(mouseMessage);
		
		//create a section of screen that will hold some GUI components
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel mousePanel = new JPanel();
		
		//Setting background colour of the label to red
		 mousePanel.setBackground(Color.red);
		
		search.addActionListener(this);
		help.addActionListener(this);
		mousePanel.addMouseListener(this);
		
		//add the label/button we created to the panel
		mainPanel.add(instruction);
		mainPanel.add(textBox);
		mainPanel.add(search);
		northPanel.add(heading);
		mainPanel.add(help);
		mousePanel.add(mouse);
		
		
		//add the panel to the screen
		add(mainPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(mousePanel, BorderLayout.SOUTH);
		
		//set the location of the screen
		setLocation(100,100);
		
		//Define the size of the frame
		setSize(400,250);
		
		//Make the screen appear
		setVisible(true);
		
	}
/**********************************************************
 Event Programming
**********************************************************/	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		String input;
		
		if(arg0.getSource() == search)
		{
			input = textBox.getText();
			JOptionPane.showMessageDialog(null, "You Entered:\n" +input);
		}
		else if(arg0.getSource() == help)
		{
			JOptionPane.showMessageDialog(null, "Type a valid word into the text box.\nClick search to display the meaning of the word.");
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		if(arg0.getButton() == MouseEvent.BUTTON1)
		{
			mouse.setText("You Left Clicked");
		}
		if(arg0.getButton() == MouseEvent.BUTTON3)
		{
			mouse.setText("You Right Clicked");
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		mouse.setText("You Entered The Panel");
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		mouse.setText("You Left The Panel");
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
