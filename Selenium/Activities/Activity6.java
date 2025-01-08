/*Open a new browser to https://training-support.net/webelements/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox input element.
Check if the checkbox is selected and print the result.
Click the checkbox to select it.
Check if the checkbox is selected again and print the result.
Close the browser.*/

package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
	public static void main(String[] args) {
		//Initialize the web driver
		WebDriver driver = new FirefoxDriver();
		//Open the browser
		driver.get("https://training-support.net/webelements/dynamic-controls");
		//Print the title of the page
		System.out.println("Title of the page - " + driver.getTitle());
		
		//Find the checkbox input element
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		//Click the checkbox
		checkbox.click();
		//Verify if checkbox is selected
		System.out.println("Checkbox is selected - " + checkbox.isSelected());
		//Click the checkbox to unselect it
		checkbox.click();
		//Verify if checkbox is selected
		System.out.println("Checkbox is selected - " + checkbox.isSelected());
		
		//Close the browser
		driver.quit();
	}
}
