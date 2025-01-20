"""Open a new browser to https://training-support.net/webelements/tabs
Get the title of the page and print it to the console.
Find the button to open a new tab and click it.
Wait for the new tab to open. Once it opens, print all the handles.
Switch to the newly opened tab, print the new tab's title and message.
Repeat the steps by clicking the button in the new tab page.
Close the browser."""

#Import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Start the driver
with webdriver.Firefox() as driver:
    #Declare the wait variable
    wait = WebDriverWait(driver,timeout=10)

    #Navigate to the URL and print the title of the web page
    driver.get("https://training-support.net/webelements/tabs")
    print("Title of the web page: ", driver.title)

    # Print the handle of the parent window
    print("Current tab: ", driver.current_window_handle)

    # Find button to open new tab
    wait.until(EC.element_to_be_clickable((By.XPATH, "//button[text()='Open A New Tab']"))).click()
    # Wait for the second tab to open
    wait.until(EC.number_of_windows_to_be(2))
    # Print all window handles
    print("Currently open windows: ", driver.window_handles)
    driver.switch_to.window(driver.window_handles[1])

    # Wait for the new page to load
    wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(text(), 'Another One')]")))
    # Print the handle of the current tab
    print("Current tab: ", driver.current_window_handle)
    # Print the title and heading of the new page
    print("New Page title: ", driver.title)
    print("New Page message: ", driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text)
    # Find and click the button on page to open another tab
    driver.find_element(By.XPATH, "//button[contains(text(), 'Another One')]").click()

    # Wait for new tab to open
    wait.until(EC.number_of_windows_to_be(3))
    # Switch focus
    for handle in driver.window_handles:
        driver.switch_to.window(driver.window_handles[2])