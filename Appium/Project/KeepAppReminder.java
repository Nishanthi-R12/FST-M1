package projectActivity;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.net.URI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class KeepAppReminder {
	
	//Driver declaration
	AndroidDriver driver;
	WebDriverWait wait;
		
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException  {
		
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.nexuslauncher");
		options.setAppActivity(".NexusLauncherActivity");
		options.noReset();
		
		//Server address
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void keepAppReminderSetup() throws InterruptedException {
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Keep Notes\"]")).click();
		Thread.sleep(2000);
		
		//Clicking create new button
		driver.findElement(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create a note\"]")).click();
		Thread.sleep(6000);
		
		//Selecting notes format to add notes
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@content-desc=\"New text note\"]"))).click();
		Thread.sleep(5000);
		
		//Adding title
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/editable_title\"]"))).sendKeys("Appium project");
		Thread.sleep(2000);
		
		//Adding description
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Adding notes & setting up reminder");
		Thread.sleep(2000);
				
		//Setting up reminder
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Reminder\"]"))).click();
		Thread.sleep(2000);
		
		//Selecting time
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Pick a date & time\"]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.keep:id/save\"]"))).click();
		Thread.sleep(2000);
		
		//Navigating back
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))).click();
		Thread.sleep(2000);
		
		//Navigating to menu list
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"))).click();
		Thread.sleep(2000);
		
		//Selecting reminder option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/title\" and @text=\"Reminders\"]"))).click();
		Thread.sleep(2000);
		
		//Assertion
		WebElement reminder = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/reminder_chip_text\"]"));
		assertTrue(reminder.isDisplayed(), "Reminder notification is not displayed");
		System.out.println("Reminder notification is displayed successfully"); 
	}
	
}
