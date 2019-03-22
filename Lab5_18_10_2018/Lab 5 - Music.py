
# Function: Read a file with music metadata
# Author: Scott Donnelly
# Date: 18/10/18

# Compiler used: PyCharm




# Main function


file = open("hnr.abc")  # Open the file with the meta-data
lines = file.readlines()  # read the lines in the file
check = False  # A way to get the first title

for line in lines:

    if 'X:' in line:
        print("Index: ", line[2:])
        check = False
    if check == False:
        if 'T:' in line:
            print("Title: ", line[2:])
            check = True
    if 'M:' in line:
        print("Time Sig: ", line[2:3])
    if 'K:' in line:
        print("Key Sig: ", line[2:])




