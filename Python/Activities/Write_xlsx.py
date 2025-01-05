import pandas
from pandas import ExcelFile
from pandas import ExcelWriter

#Data dictionary
data = {
    "Vehicle Type": ["Car", "Bike", "Cycle"],
    "Manufacturer": ["Maruti", "Royal Enfield", "Hercules"],
    "Model": ["800", "ThunderBird", "Gear cycle"]
}

#Creating dataframe
dataframe = pandas.DataFrame(data)
#Creating ExcelWriter object
writer = ExcelWriter("vehicles.xlsx")
#Write the DataFrame to the Excel file
dataframe.to_excel(writer, "Sheet1", index=False)
#Closing the file
writer.close()