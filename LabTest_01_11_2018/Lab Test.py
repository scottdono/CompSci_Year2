# Function: Write a Python program that will prompt the user for a number, and print all the Kaprekar numbers
# from 10 to that number.
# Use functions where appropriate to structure your code.

# Author: Scott Donnelly
# Date: 01/11/18

# Compiler used: PyCharm

# Functions

def Kaprekar_range():
    user_input = input("Enter a top limit (Inclusive):\n")
    user_input = int(user_input)  # making the variable an int
    print("The list of all Kaprikar numbers from ", 10, "to", user_input, "is: \n")

    for i in range(10, user_input + 1):
        # Get the digits from the square in a list:
        sqr = i ** 2
        digits = str(sqr)

        # Now loop from 1 to length of the number - 1, sum both sides and check
        length = len(digits)
        for x in range(1, length):
            left = int("".join(digits[:x]))
            right = int("".join(digits[x:]))
            if (left + right) == i:
                print(" " + str(i))

def Kaprekar_check():
    num_check = input("Enter the number that you would like to check:\n")
    num_check = int(num_check)

    for i in range(num_check, num_check + 1):
        # Get the digits from the square in a list:
        sqr = i ** 2
        digits = str(sqr)

        # Now loop from 1 to length of the number - 1, sum both sides and check
        length = len(digits)
        for x in range(1, length):
            left = int("".join(digits[:x]))
            right = int("".join(digits[x:]))
            if (left + right) == num_check:
                print(num_check, "is a Kaprekar number because when you square it you get", sqr)
                print("This can be split into", left, "and", right, "which then adds up to", num_check)
            elif (left + right) != num_check:
                print(num_check, "is not a Kaprekar number")
                break  # leave the loop

# Main function

# Menu to choice which function you want
print("1. Check if a number is a Kaprekar number\n")
print("2. See the list of Kaprekar numbers within a specified range\n")
choice = input("Please enter the number that corresponds to what option you want:\n")
choice = int(choice)  # making the variable an int

if choice == 1:
    # Call function
    Kaprekar_range()

elif choice == 2:
    Kaprekar_check()

else:
    print("Invalid input\n")
