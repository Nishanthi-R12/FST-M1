"""Open a new browser to https://training-support.net/webelements/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox input element.
Check if it is visible on the page.
Click the "Remove Checkbox" button.
Check if it is visible again and print the result.
Close the browser."""

#import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Start the driver
with webdriver.Firefox() as driver:
    #Navigate to url
    driver.get("https://training-support.net/webelements/dynamic-controls")

    #print the title of the page
    print("Title of the page: ", driver.title)

    #Find the checkbox
    checkbox = driver.find_element(By.ID, "checkbox")
    
    #Find the checkbox toggle button
    checkboxToggle = driver.find_element(By.XPATH, "//button[text() = 'Toggle Checkbox']")
    #Verify if the checkbox is visible or not
    print("Checkbox is displayed ", checkbox.is_displayed())
    
    #Click the checkbox toggle button to hide the checkbox
    checkboxToggle.click()
    #Verify if the checkbox is displayed again or not
    print("Checkbox is displayed ", checkbox.is_displayed())


