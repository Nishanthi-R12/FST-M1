"""Open a new browser to https://training-support.net/webelements/mouse-events
Get the title of the page and print it to the console.
On the page, perform:
Left click on the Cargo.lock button, move the cursor to the Cargo.toml button and then click it. Print the confirmation text at the end of the sequence.
Double click on the src button. Then right click on the target button and select open. Print the confirmation text at the end of the sequence.
Close the browser."""

#Import webdriver
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

#Start the driver
with webdriver.Firefox() as driver:
    #Open the web page
    driver.get("https://training-support.net/webelements/mouse-events")
    #Declare the actions variable
    actions = ActionChains(driver)
    #Print the title of the page
    print("Title of the page: ", driver.title)

    #Find the elements that can be clicked
    cargoLock = driver.find_element(By.XPATH, "//h1[text()='Cargo.lock']")
    cargoToml = driver.find_element(By.XPATH, "//h1[text() = 'Cargo.toml']")
    srcButtton = driver.find_element(By.XPATH, "//h1[text() = 'src']")
    targetButton = driver.find_element(By.XPATH, "//h1[text() = 'target']")

    #Perform left click on Cargo.lock and then on Cargo.toml
    actions.click(cargoLock).pause(1).move_to_element(cargoToml).pause(5).click(cargoToml).perform()
    
    #Print the front side text
    actionMessage = driver.find_element(By.ID, "result").text
    print(actionMessage)

    #Perform double click on src then right click on target
    actions.double_click(srcButtton).pause(3).pause(5).context_click(targetButton).pause(3).perform()
    #and then open it
    actions.click(driver.find_element(By.XPATH, ("//div[@id = 'menu']/div/ul/li[1]"))).pause(5).perform()
    #Print the front side text
    actionMessage = driver.find_element(By.ID, "result").text
    print(actionMessage)

