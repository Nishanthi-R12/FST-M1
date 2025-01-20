"""Open a new browser to https://training-support.net/webelements/tables
Get the title of the page and print it to the console.
Using xpaths on the table:
Find the number of rows and columns in the table and print them.
Find and print all the cell values in the third row of the table.
Find and print the cell value at the second row second column.
Close the browser."""

#Import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By

#Initialize the firefox driver
with webdriver.Firefox() as driver:
    #Open the web page and print the title of the page
    driver.get("https://training-support.net/webelements/tables")
    print("Title of the web page: ", driver.title)

    #Find the no. of rows and columns in the table and print them
    rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr")
    cols = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/thead/tr/th")
    print("No. of rows: ", len(rows))
    print("No. of cols", len(cols))

    #Print the cell value of the third row
    thirdRow = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr[3]/td")
    print("Third row cell value is: ")
    for cell in thirdRow:
        print(cell.text)
    
    #Print the cell value of the second row and second column
    cellValue = driver.find_element(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]")
    print("Second row, Second cell value: ", cellValue.text)