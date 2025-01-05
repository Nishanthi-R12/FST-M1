import pandas
dataframe = pandas.read_excel("./employees.xlsx", sheet_name = "Sheet1")
print(dataframe)
print("Second element of 'Name' column is: ", dataframe["Name"][2])


