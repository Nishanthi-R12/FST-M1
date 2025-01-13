"""Get the copyright text 
Goal: Print the first copyright text in the footer to the console 
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’. 
c. Get the first copyright text in the footer. 
d. Print the text to the console. 
e. Close the browser. """

#import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Initialize the webdriver
with webdriver.Firefox() as driver:

   #Open the browser
   driver.get("http://alchemy.hguy.co/crm")

   #Get the first copyright text in the footer
   copyrightText = driver.find_element(By.ID, "admin_options").text
   #Print the first copyright
   print("First copyright of the footer is ", copyrightText)
   