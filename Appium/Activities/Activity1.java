

package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Activity1 {
	
	//Driver declaration
	AndroidDriver driver;
	
	//Setup method
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");
		options.noReset();
		
		//Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Driver initialization
		driver = new AndroidDriver(serverURL, options);
	}
	
	//Test method
	@Test
	public void multiplyTest() {
		
		//Calculation
		driver.findElement(AppiumBy.id("digit_4")).click();
		driver.findElement(AppiumBy.accessibilityId("×")).click();
		driver.findElement(AppiumBy.id("digit_7")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		//Find the result
		String result = driver.findElement(AppiumBy.id("result")).getText();
		
		//Assertion
		Assert.assertEquals(result, "12");
	}
}
