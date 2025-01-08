"""Open a new browser to https://training-support.net/webelements/selects
Get the title of the page and print it to the console.
On the Single Select:
Select the second option using the visible text.
Select the third option using the index.
Select the fourth option using the value.
Get all the options and print them to the console.
Close the browser."""

#Import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

#Start the driver
with webdriver.Firefox() as driver:
    #Open the web page
    driver.get("https://training-support.net/webelements/selects")
    #Print the title of the page
    print("Title of the page: ", driver.title)

    #Find the dropdown
    dropdown = driver.find_element(By.CSS_SELECTOR, "select.h-10")
    #Pass the webelement to the select object
    singleSelect = Select(dropdown)

    #Select the second option using visible text
    singleSelect.select_by_visible_text("Two")
    print("Second option visible by text: ", singleSelect.first_selected_option.text)

    #Select the third option using the index
    singleSelect.select_by_index(2)
    print("Third option by index: ", singleSelect.first_selected_option.text)

    #Select the fourth option using the value
    singleSelect.select_by_value("four")
    print("Fourth option by value: ", singleSelect.first_selected_option.text)

    #Print all the options
    allOptions = singleSelect.options
    print("Options in the dropdown are, ")
    for option in allOptions:
        print(option.text)