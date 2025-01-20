"""Open a new browser to https://training-support.net/webelements/alerts
Get the title of the page and print it to the console.
Find the button to open a PROMPT alert and click it.
Switch the focus from the main window to the Alert box and get the text in it and print it.
Type "Awesome!" into the prompt.
Close the alert by clicking Ok.
Close the browser."""

#Import the web driver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Initialize the firefox driver
with webdriver.Firefox() as driver:
    
    #Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

    #Open the web page and print the title of the pae
    driver.get("https://training-support.net/webelements/alerts")
    print("Title of the web page: ", driver.title)

    #Find the prompt alert and click it
    driver.find_element(By.ID, "prompt").click()

    #Switch focus to alert
    promptAlert = wait.until(EC.alert_is_present())

    #Print the text in the prompt alert box
    print("Text in the prompt alert text box: ", promptAlert.text)

    #Enter Awesome! in the prompt alert box
    promptAlert.send_keys("Awesome!")

    #Close the alert by clicking ok
    promptAlert.accept()

    #Print the message
    print(driver.find_element(By.ID, "result").text)

