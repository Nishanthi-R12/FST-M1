package projectActivity;

import static org.testng.Assert.assertTrue;

//import static projectActivity.ActionBase.doSwipe;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class PopupCard extends ActionBase {
	
	//Driver declaration
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		//Server address
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Driver initialization
		driver = new AndroidDriver(serverURL, options);
		
		//Open the page in chrome
		driver.get("https://v1.training-support.net/selenium");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void scrollToPopUp() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text=\"Selenium\"]")));
		
		//Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		
		//Set the start and end points
		Point start = new Point ((int) (dims.getWidth() * .37), (int) (dims.getHeight() * .80));
		Point end = new Point ((int) (dims.getWidth() * .54), (int) (dims.getHeight() * .11));
		
		//Perform Swipe
		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Popups  Tooltips and Modals \"]"))).click();
		Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods = {"scrollToPopUp"}, priority = 1)
	public void signIn_ValidCredentials() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In \"]"))).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"))).sendKeys("admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"))).sendKeys("password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]"))).click();
		Thread.sleep(2000);
		
		//Assertion
		String signInMsg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
		assertTrue(signInMsg.contains("Welcome Back, admin"));
		System.out.println("Valid credential message is: " + signInMsg);
	}
	
	@Test (priority = 2)
	public void signIn_InvalidCredentials() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In \"]"))).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"))).sendKeys("adm");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"))).sendKeys("pasword");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]"))).click();
		Thread.sleep(2000);
		
		//Assertion
		String signInMsg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
		assertTrue(signInMsg.contains("Invalid Credentials"));
		System.out.println("Credentials are not valid: " + signInMsg);
	}
}
