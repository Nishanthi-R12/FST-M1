package projectActivity;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.net.URI;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class KeepApp {

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
	public void keepApp() throws InterruptedException {
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Keep Notes\"]")).click();
		Thread.sleep(2000);
		
		//Clicking create new button
		driver.findElement(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create a note\"]")).click();
		Thread.sleep(6000);
		
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		//Selecting notes format to add notes
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@content-desc=\"New text note\"]"))).click();
		Thread.sleep(5000);
		
		//Adding description
		//wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text"))).sendKeys("12");
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Adding notes");
		Thread.sleep(2000);
		
		//Adding title
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/editable_title\"]"))).sendKeys("Appium project");
		Thread.sleep(2000);
		
		//Navigating back
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))).click();
		Thread.sleep(2000);
		
		//Assertion
		String msg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\"]")).getText();
		assertTrue(msg.contains("Appium"));
		
	}
}
