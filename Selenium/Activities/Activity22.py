"""Open a new browser to https://training-support.net/webelements/popups
Print the title of the page.
Find the button on the page and click it to launch the popup.
Wait for the popup to appear and then enter the credentials:
username: admin
password: password
Click submit and print the message on the page after logging in.
Finally, close the browser."""

#Import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Declare the firefox driver
with webdriver.Firefox() as driver:

    #Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

    #Navigate to the url and print the title of the web page
    driver.get("https://training-support.net/webelements/popups")
    print("Title of the web page is: ", driver.title)

    # Find the launcher button and click it
    driver.find_element(By.ID, "launcher").click()

    # Wait for the modal to appear
    wait.until(EC.element_to_be_clickable((By.ID, "username")))

    # Find the input fields
    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")
    # Enter the credentials
    username.send_keys("admin")
    password.send_keys("password")
    # Click the submit button
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    # Print the success message
    message = driver.find_element(By.CSS_SELECTOR, "h2.text-center").text
    print("Login message: " + message)