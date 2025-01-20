/*
 Open a new browser to https://training-support.net/webelements/dynamic-content
Get the title of the page and print it to the console.
On the page, perform:
Find and click the "Click me!" button.
Wait till the word "release" appears.
Get the text and print it to console.
Close the browser.
 */

package training;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Activity12 {
	
	public static void main(String[] args) {
		//Initialize the firefox driver
		WebDriver driver = new FirefoxDriver();
		//Initialize the wait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open the browser
		driver.get("https://training-support.net/webelements/dynamic-content");
		
		//Print the title of the web page
		System.out.println("Title of the web page: " + driver.getTitle());
		
		//Find and click the 'Click me!' button
		driver.findElement(By.id("genButton")).click();
		
		//Wait for the word 'release' to appear
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"))) {
			//Print the text to the console
			System.out.println("Word found and that word is: " + driver.findElement(By.id("word")).getText());
		}
		
		//Close the browser
		driver.quit();
	}
	
}
