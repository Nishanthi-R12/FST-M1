"""Open a new browser to https://training-support.net/webelements/keyboard-events
Get the title of the page and print it to the console.
On the page, type out a string from the Selenium script to show on the page
Print the message to the console.
Close the browser."""

#import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import Keys, ActionChains

#Start the driver
with webdriver.Firefox() as driver:
    #Declare the action variable
    actions = ActionChains(driver)
    #Navigate to the url
    driver.get("https://training-support.net/webelements/keyboard-events")

    #Print the title of the page
    print("Title of the page: ", driver.title)

    #Press the key
    actions.send_keys("Selenium - Full Stack Testing").send_keys(Keys.RETURN).perform()

    #Print the message from the page
    pageText = driver.find_element(By.CSS_SELECTOR, "h1.mt-3").text
    print(pageText)