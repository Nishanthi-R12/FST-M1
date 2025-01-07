"""Open a new browser to https://training-support.net/webelements/target-practice
Get the title of the page and print it to the console.
Using xpath:
Find the 3rd header on the page and print it's text to the console.
Find the 5th header on the page and print it's color.
Using any other locator:
Find the purple button and print all it's classes.
Find the slate button and print it's text.
Close the browser."""
"""
#import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color

#Start the driver
with webdriver.Firefox() as driver:
    #Navigating to url
    driver.get("https://training-support.net/webelements/target-practice")
    #Printing the title 
    print("Page title: ", driver.title)

    #Find the 3rd header element on the page using xpath
    thirdHeading = driver.find_element(By.XPATH, "//h3[contains(text(), '#3')]")
    print("Third header element is ", thirdHeading)

    #Find the 5th header element on the page using xpath
    fifthHeading = driver.find_element(By.XPATH, "//h5[contains(text(), '#5')]")
    print("Fifth header element is ", fifthHeading)
    fifthHeadingColor = driver.find_element(By.XPATH, "//h5[contains(text(), '#5')]").value_of_css_property("color")
    print("Fifth heading color as Hexcode: ", fifthHeadingColor.hex)
    print("Fifth heading color as RGB: ", fifthHeadingColor.rgb)

    #Find the purple button element on the page
    purpleButton = driver.find_element(By.XPATH, "//button[text()='Purple']")
    print("Purple buttton's classes are: ", purpleButton.get_attribute("class"))

    #Find the slate button element on the page
    slateButton = driver.find_element(By.XPATH, "//button[contains(@class, 'slate']")
    print("Text in slate button is ", slateButton.text)
    """
# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/target-practice")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the 3rd header element on the page using XPath
    third_heading = driver.find_element(By.XPATH, "//h3[contains(text(), '#3')]")
    print("Third heading text is: ", third_heading.text)

    # Find the 5th header element on the page using XPath
    fifth_heading_color = Color.from_string(driver.find_element(By.XPATH, "//h5[contains(text(), '#5')]").value_of_css_property("color"))
    print("Fifth heading colour as Hexcode: ", fifth_heading_color.hex)
    print("Fifth heading colour as RGB: ", fifth_heading_color.rgb)

    # Find the Purple button element on the page
    purple_button = driver.find_element(By.XPATH, "//button[text()='Purple']")
    print("Purple button's classes are: ", purple_button.get_attribute("class"))

    # Find the Slate button element on the page
    slate_button = driver.find_element(By.XPATH, "//button[contains(@class, 'slate')]")
    print("Text in slate button is: ", slate_button.text)    
                                       
