/*Open a new browser to https://training-support.net/webelements/login-form/
Get the title of the page and print it to the console.
Find the username field using any locator and enter "admin" into it.
Find the password field using any locator and enter "password" into it.
Find the "Log in" button using any locator and click it.
Close the browser.*/

package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		//Initialize the Firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the page
		driver.get("https://training-support.net/webelements/login-form");
		//Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		
		//Find the username field and enter the username
		driver.findElement(By.id("username")).sendKeys("admin");
		//Find the password field and enter the password
		driver.findElement(By.id("password")).sendKeys("password");
		//Find the login button and click it
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//Print the confirmation message
		String message = driver.findElement(By.tagName("h1")).getText();
		System.out.println(message);
		//Close the browser
		driver.quit();
		
	}
}
