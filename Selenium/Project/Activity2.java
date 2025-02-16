/*
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’. 
c. Get the url of the header image. 
d. Print the url to the console. 
e. Close the browser. 
 */

package crmactivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;


public class Activity2 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void printURL() {
		//Find the url of the headerimage
		WebElement headerImageURL = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		
		
		//Print the url to the console
		System.out.println("Header image URL is " + headerImageURL);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
