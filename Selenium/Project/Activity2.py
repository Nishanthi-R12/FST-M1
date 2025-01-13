"""Get the url of the header image 
Goal: Print the url of the header image to the console 
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’.  
c. Get the url of the header image. 
d. Print the url to the console. 
e. Close the browser."""

#Import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Initialise the driver
with webdriver.Firefox() as driver:
    #Open & navigate to crm browser
    driver.get("http:///alchemy.hguy.co/crm")

    #Find the URL of the header image
    #headerImageURL = driver.find_element(By.XPATH, "//img[contains(text(), 'company_logo')]")
    headerImageURL = driver.find_element(By.XPATH, "//img[contains(@src, 'company_logo')]")
    #Print the url of the header image
    print("URL of the header image: ", headerImageURL.get_attribute("src"))