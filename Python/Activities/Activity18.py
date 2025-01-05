"""Using Pandas, Read the CSV made in the previous program:

Print the values only in the Usernames column
Print the username and password of the second row
Sort the Usernames column data in ascending order and print data
Sort the Passwords column in descending order and print data"""

import pandas

#Read the csv file and store it into a DataFrame
dataframe = pandas.read_csv("sample.csv")
#Full data
print("Full data: ")
print(dataframe)
#Printing the values in the username column only
print("Usernames:")
print(dataframe["Usernames"])

#Print the username and password of the second row
print("Username: ", dataframe["Usernames"][1], " |", "Password: ", dataframe["Passwords"][1])

#Sort username column in ascending order
print("Data sorted in ascending order, Usernames: ")
print(dataframe.sort_values('Usernames'))

#Sort the password column in descending order
print("Data sorted in descending order, Passwords: ")
print(dataframe.sort_values('Passwords', ascending = False))
