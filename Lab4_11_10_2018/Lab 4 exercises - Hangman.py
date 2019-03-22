# Create a program to simulate the game of hangman

# Hint: We haven't looked at any data structures like lists yet, so we'll try to implement it using strings only.
# For example, let's say our secret word is "secret". We need to keep track of the guessed word so far.
# Initially we may represent it as ******
# If the user guesses a letter, lets say "e" the guessed word would be *e**e

import random

hangman = (

"""
   _________
    |/        
    |              
    |                
    |                 
    |               
    |                   
    |___                 
    """,

"""
   _________
    |/   |      
    |              
    |                
    |                 
    |               
    |                   
    |___                 
    H""",

"""
   _________       
    |/   |              
    |   (_)
    |                         
    |                       
    |                         
    |                          
    |___                       
    HA""",

"""
   ________               
    |/   |                   
    |   (_)                  
    |    |                     
    |    |                    
    |                           
    |                            
    |___                    
    HAN""",


"""
   _________             
    |/   |               
    |   (_)                   
    |   /|                     
    |    |                    
    |                        
    |                          
    |___                          
    HANG""",


"""
   _________              
    |/   |                     
    |   (_)                     
    |   /|\                    
    |    |                       
    |                             
    |                            
    |___                          
    HANGM""",



"""
   ________                   
    |/   |                         
    |   (_)                      
    |   /|\                             
    |    |                          
    |   /                            
    |                                  
    |___                              
    HANGMA""",


"""
   ________
    |/   |     
    |   (_)    
    |   /|\           
    |    |        
    |   / \        
    |               
    |___           
    HANGMAN""")

# Declaring global variables
history = []
wrong = 0
loop = 0

words = open("word.txt", "r").read().split()

words = str(random.choice(words).upper())  # You access the words from a text file.

# User prompt and game explanation
print("Welcome to Hangman! In this game you have to find out the secret word.\n")
print("Every time you make an incorrect guess, the hangman will get closer to being hanged.\n")
print("Every time you make a correct guess, the correct letters will be revealed in the secret word.\n")

max_wrong = len(hangman) - 1

so_far = "*" * len(words)
print("You need to guess", len(words), "letters word")
while loop == 0:

    print(chr(27) + "[2J")  # clear screen

    while wrong < max_wrong and so_far != words:

        print(hangman[wrong])

        print("\nYou've used the following letters:\n", history)
        print("\nSo far, the word is:\n", so_far)

        inp = input("Enter a letter guess: ").upper()

        if inp.isdigit() is True:
            print("Invalid Input")
            continue

        if len(inp) > 1:
            print("Invalid Input")
            continue
        while inp in history:
            print("You've already guessed the letter:", inp)
            inp = input("Pick a letter----->").upper()


            if inp.isalpha() is False:
                print("Invalid Input")
                continue

            if len(inp) > 1:
                print("Invalid Input")
                continue

        history.append(inp)

        if inp in words:
            print("Yes,", inp, "is in the word!")
            new = ""
            for i in range(len(words)):
                if inp == words[i]:
                    new += inp
                else:
                    new += so_far[i]
            so_far = new

        else:
            print("Sorry,", inp, "isn't in the word.")
            wrong += 1

    if wrong == max_wrong:
        print(hangman[wrong])
        print("\nYou've been hanged!")
    else:
        print("\nYou guessed it!")

    print("\nThe word was", words)
    loop = 1
