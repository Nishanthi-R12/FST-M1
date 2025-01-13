"""Getting colors 
Goal: Get the color of the navigation menu 
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials 
provided. 
c. Get the color of the navigation menu and print it to the console. 
d. Close the browser. """

#Import web driver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Initialise the firefox driver
with webdriver.Firefox() as driver:
    #Get the browser
    driver.get("http://alchemy.hguy.co/crm")
    #Find the username & password and login using the credentials
    username = driver.find_element(By.NAME, "user_name")
    password = driver.find_element(By.NAME, "username_password")
    username.send_keys("admin")
    password.send_keys("pa$$w0rd")
    driver.find_element(By.NAME, "Login").click()
    navigationColor = driver.find_element(By.ID, "toolbar").value_of_css_property("color")
    print(f"Color of navigation menu is: {navigationColor}")
    