"""Open a new browser to https://training-support.net/webelements/dynamic-content
Get the title of the page and print it to the console.
On the page, perform:
Find and click the "Click me!" button.
Wait till the word "release" appears.
Get the text and print it to console.
Close the browser."""

#Import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Initialize the firefox driver
with webdriver.Firefox() as driver:
    #Initialize the wait variable
    wait = WebDriverWait(driver, timeout=10)

    #Open the web page and print the title of the page
    driver.get("https://training-support.net/webelements/dynamic-content")
    print("Title of the web page is ", driver.title)

    #Find and click the 'ClickMe!' button
    driver.find_element(By.ID, "genButton").click()

    #Wait for the word 'release' to appear
    if wait.until(EC.text_to_be_present_in_element((By.ID, "word"), "release")):
        #Print the word to the console
        print("Word found and that word is: ", driver.find_element(By.ID, "word").text)
