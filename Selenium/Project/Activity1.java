/*Verify the website title 
Goal: Read the title of the website and verify the text 
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’.  
c. Get the title of the website. 
d. Make sure it matches “SuiteCRM” exactly. 
e. If it matches, close the browser.
*/
package crmactivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	WebDriver driver;
	
	//Initialize the firefox driver and open the browser
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void printTitle() {
		System.out.println("Title of the web page is " + driver.getTitle());
		//Assertion
		Assert.assertEquals(driver.getTitle(), "SuiteCRM");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
}
