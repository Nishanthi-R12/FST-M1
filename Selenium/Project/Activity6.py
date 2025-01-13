"""Menu checking 
Goal: Make sure that the “Activities” menu item exists and is clickable 
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials 
provided. 
c. Locate the navigation menu. 
d. Ensure that the “Activities” menu item exists. 
e. Close the browser """

#Import the driver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Initialize the firefox driver
with webdriver.Firefox() as driver:
    #Open the browser
    driver.get("http://alchemy.hguy.co/crm")
    #Find the username & password and login using the credentials
    username = driver.find_element(By.NAME, "user_name")
    password = driver.find_element(By.NAME, "username_password")
    username.send_keys("admin")
    password.send_keys("pa$$w0rd")
    driver.find_element(By.NAME, "Login").click()
    navigationMenu = driver.find_element(By.ID, "toolbar")
    print("Verify if navigation menu is visible: ", navigationMenu.is_displayed())
    Activities = driver.find_element(By.XPATH, "//a[contains(@id, 'grouptab_3')]")
    print("Verify if activities menu is displayed: ", Activities.is_displayed())
    Activities.click()
    print("Activity menu is clickable & drop down values are displayed in UI screen")