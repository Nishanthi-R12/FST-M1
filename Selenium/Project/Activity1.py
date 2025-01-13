"""Verify the website title 
Goal: Read the title of the website and verify the text 
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’.  
c. Get the title of the website. 
d. Make sure it matches “SuiteCRM” exactly. 
e. If it matches, close the browser. """

#Import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Initiate the driver
with webdriver.Firefox() as driver:
    #Open a browser
    driver.get("http://alchemy.hguy.co/crm")

    #Print the title of the website
    print("Title of the website: ", driver.title)

    #Check title matches "SuiteCRM"
    if(driver.title == "SuiteCRM"):
        print("Title matches with SuiteCRM")
    else:
        print("Verify the title of the website again")