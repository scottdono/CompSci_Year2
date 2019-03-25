
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Random;


@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener, FocusListener
{
	private JButton search;
	private JButton generate;
	private JLabel instruction;
	private JTextField textBox;
	private Random Rand;
	private int randNum;
	private int guesses=0;

	 
	// Constructor
  
	public GUI ()
	{
		super("My GUI");
		// sets the screen layout
		setLayout(new BorderLayout());
		
	
		instruction = new JLabel("Then make a guess..");
		generate = new JButton("Generate the random number");
		textBox = new JTextField("  Enter your guess ");
		search = new JButton("Check your guess");

		
		//create a section of screen that will hold some GUI components
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();	
		
		search.addActionListener(this);
		generate.addActionListener(this);

		
		//add the label/button we created to the panel
		northPanel.add(generate);
		mainPanel.add(instruction);
		mainPanel.add(textBox);
		mainPanel.add(search);
		
		
		//add the panel to the screen
		add(mainPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		//set the location of the screen
		setLocation(200,200);
		
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
		int input;
		
		if(arg0.getSource() == search)
		{
			
			guesses++;
			input = Integer.parseInt(textBox.getText());
			if(input<randNum)
			{
				JOptionPane.showMessageDialog(null, "You're guess of "+input+" is too low. Guess again.");
			}
			if(input>randNum)
			{
				JOptionPane.showMessageDialog(null, "You're guess of "+input+" is too high. Guess again.");
			}
			if(input==randNum)
			{
				JOptionPane.showMessageDialog(null, "Correct! It took you " +guesses+ " guesses.");
			}
			
		}
		else if(arg0.getSource() == generate)
		{
			Rand = new Random();
			randNum = Rand.nextInt(100);
			randNum += 1;
			System.out.println(randNum);
		}
		
	}
@Override
public void focusGained(FocusEvent arg0) 
{
	if(arg0.getSource() == textBox)
	{
		     textBox.setText("");
	}

	
}
@Override
public void focusLost(FocusEvent arg0) 
{
	// TODO Auto-generated method stub
	
}

}