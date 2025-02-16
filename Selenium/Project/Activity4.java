/*
 Logging into the site 
Goal: Open the site and login with the credentials provided 
a. Open the browser  
b. Navigate to ‘https://alchemy.hguy.co/crm’.
c. Find and select the username and password fields 
d. Enter login credentials into the respective fields 
e. Click login 
 */
package crmactivities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Activity4 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm");
	}
	
	@Test
	public void login() {
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("username_password"));
		
		//Enter login credentials and login
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		driver.findElement(By.name("Login")).click();
		
		//Verify if home page is displayed
		String homePage = driver.findElement(By.xpath("//a[contains(@id, 'grouptab_0')]")).getText();
		System.out.println("Home page contains: " + homePage);
		//Assertion
		Assert.assertTrue(homePage.contains("SALES"));
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
