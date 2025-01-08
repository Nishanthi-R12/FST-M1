/*Open a new browser to https://training-support.net/webelements/selects
Get the title of the page and print it to the console.
On the Single Select:
Select the second option using the visible text.
Select the third option using the index.
Select the fourth option using the value.
Get all the options and print them to the console.
Close the browser.*/

package training;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	public static void main(String[] args) {
		//Create new instance of the firefox driver
		WebDriver driver = new FirefoxDriver();
		//Open the web page
		driver.get("https://training-support.net/webelements/selects");
		//print the title of the page
		System.out.println("Title of the page is, " + driver.getTitle());
		
		//Find the dropdown
		WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));
		//Pass the webelement to select the object
		Select singleSelect = new Select(dropdown);
		
		//Select the second option using the visible text
		singleSelect.selectByVisibleText("Two");
		System.out.println("Second option by visible text: " + singleSelect.getFirstSelectedOption().getText());
		
		//Select the third option using the index
		singleSelect.selectByIndex(2);
		System.out.println("Third option using the index: " + singleSelect.getFirstSelectedOption().getText());
		
		//Select the fourth option using value
		singleSelect.selectByValue("four");
		System.out.println("Fourth option: " + singleSelect.getFirstSelectedOption().getText());
		
		//Print all the options
		List<WebElement> allOptions = singleSelect.getOptions();
		System.out.println("Options in the dropdown are, ");
		for(WebElement option : allOptions) {
			System.out.println(option.getText());
		}
		
		//Close the browser
		driver.quit();
	}
}
