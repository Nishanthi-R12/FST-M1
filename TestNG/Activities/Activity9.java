/*
 Create a TestNG Class with the annotations
@Test, @BeforeClass, @BeforeMethod & @AfterClass
Once the Class file is created, import
By, WebDriver, FirefoxDriver, Alert, Reporter

In the @BeforeClass method, create the a driver instance for FirefoxDriver
Also use the get() method to open the browser with https://training-support.net/webelements/alerts
In the @AfterClass method, use close() to close the browser once the test is done.
Make three @Test methods - simpleAlertTestCase(), confirmAlertTestCase(), promptAlertTestCase().

Each @Test method will open a type of alert and getText() from it and print it in the console.
Use driver.switchTo().alert() to switch focus to the alert.
In the @BeforeMethod method, use driver.switchTo().defaultContent() to switch focus back to the page.

Confirm and Prompt Alerts can be closed using alert.accept() and alert.dismiss().
For the prompt alert, use alert().sendKeys() to type the text in the input box.
Use the logger methods to add logging sentences.
Add assertions statement in each test method.
Run the test script as a TestNG Test.
Observe results in the Console and the generated HTML file.
*/
package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;


public class Activity9 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		//Initialize the firefox driver
		driver = new FirefoxDriver();
		
		Reporter.log("-- Starting Test --");
		//Open the browser
		driver.get("https://training-support.net/webelements/alerts");
		Reporter.log("--Opened Browser--");
		//Print the title of the web page
		Reporter.log("--Title of the page is " + driver.getTitle() + "--");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("--Test case setup started--");
		driver.switchTo().defaultContent();
	}
	
	@Test(priority = 1)
	public void simpleAlertTestCase() {
		Reporter.log("--Simple alert test case is started--");
		driver.findElement(By.id("simple")).click();
		Reporter.log("--Simple alert opened--");
		
		//Switch to alert window
		Alert simpleAlert = driver.switchTo().alert();
		Reporter.log("--Switched focus to alert--");
		
		//Get text from the alert box and print it
		String alertText = simpleAlert.getText();
		Reporter.log("--Alert text is " + alertText + "--");
		
		//Assertion
		Assert.assertEquals(alertText, "You've just triggered a simple alert!");
		simpleAlert.accept();
		Reporter.log("Alert closed");
		Reporter.log("--Test case ended--");
	}
	
	@Test(priority = 2)
	public void confirmAlertTestCase() {
		Reporter.log("--Confirm alert test case is started--");
		driver.findElement(By.id("confirmation")).click();
		Reporter.log("--Confirm alert opened--");
		
		//Switch to alert window
		Alert confirmAlert = driver.switchTo().alert();
		Reporter.log("--Switched focus to confirm alert--");
		
		//Get text from the alert box and print it
		String confirmText = confirmAlert.getText();
		Reporter.log("--Alert text is " + confirmText + "--");
		
		//Assertion
		Assert.assertEquals(confirmText, "You've just triggered a confirmation alert!");
		confirmAlert.accept();
		Reporter.log("Alert closed");
		Reporter.log("--Test case ended--");
	}
		@Test(priority = 3)
		public void promptAlertTestCase() {
			Reporter.log("--Prompt alert test case is started--");
			driver.findElement(By.id("prompt")).click();
			Reporter.log("--Prompt alert opened--");
			
			//Switch to alert window
			Alert promptAlert = driver.switchTo().alert();
			Reporter.log("--Switched focus to prompt alert--");
			
			//Get text from the alert box and print it
			String promptText = promptAlert.getText();
			Reporter.log("--Alert text is " + promptText + "--");
			//Assertion
			Assert.assertEquals(promptText, "I'm a Prompt! Type something into me!");
			//Type something into the prompt text box
			promptAlert.sendKeys("Welcome");
			Reporter.log("--Text entered in prompt window--");
			//Close the prompt
			promptAlert.accept();
			Reporter.log("Alert closed");
			Reporter.log("--Test case ended--");
		}
		
		@AfterClass
		public void closeBrowser() {
			Reporter.log("--Ending Test--");
			driver.close();
		}
	}

