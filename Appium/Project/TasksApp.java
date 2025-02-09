package projectActivity;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import static org.testng.Assert.assertTrue;

public class TasksApp extends ActionBase {

	//driver declaration
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setUp() throws MalformedURLException, URISyntaxException {
	
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
	public void tasksApp() throws InterruptedException {
		
		//driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.google.android.apps.nexuslauncher:id/layout\"]")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Tasks\"]")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create new task\"]")).click();
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"))).sendKeys("Complete the second Activity Google Keep");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create new task\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"))).sendKeys("Complete Activity with Google Keep");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create new task\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"))).sendKeys("Complete Activity with Google Tasks");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();
		Thread.sleep(7000);
		
		List<WebElement> tasks = driver.findElements(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\"])"));
		
		int i = 1;
		for (WebElement task : tasks) {
			System.out.println("Task" + i + ": " + task.getText());
			i++;
		}
		//Assertions
		List<String> expectedTasks = Arrays.asList("Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep");
		List<String> actualTasks = tasks.stream().map(WebElement::getText).toList();
		System.out.println("Actual tasks: " + actualTasks);
		System.out.println("Expected tasks: " + expectedTasks);
		assertTrue(actualTasks.containsAll(expectedTasks));
	}
}

