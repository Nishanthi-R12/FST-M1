/*
 1. Open Alchemy CRM browser and login
 2. Navigate to Sales -> leads
 3. In the table, find the additional information icon at the end of the row of the lead information. Click it.
 4. Read the popup and print the phone number displayed in it.
 5. Close the browser.
 */
package crmactivities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class Activity7 {

	//Driver initialization
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement userName = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("username_password"));
		
		//Enter login credential
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		driver.findElement(By.name("Login")).click();
	}
	
	@Test
	public void navigateToSales() throws InterruptedException {
		
		//Navigate to sales
		driver.findElement(By.xpath("//a[contains(@id, 'grouptab_0')]")).click();
		driver.findElement(By.xpath("//a[contains(@id, 'moduleTab_9_Leads')]")).click();
		
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='suitepicon suitepicon-action-info']")));
		firstElement.click();
		Thread.sleep(2000);
		
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[7]/div[2]/h2")));
		
		WebElement phoneNo = popup.findElement(By.xpath("//span[@class='phone']"));
		String printPhoneNo = phoneNo.getText();
		System.out.println("Phone number is " + printPhoneNo);
		
		WebElement closePopup = popup.findElement(By.xpath("(//span[contains(@class, 'ui-button-icon-primary ui-icon ui-icon-closethick')])[4]"));
		closePopup.click();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
