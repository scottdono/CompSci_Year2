Search Engine Java Assignment.

DT211C Year 2
Scott Donnelly
C17325426

Github link: https://github.com/scottdono/CompSci_Year2/tree/master/Java%20Programming/Java%20Assignment
Youtube Link: https://youtu.be/0Wowb-SKB4g

Code Explanation.

Control Class - This just acts as a main() method and is used to instantiate the GUI class.

GUI Class - The bulk of the code is within this class. There are many items and things for the user to interact 
with in the front end but the back end is mainly in the fileIO class.
The gui has a few complex elements such as the menubar, being able to open your browser from within the program, 
being able to choose files on your system, etc. There is also error checking for some common errors that I thought 
may occur. For instance, you can only choose .txt files, you can't search for an empty string, etc.

FileIO Class - This is just a simple searching algoritm that scans the specified files and counts how many lines the 
search string is found on. Its got a big O of N so the search time all depends on how many files there are.