/*
 Open a new browser to https://training-support.net/webelements/alerts
Get the title of the page and print it to the console.
Find the button to open a PROMPT alert and click it.
Switch the focus from the main window to the Alert box and get the text in it and print it.
Type "Awesome!" into the prompt.
Close the alert by clicking Ok.
Close the browser.
 */

package training;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Create new instance for firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the web page and print the title of the page
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("Title of the web page: " + driver.getTitle());
		
		//Find the button to open a PROMPT alert and click it
		driver.findElement(By.id("prompt")).click();
		
		//Switch focus to the alert box
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("Text in the alert box is: " + promptAlert.getText());
		
		//Type 'Awesome' in the alert prompt window
		promptAlert.sendKeys("Awesome!");
		Thread.sleep(5000);
		
		//Close the alert by clicking ok
		promptAlert.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//Close the browser
		driver.quit();
	}
}
