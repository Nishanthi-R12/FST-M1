"""Using pandas,
Print the number of rows and columns
Print the data in the emails column only
Sort the data based on FirstName in ascending order and print the data
"""

import pandas
dataframe = pandas.read_excel('sample.xlsx')
print(dataframe)
print("Number of rows and columns: ", dataframe.shape)

print("Emails")
print(dataframe['Email'])

#Sort the data based on Firstname in ascending order and print the data 
print("Sorted data based on firstname: ")
print(dataframe.sort_values('FirstName'))
