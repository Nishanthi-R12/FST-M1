"""Writing below data into csv file
Username - Password
admin password
Charles Charl13
Deku AllMight"""

import pandas

#Creating dictionary
data = {
    "Usernames" : ["Admin", "Charles", "Deku"],
    "Passwords" : ["password", "Charl13", "AllMight"]
}
#Create dataframe using that data
dataframe = pandas.DataFrame(data)

#Print the dataframe
print(dataframe)

"""Write the dataframe into csv file. Index property is set to false to avoid writing the index number to the file"""

dataframe.to_csv("./sample.csv", index = False)



