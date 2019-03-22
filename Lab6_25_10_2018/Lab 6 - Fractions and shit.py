# Function: Using Tuples to represent fractions
# Author: Scott Donnelly
# Date: 25/10/18

# Compiler used: PyCharm

# Functions
def gcd(a, b):  # Function to find the greatest common divisor of two variables
    if b > a:
        if b % a == 0:
            return a
        else:
            return gcd(b % a, a)
    else:
        if a % b == 0:
            return b
        else:
            return gcd(b, a % b)


def lcm(x, y):  # Function to find the lowest common multiple of two variables
    if x > y:
        greater = x
    else:
        greater = y

    while True:
        if greater % x == 0 and greater % y == 0:
            lcm = greater
            break
        greater += 1

    return lcm

# def addFrac(frac1, frac2):


# def subFrac(frac1, frac2):


# Main function

frac1 = (1, 4)
frac2 = (1, 3)
