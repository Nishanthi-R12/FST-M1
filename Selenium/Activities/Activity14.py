"""Open a new browser to https://training-support.net/webelements/tables
Get the title of the page and print it to the console.
Using xpaths on the table:
Find the number of rows and columns in the table and print them.
Find and print the Book Name in the 5th row.
Click the header of the Price column to sort it in ascending order.
Find and print the Book Name in the 5th row again.
Close the browser."""

#Import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Initialise the webdriver
with webdriver.Firefox() as driver:
    #Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

    #Open the web page and print the title of the page
    driver.get("https://training-support.net/webelements/tables")
    print("Title of the web page: ", driver.title)

    #Find the no. of rows and columns in the table and print them
    rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr")
    print("No. of rows: ", len(rows))
    cols = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/thead/tr/th")
    print("No. of columns: ", len(cols))

    #Print the book name in the fifth row
    cellValue = driver.find_element(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]")
    print("Book name before sorting: ", cellValue.text)

    #Sort the table
    driver.find_element(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]")
    print("Book name after sorting: ", cellValue.text)

