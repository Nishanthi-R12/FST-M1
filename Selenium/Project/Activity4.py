"""Logging into the site 
Goal: Open the site and login with the credentials provided 
a. Open the browser  
b. Navigate to ‘https://alchemy.hguy.co/crm’. 
c. Find and select the username and password fields 
d. Enter login credentials into the respective fields 
e. Click login
f. Verify that the homepage has opened
g. Close the browser """

from selenium import webdriver
from selenium.webdriver.common.by import By

#Initialize the firefox driver
with webdriver.Firefox() as driver:
    #Open the browser
    driver.get("https://alchemy.hguy.co/crm")

    #Find and select the username and password fields
    username = driver.find_element(By.NAME, "user_name")
    password = driver.find_element(By.NAME, "username_password")
    
    #Enter login credentials and click login
    username.send_keys("admin")
    password.send_keys("pa$$w0rd")
    driver.find_element(By.NAME, "Login").click()
    
    #Verify if home page is displayed
    """homepage = driver.title
    print("New home page title is: ", homepage)
    if(homepage == "Home >> SuiteCRM"):
        print("Home page is displayed after login")
    else:
        print("Home page is not available")"""
        
    homePage = driver.find_element(By.XPATH, "//a[contains(@id, 'grouptab_0')]").text
    print("Name of the first menu in home page is ", homePage)
    if(homePage == "SALES"):
        print("Home page is displayed after login")
    else:
        print("Home page is not available")
     