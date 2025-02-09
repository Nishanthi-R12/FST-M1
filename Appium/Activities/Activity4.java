package activities;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {

	//Driver declaration
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.contacts");
		options.setAppActivity(".activities.PeopleActivity");
		options.noReset();
		
		//Server address
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test
	public void addContacts() {
		
		//Clicking + button to add new contact
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new contact\"]")).click();
		
		//Wait for the element to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")));
		
		//Entering first name
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys("Aaditya");
		
		//Entering last name
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys("Varma");
		
		//Entering phone number
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Phone\"]")).sendKeys("999148292");
		
		//Saving contact details
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.contacts:id/editor_menu_save_button\"]")).click();
		
		//Assertion
		String contactName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.android.contacts:id/large_title\"]")).getText();
		assertTrue(contactName.contains("Nishanthi R"));
		System.out.println("Assertion Passed: Contact name is " + contactName);
	}
}
