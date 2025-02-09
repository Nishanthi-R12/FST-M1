package projectActivity;

import static projectActivity.ActionBase.doSwipe;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TodoList {

	//Driver declaration
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	//Setup method
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		//Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
				
		//Driver initialization
		driver = new AndroidDriver(serverURL, options);
		
		//Open the page in chrome
		driver.get("https://v1.training-support.net/selenium");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test(priority = 1)
	public void toDo() {
		
		//Wait for the page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text=\"Selenium\"]")));
		
		//Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		
		//Set the start and end points
		Point start = new Point ((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .77));
		Point end = new Point ((int) (dims.getWidth() * .67), (int) (dims.getHeight() * .25));
		
		//Perform swipe
		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		
		
		
	}

	@Test(priority = 2)
	public void addTasks() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"To-Do List  Elements get added at run time \"]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]"))).sendKeys("Add tasks to list");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]"))).sendKeys("Get number of tasks");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]"))).sendKeys("Clear the list");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
	}
	
	@Test(priority = 3)
	public void clickEachTaskToStrike() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Add tasks to list\"]"))).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Get number of tasks\"]"))).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Clear the list\"]"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void clearList() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\" Clear List\"]"))).click();
	}
	
}
