/*Open a new browser to https://training-support.net/webelements/selects
Get the title of the page and print it to the console.
On the Multi Select:
Select the "HTML" option using the visible text.
Select the 4th, 5th and 6th options using the index.
Select the "Node" option using the value.
Deselect the 5th option using index.*/

package training;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
	public static void main(String[] args) {
		//Create instance of firefox driver
		WebDriver driver = new FirefoxDriver();
		//Open the web page
		driver.get("https://training-support.net/webelements/selects");
		//Print the title of the page
		System.out.println("Title of the page: " + driver.getTitle());
		//Find the drop down
		WebElement selectElement = driver.findElement((By.cssSelector("select.h-80")));
		//Pass the webelement to select the object
		Select multiSelect = new Select(selectElement);
		
		//Select "html" using the visible text
		multiSelect.selectByVisibleText("HTML");
		//Select 4th, 5th and 6th index options
		for (int i=3; i<=5; i++) {
			multiSelect.selectByIndex(i);
		}
		//SElect "Node" using value attribute
		multiSelect.selectByValue("nodejs");
		
		//Print the selected options
		List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
		System.out.println("Selected options are, ");
		for (WebElement option: selectedOptions) {
			System.out.println(option.getText());	
		}
		//Deselect the 5th index option
		multiSelect.deselectByIndex(5);
		//Print the selected options
		selectedOptions = multiSelect.getAllSelectedOptions();
		for (WebElement option: selectedOptions) {
			System.out.println(option.getText());	
		}
		//Close the browser
		driver.quit();
		
	}
}
