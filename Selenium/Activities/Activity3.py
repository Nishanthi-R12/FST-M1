# Repeat the Activity1 & Activity2 but strictly use xpaths in your locators.

#import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Start the driver
with webdriver.Firefox() as driver:
    #Navigate to the url
    driver.get("https://training-support.net/webelements/login-form")
    #Print the title of the page
    print("Page title: ", driver.title)

    #Find the username field
    username = driver.find_element(By.XPATH, "//input[@id='username']")
    #Find the password field
    password = driver.find_element(By.XPATH, "//input[@id='password']")
    
    #Enter the username and password
    username.send_keys("admin")
    password.send_keys("password")

    #FInd the login button
    login = driver.find_element(By.XPATH, "//button[text()='Submit']")
    login.click()

    #Print the login message
    message = driver.find_element(By.XPATH, "//h1[contains(@class, text-center)]")
    print("Login message: ", message.text)


    