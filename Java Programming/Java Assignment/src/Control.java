/*Function: 
* This tool will allow you to search for a term across a set of text sources � e.g. groups of text files.
* The user puts in a search term and the tool will check the contents of a set of text files and tell you
* which ones contain the search term. The files that have the �strongest match� against the search
* term should be returned at the top of the list.
* The user should be able to search on a single word. But to make the search better, you should be
* able to search on multiple words � e.g. �Christmas day�.. although what rules you apply as to
* whether these are assumed to be together or separate words is up to you; Maybe you can use �*�
* and logic (e.g. this word AND this word OR this word) to make the search smarter.
Author: Scott Donnelly
Date: 24/03/19

Compiler used: Eclipse

*/

import java.io.FileNotFoundException;

public class Control 
{

	public static void main(String[] args) throws FileNotFoundException
    {
		System.out.println("ADDING FILES TO THE LIST");
       // GUI test = new GUI();
		GUI test = new GUI();
        
    }

}
