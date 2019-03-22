# Function:

# "Question 1: Write Python classes to represent a BankAccount, CurrentAccount and SavingsAccount.
# Both CurrentAccount and SavingsAccount a a kind of BankAccount but have slightly different behaviour.
# Current accounts offer overdraft, savings accounts accumulate interest.
# You should be able to deposit and withdraw money.
# Model any other behaviour you think is appropriate."

# Author: Scott Donnelly
# Date: 29/11/2018

# Compiler used: PyCharm

# Functions & Classes
class BankAcc: #  Parent class

    def __init__(self, fname, lname, accnum, balance):  # Initialise the variables
        self.fname = fname
        self.lname = lname
        self.accnum = accnum
        self.balance = balance

    def withdraw(self, amount):
        self.balance -= amount
        return self.balance

    def deposit(self, amount):
        self.balance += amount
        return self.balance

    def __info__(self):  # Return the data to the main function
        return self.fname, self.lname, self.accnum, self.balance

class Current(BankAcc):
    def __init__(self, overdraft):
        BankAcc.__init__(self)
        self.overdraft = overdraft


class Savings(BankAcc):
    def __init__(self, interest, minimum_balance):
        BankAcc.__init__(self)
        self.interest = interest
        self.minimum_balance = minimum_balance


    def withdraw(self, amount):
        if self.balance - amount < self.minimum_balance:
            print("Sorry, minimum balance must be maintained.")
        else:
            BankAcc.withdraw(self, amount)


# Main function

def main():
    # Menu to choice which function you want
    print("1. ")
    print("2. ")

    while 1:
        choice = input("\nPlease enter the number that corresponds to what option you want:\n")
        choice = int(choice)  # making the variable an int
