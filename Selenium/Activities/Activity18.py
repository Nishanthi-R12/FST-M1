"""Open a new browser to https://training-support.net/webelements/alerts
Get the title of the page and print it to the console.
Find the button to open a SIMPLE alert and click it.
Switch the focus from the main window to the Alert box and get the text in it and print it.
Close the alert once with OK.
Close the browser."""

#Import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

#initialize the firefox driver
with webdriver.Firefox() as driver:
    #Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    #Open the browser and print the title of the webpage
    driver.get("https://training-support.net/webelements/alerts")
    print("Title of the web page: ", driver.title)

    #Find the button to open a SIMPLE alert and click it
    driver.find_element(By.ID, "simple").click()

    #Switch focus to the alert
    simpleAlert = wait.until(EC.alert_is_present())

    #Print the text in the alert
    print("Text in the simple alert box is: ", simpleAlert.text)

    #Close the alert by clicking ok
    simpleAlert.accept()

    #Print the message
    print(driver.find_element(By.ID, "result").text)
