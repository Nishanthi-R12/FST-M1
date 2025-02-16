"""Reading additional information 
Goal: Reading a popup that contains additional information about the account/lead. 
a. Open the browser to the Alchemy CRM site and login.
b. Navigate to Sales -> Leads
c. In the table, find the Additional information icon at the end of the row of the lead 
information. Click it. 
d. Read the popup and print the phone number displayed in it. 
e. Close the browser. """

#Import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
import time

#Initialize the firefox driver
with webdriver.Firefox() as driver:
    #Open the browser
    driver.get("http://alchemy.hguy.co/crm")

    #Find the username & password. Enter the credentials and click login
    username = driver.find_element(By.NAME, "user_name")
    password = driver.find_element(By.NAME, "username_password")
    username.send_keys("admin")
    password.send_keys("pa$$w0rd")
    driver.find_element(By.NAME, "Login").click()

    #Navigate to sales -> leads
    driver.find_element(By.XPATH, "//a[contains(@id, 'grouptab_0')]").click()
    driver.find_element(By.XPATH, "//a[contains(@id, 'moduleTab_9_Leads')]").click()
    
    #Set the implicit wait
    #driver.implicitly_wait(15)
    
    #Wait for the first element to be visible
    wait = WebDriverWait(driver, 10)

    first_element = wait.until(EC.visibility_of_element_located((By.XPATH, "//span[@class='suitepicon suitepicon-action-info']")))
    first_element.click()
    print("Additional details popped up")
    time.sleep(2)
    
    #Wait for the popup to be visible
    popup = wait.until(EC.visibility_of_element_located((By.XPATH, "/html/body/div[4]/div/div[7]/div[2]/h2")))

    #Find the phone number inside the popup and print it
    phoneNo = driver.find_element(By.XPATH, "//span[@class='phone']")
    print("Phone number is ", phoneNo.text)
    
    #Find the close button and click it to close the popup
    closePopUp = driver.find_element(By.XPATH, "(//span[contains(@class, 'ui-button-icon-primary ui-icon ui-icon-closethick')])[4]")
    closePopUp.click()

    time.sleep(2)
    driver.quit()

    
    
    