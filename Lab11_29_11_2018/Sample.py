from random import randint
import time

class BankAccount(object):
    def __init__(self, initial_balance=0):
        self.balance = initial_balance
    def deposit(self, amount):
        self.balance += amount
    def withdraw(self, amount):
        self.balance -= amount
    def overdrawn(self):
        return self.balance < 0

balance = (randint(100, 500))
my_account = BankAccount(balance)
my_account.balance

variable = 0
print("Welcome to Your Bank Account")
time.sleep(1)

def main():
    while variable == 0:
        time.sleep(2)
        print("Your current Balance is", my_account.balance , "pounds")
        time.sleep(0.5)
        print("Would you like to deposit or withdraw money")

    decision = input("write 'deposit' or 'withdraw', is case-sensitive: ")
    if decision == "deposit":
        depositAmmount = float(input("How much would you like to deposit: "))
        my_account.deposit(depositAmmount)
        print("Your new balance is" , round(my_account.balance, 2))
    elif decision == "withdraw":
        withdrawAmmount = float(input("How much would you like to withdraw: "))
        my_account.withdraw(withdrawAmmount)
        print("Your new balance is" , round(my_account.balance, 2))
        if my_account.balance < 0:
            time.sleep(1)
            print("Your in an OVERDRAFT of a maximum 500 pounds")
            time.sleep(0.5)
        else:
            print("Your new balance is" , round(my_account.balance, 2))
    if int(my_account.balance + 500) < 0:
            print("You are going over your OVERDRAFT, WITHDRAW DENIED")
            my_account.deposit(withdrawAmmount)
main()