/*Create a TestNG Class with the annotations
@Test
@BeforeClass
@AfterClass
In the @BeforeClass method, create the a driver instance for FirefoxDriver
Also use the get() method to open the browser with https://training-support.net/webelements/login-form/
In the @AfterClass method, use close() to close the browser once the test is done.
Find the login input fields - username and password
Enter the credentials - admin and password - and click the "Log in" button.
Read the confirmation message and make and assertion to check if the correct message has been printed.
*/

package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Activity3 {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void homePageTest() {
		//Create an instance to firefox driver
		driver = new FirefoxDriver();
		
		//Initialize the wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open the browser
		driver.get("https://training-support.net/webelements/login-form");
	}
	@Test
	public void login() {
		//Find the web element of username and password
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		
		//Enter the login credentials in the fields username and password. 
		username.sendKeys("admin");
		password.sendKeys("password");
		
		//Find the Submit button and click it.
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		login.click();
	}
	@Test
	public void assertionTest() {
		String loginMsg = driver.findElement(By.xpath("//h2[contains(@class, 'text-center')]")).getText();
		System.out.println("Login message: " + loginMsg);
		Assert.assertEquals(loginMsg, "Welcome Back, Admin!");
	}
	
	@AfterClass
	public void closingBrowser() {
		driver.close();
	}
}
