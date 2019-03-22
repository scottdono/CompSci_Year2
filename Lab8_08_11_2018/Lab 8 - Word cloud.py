# Function: To find the frequency of words used in a text file using dictionaries
# and representing their frequency in HTML
# Author: Scott Donnelly
# Date: 08/11/18

# Compiler used: PyCharm

import string

# Functions
def remove_punc(text):
    output = ""

    for i in text:
        if i not in string.punctuation:
            output += i
    return output

# Main function
HTML = open("output.html", "w")
HTML.write('<!DOCTYPE html>\
    <html>\
    <head lang="en">\
    <meta charset="UTF-8">\
    <title>Tag Cloud Generator</title>\
    </head>\
    <body>\
    <div style="text-align: center; vertical-align: middle; font-family: arial; color: white; background-color:black; border:1px solid black">')

file = open("gettysburg.txt", "r")
speech = file.readlines()  # Convert the file into a string variable
speech = remove_punc(speech)  # Call the function twice because the string is initially in brackets
speech = remove_punc(speech)  # so its needs to run through the string twice.
speech = speech.lower()  # Convert the string to lowercase letters
speech = speech.split()

dict = {}

for word in speech:  # Place the words from the string into a dictionary
    if word in dict:
        dict[word] += 1
    else:
        dict[word] = 1

for key, value in dict.items():  # Write to the HTML file for every word occurrence in the string
    HTML.write('<span style="font-size: {}px"> {} </span>'.format(value * 10, key))

HTML.write('</div>\
    </body>\
    </html>')



