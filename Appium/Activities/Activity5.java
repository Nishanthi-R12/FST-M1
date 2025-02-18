package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {

	//Driver declaration
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity(".ui.ConversationListActivity");
		options.noReset();
		
		//Server address
		URL serverURL = new URI("http://localhost:4723").toURL();
			
		//Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void smsTest() throws InterruptedException {
		
		// Find and click the add button
        //driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Start chat"))).click();
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Thread.sleep(5000);
        // Wait for elements to load
        //wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("recipient_text_view")));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Aaditya Varma\"]"))).click();
        Thread.sleep(2000);
        
     // Find the element to add recipient
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Type names, phone numbers, or emails\"]"))).sendKeys("Aaditya Varma");
        //Thread.sleep(2000);
        
        // Press ENTER
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
 
        // Wait for textbox to appear
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
 
        // Enter text to send
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.messaging:id/compose_message_text\"]")).sendKeys("Welcome to Appium session");
        // Press Send
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
 
        // Assertion
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("message_text")));
        
        String messageTextSent = element.getText();
        
        //String messageTextSent = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"message_list\"]/android.view.View[1]/android.view.View[1]")).getText();
        System.out.println("Text message" + messageTextSent);
        Assert.assertEquals(messageTextSent, "Welcome to Appium session");
        
       // driver.findElement(AppiumBy.id("ContactSearchField")).sendKeys("999148292");
        
        // Press ENTER
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        
        //driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from selenium");
        
        //driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
        
        //Assertion
        //String messageText = driver.findElement(AppiumBy.id("message_text")).getText();
        //Assert.assertEquals(messageText, "Hello from selenium");
        /*wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Thread.sleep(5000);
        // Wait for elements to load
        //wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("recipient_text_view")));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Aaditya Varma\"]"))).click();
        Thread.sleep(2000);
        
        // Find the element to add recipient
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Type names, phone numbers, or emails\"]"))).sendKeys("Aaditya Varma");
        //Thread.sleep(2000);
        
        // Press ENTER
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
 
        // Wait for textbox to appear
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
 
        // Enter text to send
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.messaging:id/compose_message_text\"]")).sendKeys("Hello from Appium");
        // Press Send
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
 
        // Assertion
        //String messageTextSent = driver.findElement(AppiumBy.id("message_text")).getText();
        String messageTextSent = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"message_list\"]/android.view.View[1]/android.view.View[1]")).getText();
        System.out.println("Text message" + messageTextSent);
        Assert.assertEquals(messageTextSent, "Hello from Appium");
       /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement lastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Aaditya Varma')]")));
     // Assert the message content
        String actualText = lastMessage.getText();
        String expectedText = "Hello, this is a test message!";
        Assert.assertEquals(actualText, expectedText, "SMS content does not match!");*/
    }
 
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
	}
}
