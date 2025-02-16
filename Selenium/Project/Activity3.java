/*
Get the copyright text 
Goal: Print the first copyright text in the footer to the console 
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’. 
c. Get the first copyright text in the footer. 
d. Print the text to the console. 
e. Close the browser.
 */
package crmactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	WebDriver driver;
		
	//Initialize the firefox driver and open the browser
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void copyrightText() {
		//Get the first copyright text in the footer
		String copyrightText = driver.findElement(By.id("admin_options")).getText();
		System.out.println("First copyright of the footer is " + copyrightText);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
