import pandas
from pandas import ExcelWriter

#Data dictionary
data = {
    'FirstName': ["Abinaya", "Bala", "Charles"],
    'LastName' : ["Durai", "Mukund", "David"],
    'Email' : ["abidurai@example.com", "balamukund1@example.com", "CharlesD@example.com"],
    'PhoneNumber' : ["1234567890", "2311231231", "4512311231"]
}
#Creating dataframe that will be written to excel file
dataframe = pandas.DataFrame(data)

print(dataframe)
#Writing the dataframe to excel file
writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

writer.close()
