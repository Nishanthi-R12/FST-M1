/*
 Open a new browser to https://training-support.net/webelements/alerts
Get the title of the page and print it to the console.
Find the button to open a CONFIRM alert and click it.
Switch the focus from the main window to the Alert box and get the text in it and print it.
Close the alert once with Ok and again with Cancel.
Close the browser.
 */

package training;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		
		//Create an instance of the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser and print the title of the web page
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("Title of the web page: " + driver.getTitle());
		
		//Find the button to open a CONFIRM alert and click it
		driver.findElement(By.id("confirmation")).click();
		
		//Switch the focus from the main window to the alert box
		Alert confirmAlert = driver.switchTo().alert();
		
		//Get the text in the alert and print it
		System.out.println("Text in the alert: " + confirmAlert.getText());
		
		//Close the alert by clicking ok
		confirmAlert.accept();
		
		//Can also be closed by clicking cancel
		//confirmAlert.dismiss();
		
		//Print the message
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//Close the browser
		driver.quit();
	}
}
