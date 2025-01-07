"""Open a new browser to https://training-support.net/webelements/login-form/
Get the title of the page and print it to the console.
Find the username field using any locator and enter "admin" into it.
Find the password field using any locator and enter "password" into it.
Find the "Log in" button using any locator and click it.
Close the browser."""

#Import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Start the driver
with webdriver.Firefox() as driver:
    #Navigate to the url
    driver.get("https://training-support.net/webelements/login-form")
    #Print the title of the page
    print("Page title is: ", driver.title)

    #Find the username field
    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")

    #Enter username
    username.send_keys("admin")
    #Enter password
    password.send_keys("password")
    #Find the login button
    login = driver.find_element(By.XPATH, "//button[text() = 'Submit']")
    login.click()
    #Print the login message
    message = driver.find_element(By.CSS_SELECTOR, "h1.text-center")
    print("Login message: ", message.text)
    