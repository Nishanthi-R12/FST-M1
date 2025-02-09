/*
 In this activity we will be practicing with a page in a browser on the mobile device.
 */

package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

	//Driver declaration
	AndroidDriver driver;
	
	//Setup method
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		//Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Driver initialization
		driver = new AndroidDriver(serverURL, options);
		
		//Open the page in chrome
		driver.get("https://training-support.net");
	}
	
	//Test method
	@Test
	public void chromeTest() {
		
		//Find heading on the page
		String pageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
		
		//Print to console
		System.out.println("Page heading is: " + pageHeading);
		
		//Find and click the About us link
		driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"About Us\"]")).click();
				
		//Find the heading of the new page and print it to the console
		String aboutUsPageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")).getText();
		System.out.println("Heading of About us page is: " + aboutUsPageHeading);
	}
	
	//Tear down method
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
