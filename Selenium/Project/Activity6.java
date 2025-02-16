/*
  a. Open a browser.
  b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials provided.
  c. Locate the navigation menu. 
  d. Ensure that the “Activities” menu item exists. 
  e. Close the browser  
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

public class Activity6 {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		
		//Driver initialization
		driver = new FirefoxDriver();
		
		//Open the url
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void login() {
		
		WebElement userName = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("username_password"));
		
		//Enter login credential
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		driver.findElement(By.name("Login")).click();
	}
	
	@Test
	public void navigationMenu() {
		
		WebElement crmMenu = driver.findElement(By.xpath("//div[@id = 'toolbar']"));
		System.out.println("Is navigation menu displayed - " + crmMenu.isDisplayed());
		WebElement activities = driver.findElement(By.xpath("//a[contains(@id, 'grouptab_3')]"));
		System.out.println("Is activities menu clickable - " + activities.isDisplayed());
		activities.click();
		System.out.println("Activity menu is clickable & dropdown lists are shown in the UI screen");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
