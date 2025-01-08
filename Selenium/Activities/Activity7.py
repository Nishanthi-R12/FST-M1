"""Open a new browser to https://training-support.net/webelements/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the text field.
Check if the text field is enabled and print it.
Click the "Enable Input" button to enable the input field.
Check if the text field is enabled again and print it.
Close the browser."""

#import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Initialize the browser
with webdriver.Firefox() as driver:
    #Open the browser
    driver.get("https://training-support.net/webelements/dynamic-controls")

    #Print the title
    print("Title of the page: ", driver.title)

    #Find the text field
    textField = driver.find_element(By.ID, "textInput")
    #Check if the textbox is enabled
    print("Text box is enabled: ", textField.is_enabled())
    #Find the enable input button
    enableInput = driver.find_element(By.ID, "textInputButton")
    #Enable the button
    enableInput.click()
    #Check if the textbox is enabled again
    print("Text box is enabled - ", textField.is_enabled())
    