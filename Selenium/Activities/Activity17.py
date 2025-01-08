"""Open a new browser to https://training-support.net/webelements/selects
Get the title of the page and print it to the console.
On the Multi Select:
Select the "HTML" option using the visible text.
Select the 4th, 5th and 6th options using the index.
Select the "Node" option using the value.
Deselect the 5th option using index."""

#Import the webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

#Start the driver
with webdriver.Firefox() as driver:
    #Open the browser
    driver.get("https://training-support.net/webelements/selects")
    #Print the title of the page
    print("Title of the page: ", driver.title) 
    #Find the dropdown
    selectElement = driver.find_element(By.CSS_SELECTOR, "select.h-80")
    #pass the webelement to the select object
    multiSelect = Select(selectElement)

    #Select html using visible text
    multiSelect.select_by_visible_text("HTML")
    #Print the selected option
    print("Selected option by visible text: ", multiSelect.first_selected_option.text)

    #Select 4th, 5th and 6th index options
    for i in range(3,5):
        multiSelect.select_by_index(i)
    #Select "Node" using value attribute
    multiSelect.select_by_value("nodejs")
    
    #Print the selected option
    selectedOptions = multiSelect.all_selected_options
    print("Selected options are, ")
    for option in selectedOptions:
        print(option.text)
    
    # Deselect the 5th index option
    multiSelect.deselect_by_index(4)
    # Print the selected options
    selectedOptions = multiSelect.all_selected_options
    print("Selected options are: ")
    for option in selectedOptions:
        print(option.text)
