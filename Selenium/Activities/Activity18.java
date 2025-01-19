/*
 Open a new browser to https://training-support.net/webelements/alerts
Get the title of the page and print it to the console.
Find the button to open a SIMPLE alert and click it.
Switch the focus from the main window to the Alert box and get the text in it and print it.
Close the alert once with OK.
Close the browser.
 */

package training;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		//Create new instance of the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the web page and print the title of the page
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("Title of the web page: " + driver.getTitle());
		
		//Find the button to open a SIMPLE alert and click it
		driver.findElement(By.id("simple")).click();
		
		//Switch focus to the simple alert
		Alert simpleAlert = driver.switchTo().alert();
		
		//Print the text in the alert
		String alertText = simpleAlert.getText();
		System.out.println("Text in the alert is: " + alertText);
		
		//Close the alert by clicking ok in the alert box
		simpleAlert.accept();
		
		//Print the message
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//Close the browser
		driver.quit();
	}
}
