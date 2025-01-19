""" Open a new browser to https://training-support.net/webelements/alerts
Get the title of the page and print it to the console.
Find the button to open a CONFIRM alert and click it.
Switch the focus from the main window to the Alert box and get the text in it and print it.
Close the alert once with Ok and again with Cancel.
Close the browser."""

#Import the web driver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Initialize the firefox driver
with webdriver.Firefox() as driver:
    #Initialize the wait variable
    wait = WebDriverWait(driver, timeout=10)

    #Open the browser and print the title of the page
    driver.get("https://training-support.net/webelements/alerts")
    print("Title of the web page: ", driver.title)

    #Find the alert confirmation and click it
    driver.find_element(By.ID, "confirmation").click()

    #Switch to the alert box
    confirmAlert = wait.until(EC.alert_is_present())

    #Print the text in the alert
    alertText = confirmAlert.text
    print("Text in the alert: " + alertText)

    #Close the alert by clicking ok
    confirmAlert.dismiss()

    #Print the message
    print(driver.find_element(By.ID, "result").text)