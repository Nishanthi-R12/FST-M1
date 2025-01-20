/*Open a new browser to https://training-support.net/webelements/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox on the page.
Click the "Toggle Checkbox" button to remove the checkbox.
Wait for the checkbox to disappear.
Toggle the checkbox again.
Wait for it appear and then select it.
Close the browser.*/
package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open the browser
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		//Verify the page title
		System.out.println("Page title is " + driver.getTitle());
		
		//Find the checkbox and make sure it is visible
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		System.out.println("Is checkbox visible? " + checkbox.isDisplayed());
		
		//Find the button to toggle it and click it
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		
		//Wait for it to disappear
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		
		//Check if it is visible
		System.out.println("Is checkbox visible? " + checkbox.isDisplayed());
		
		//Toggle the checkbox and click it
		driver.findElement(By.xpath(("//button[text()='Toggle Checkbox']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		
		//Check if it is selected
		System.out.println("Is checkbox selected? " + checkbox.isSelected());
		
		//Close the browser
		driver.quit();
	}

}
