""" 1.Open the browser to the Alchemy site and login
 2. Navigate to sales -> leads page
 3. Find the table on the page and print the first 10 values in the name column and the user column of the table to the console
 4. Close the browser."""

#import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

#Initialise the firefox driver
with webdriver.Firefox() as driver:
    #Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    #Open the browser
    driver.get("http://alchemy.hguy.co/crm")
    #Find username and password elements. Pass the credential and click it
    username = driver.find_element(By.NAME, "user_name")
    password = driver.find_element(By.NAME, "username_password")
    username.send_keys("admin")
    password.send_keys("pa$$w0rd")
    driver.find_element(By.NAME, "Login").click()

    #Navigate to sales -> leads
    driver.find_element(By.XPATH, "//a[contains(@id, 'grouptab_0')]").click()
    driver.find_element(By.XPATH, "//a[contains(@id, 'moduleTab_9_Leads')]").click()
    
    #Find the table in the accounts web page and print the first 5 odd-numbered rows of the table
    table = wait.until(EC.visibility_of_element_located((By.XPATH, "/html/body/div[4]/div/div[3]/form[2]/div[3]/table")))
    rows = driver.find_elements(By.XPATH, "/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr")
    print("No. of rows: ", len(rows))
    count = 0
    i =0
    for r in rows:
        if(count<10):
            columns= r.find_elements(By.TAG_NAME,"td")
            print("Name: ", columns[2].text)
            print("User: ", columns[7].text)
            count+=1
        i+=1
    # cellValue = driver.find_element(By.XPATH, "//table[contains(@class, 'list view table-responsive')]/thead/tbody/tr[1]/td[2]")
    # print("First 5 odd-numbered rows of the table are: ", cellValue.text)
