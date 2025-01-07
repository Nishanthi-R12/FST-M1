"""Open the training support site. (https://training-support.net)
Print the title of the page
Click the about us button
Print the title of the new page"""

#import web driver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

#start the driver
with webdriver.Firefox() as driver:
    #Navigate to the url
    driver.get("https://training-support.net")

    #Print the title of the page
    print("Page title is: ", driver.title)

    #Find the "About Us" button on the page using ID and click it
    driver.find_element(By.LINK_TEXT, "About Us").click()

    #Print the title of the new page
    print("Page title of the new page is: ", driver.title)