/*Open a new browser to https://training-support.net/webelements/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox input element.
Check if it is visible on the page.
Click the "Remove Checkbox" button.
Check if it is visible again and print the result.
Close the browser.*/

package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
	public static void main(String[] args) {
		
		//Initialize the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		//Print the title of the page
		System.out.println("Title of the page: " + driver.getTitle());
		
		//Find the checkbox
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		//Find the toggle button and click it
		driver.findElement(By.xpath("//button[text() = 'Toggle Checkbox']")).click();
		//Check if it is visible on the page
		System.out.println("Checkbox is visible - " + checkbox.isDisplayed());
		//Click the button again
		driver.findElement(By.xpath("//button[text() = 'Toggle Checkbox']")).click();
		//Check if it is displayed again
		System.out.println("Checkbox is visible - " + checkbox.isDisplayed());
		
		//close the browser
		driver.quit();
	
		
		
		
	}
}
