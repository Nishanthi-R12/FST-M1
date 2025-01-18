/* Open a new browser to https://training-support.net/webelements/keyboard-events
Get the title of the page and print it to the console.
On the page, type out a string from the Selenium script to show on the page
Print the message to the console.
Close the browser.*/

package training;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {
	public static void main(String[] args) {
		//Create an instance for firefox driver
		WebDriver driver = new FirefoxDriver();
		//Create the Actions object
		Actions builder = new Actions(driver);
		
		//Open the web page
		driver.get("https://training-support.net/webelements/keyboard-events");
		//Print the title of the page
		System.out.println("Title of the page: " + driver.getTitle());
		
		//Press the key
		builder.sendKeys("Selenium - Full Stack Testing").sendKeys(Keys.RETURN).build().perform();
		
		//Print the message from the page 
		String pageText = driver.findElement(By.cssSelector("h1.mt-3")).getText();
		System.out.println(pageText);
		
		//Close the browser
		driver.quit();
		
	}
}
