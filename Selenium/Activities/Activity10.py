"""Open a new browser to https://training-support.net/webelements/drag-drop
Get the title of the page and print it to the console.
On the page, perform:
Find the ball and simulate a click and drag to move it into "Dropzone 1".
Verify that the ball has entered Dropzone 1.
Once verified, move the ball into "Dropzone 2".
Verify that the ball has entered Dropzone 2.
Close the browser."""

#import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains

#Initiate the web driver
with webdriver.Firefox() as driver:
    #Declare the action variable
    actions = ActionChains(driver)
    #Navigate to the url
    driver.get("https://training-support.net/webelements/drag-drop")
    #Print the title of the page
    print("Title of the page: ", driver.title)

    #FInd the football
    football = driver.find_element(By.ID, "ball")
    #Find the dropzone1
    dropzone1 = driver.find_element(By.ID, "dropzone1")
    #Find the dropzone2
    dropzone2 = driver.find_element(By.ID, "dropzone2")

    #Perform drag and drop to zone1
    actions.click_and_hold(football).move_to_element(dropzone1).pause(5).release().perform()
    if(dropzone1.find_element(By.CLASS_NAME, "dropzone-text").text == "Dropped!"):
        print("Ball was dropped in dropzone1")
    
    #Perform drag and drop to zone2
    actions.drag_and_drop(football, dropzone2).pause(5).perform()
    if(dropzone2.find_element(By.CLASS_NAME, "dropzone-text").text == "Dropped!"):
        print("Ball was dropped in dropzone2")
    
