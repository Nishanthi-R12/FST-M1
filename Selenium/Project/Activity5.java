/*
 Getting colors 
Goal: Get the color of the navigation menu 
a. Open a browser. 
b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials 
provided.
c. Get the color of the navigation menu and print it to the console. 
d. Close the browser. 
 */

package crmactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Activity5 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		//Initialize the firefox driver
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test(priority = 1)
	public void login() {
		
		WebElement userName = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("username_password"));
		
		//Enter login credential
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		driver.findElement(By.name("Login")).click();
	}
	
	@Test(priority = 2)
	public void getColor() {
		
		String navigationMenuColor = driver.findElement(By.xpath("//div[@id = 'toolbar']")).getCssValue("color");
		System.out.println("Color of the navigation menu is: " + navigationMenuColor);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
