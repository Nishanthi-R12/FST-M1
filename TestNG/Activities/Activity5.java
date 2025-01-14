/*Create a TestNG Class with the annotations
@Test
@BeforeClass
@AfterClass
In the @BeforeClass method, create the a driver instance for FirefoxDriver
Also use the get() method to open the browser with https://training-support.net/webelements/target-practice
In the @AfterClass method, use close() to close the browser once the test is done.
Write tests for:

Checking the page title
Header Tests:
Find the third header and assert the text in the h3 tag.
Find and assert the colour of the fifth header tag element.
Button Tests:
Find the button with the class emerald and assert it text.
Find and assert the colour of the first button in the third row.
Group the Header tests under a group, HeaderTests.
Group the Button tests under a group, ButtonTests.

In testng.xml:
Run all the tests from this activity.
Run only the tests that are in the HeaderTests group.
Run only the tests that are in the ButtonTests group.
Exclude the tests that are in the HeaderTests group.
*/
package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Activity5 {

	WebDriver driver;
	
	// Include alwaysRun property on the @BeforeClass to make sure the page always opens
    @BeforeClass(alwaysRun = true)
	public void systemSetUp() {
    	//Initiliaze the firefox driver & open the browser
    	driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
    @Test(groups = { "HeaderTests", "ButtonTests" })
	public void printTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("Title of the web page: " + pageTitle);
		Assert.assertEquals(pageTitle, "Selenium: Target Practice");
	}
	
	//Header tests
	//Find the third header and assert the text in the h3 tag.
	@Test(dependsOnMethods = { "printTitle" }, groups = { "HeaderTests" })
	public void headerTest1() {
		String thirdHeading = driver.findElement(By.xpath("//h3[contains(text(), 'Heading #3')]")).getText();
		System.out.println("Third header is " + thirdHeading);
		Assert.assertEquals(thirdHeading, "Heading #3");
	}
	
	//Find and assert the color of the fifth header tag element
	@Test(dependsOnMethods = { "printTitle" }, groups = { "HeaderTests" })
	public void headerTest2() {
		Color header5Color = Color
                .fromString(driver.findElement(By.cssSelector("h3#third-header")).getCssValue("color"));
        Assert.assertEquals(header5Color.asHex(), "#9333ea");
	}
	
	//Find the button with the class emerald and assert it text
	@Test(dependsOnMethods = { "printTitle" }, groups = { "ButtonTests" })
	public void buttonTest1() {
		WebElement buttonEmerald = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
		Assert.assertEquals(buttonEmerald, "Emerald");
	}
	
	//Find and assert the color of the first button in the third row.
	@Test(dependsOnMethods = { "printTitle" }, groups = { "ButtonTests" })
	public void buttonTest2() {
		Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
		Assert.assertEquals(button2Color.asHex(), "#E9D5FF");
	}
	
	// Include alwaysRun property on the @AfterClass to make sure the page always closes
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        // Close the browser
        driver.close();
    }
}
