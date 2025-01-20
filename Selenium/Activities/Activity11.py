"""Open a new browser to https://training-support.net/webelements/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox on the page.
Click the "Toggle Checkbox" button to remove the checkbox.
Wait for the checkbox to disappear.
Toggle the checkbox again.
Wait for it appear and then select it.
Close the browser."""

#Import driver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Start the driver
with webdriver.Firefox() as driver:
    #Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    #Navigate to the URL
    driver.get("https://training-support.net/webelements/dynamic-controls")
    #Print the title of the page
    print("Page title is ", driver.title)

    #Find the checkbox and make sure it is visible
    checkbox = driver.find_element(By.ID, "checkbox")
    print("Is checkbox visible? ", checkbox.is_displayed())

    #Find the button to toggle it and click it
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    #Wait for it to disappear
    wait.until(EC.invisibility_of_element(checkbox))
    #Check if it is visible
    print("Is checkbox visible? ", checkbox.is_displayed())

    #Toggle the checkbox and click it
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    wait.until(EC.element_to_be_clickable(checkbox)).click()
    #Check if it is selected
    print("Is checkbox selected? ", checkbox.is_selected())


