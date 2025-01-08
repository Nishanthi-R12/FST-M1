"""Open a new browser to https://training-support.net/webelements/dynamic-attributes
Get the title of the page and print it to the console.
Find the input fields and type in the required data in the fields.
Wait for success message to appear and print it to the console.
Close the browser."""

#import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Initialise the driver
with webdriver.Firefox() as driver:
    #Open the web page
    driver.get("https://training-support.net/webelements/dynamic-attributes")
    #Print the title of the page
    print("Title of the page: ", driver.title)
    
    #Find the input fields
    fullname = driver.find_element(By.XPATH, "//input[starts-with(@id, 'full-name')]")
    email = driver.find_element(By.XPATH, "//input[contains(@id, '-email')]")
    eventDate = driver.find_element(By.XPATH, "//input[contains(@name, '-event-date-')]")
    additionalDetails = driver.find_element(By.XPATH, "//textarea[contains(@id, '-additional-details-')]")

    #Enter the details
    fullname.send_keys("Nishanthi")
    email.send_keys("nishanthi.fstcheck@gmail.com")
    eventDate.send_keys("2025-01-08")
    additionalDetails.send_keys("Testing")

    #Find the submit button and click it
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    #Wait for success message and print it
    message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation"))).text
    print("Success message: ", message)
