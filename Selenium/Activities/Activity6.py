"""Open a new browser to https://training-support.net/webelements/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox input element.
Check if the checkbox is selected and print the result.
Click the checkbox to select it.
Check if the checkbox is selected again and print the result.
Close the browser."""

#import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#initialize the driver
with webdriver.Firefox() as driver:
    #Open the browser
    driver.get("https://training-support.net/webelements/dynamic-controls")
    #Print the title of the page
    print("Title of the page - ", driver.title)

    #Find the checkbox
    checkbox = driver.find_element(By.ID, "checkbox")
    #Click the checkbox
    checkbox.click()
    #Verify if the checkbox is selected or not
    print("Checkbox is selected - ", checkbox.is_selected())
    #Click the checkbox again
    checkbox.click()
    #Verify if the checkbox is selected or not
    print("Checkbox is selected - ", checkbox.is_selected())
    