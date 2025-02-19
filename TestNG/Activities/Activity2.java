/*Create a TestNG Class with the annotations
@Test
@BeforeClass
@AfterClass
In the @BeforeClass method, create the a driver instance for FirefoxDriver
Also use the get() method to open the browser with https://training-support.net/webelements/target-practice/
In the @AfterClass method, use close() to close the browser once the test is done
Add 4 @Test methods.
In the first @Test method, use getTitle() to get and assert the title of the page.
In the second @Test method, use findElement() to look for the black button. Make an incorrect assertion. (This test case is meant to throw an error)
For the third @Test method, skip it by setting it's enabled parameter to false.
The third method will be skipped, but will not be shown as skipped.
For the fourth @Test method, skip it by throwing a SkipException inside the method.
The fourth method will be skipped and it will be shown as skipped.
Observe the result in the console.
*/
package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.SkipException;

public class Activity2 {
	WebDriver driver;
	@BeforeClass
	public void systemSetUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
	}
	
	@Test(priority = 1)
	public void testcase1() {
		System.out.println("Title of the page is " + driver.getTitle());
		//Assert the title
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}
	@Test(priority = 2)
	public void testcase2() {
		//This is for failed test case
		WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(), "black");
	}
	@Test
	public void testcase3() {
		//This is to check the skipped test case. This will be skipped and not counted
		String subHeading = driver.findElement(By.className("sub")).getText();
		Assert.assertTrue(subHeading.contains("Practice"));
	}
	@Test
	public void testcase4() {
		//THis is to check the skipped test case. This will be skipped and shown as skipped
		throw new SkipException("Skipping test case");
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
