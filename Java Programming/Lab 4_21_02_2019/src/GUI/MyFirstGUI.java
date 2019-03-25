/****************************************
* Program description: Demonstrating interfaces and using a GUI
* Author: Scott Donnelly
* Date: 21/02/2019
*****************************************/
package GUI;

import java.awt.BorderLayout;

public class MyFirstGUI extends JFrame 
{


		private JTex textBox1;
		private JButton button1;
		private Jlabel label1;
		
		  		  	 
		// Constructor
	  
		public MyFirstGUI ()
		{
			super("my first frame");
			button1 = new JButton("Search");
			label1 = new Jlabel("Enter text here");
			add(button1);
			add(label1);
			
			//Setting the size of the screen
			setSize(400,400);
			setVisable(true);
			   	   
		}

}