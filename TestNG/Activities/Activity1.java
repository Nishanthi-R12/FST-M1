/*Create a TestNG Class with the annotations
@Test
@BeforeClass
@AfterClass
In the @BeforeClass method, create the a driver instance for FirefoxDriver
Also use the get() method to open the browser with https://training-support.net
In the @AfterClass method, use close() to close the browser once the test is done.
In the @Test method,
Use getTitle() to get and print the title of the page.
Make an assertion using assertEquals() to make sure the title of the page is "Training Support".
Use findElement() to find the "About Us" Button on the page and click it.
Get and print the title of the new page.
Assert the title of the new page.
*/
package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	
	//Setup function
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
	}
	@Test(priority = 1)
	public void homePage() {
		System.out.println("Title of the page is " + driver.getTitle());
		//Assert page title
		Assert.assertEquals(driver.getTitle(), "Training Support");
		//Find the About Us link and click it
		driver.findElement(By.linkText("About Us")).click();
	}
	@Test(priority = 2)
	public void aboutUsPage() {
		//Assert new page title
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}
	@AfterClass
	public void closePage() {
		driver.quit();
	}
}
