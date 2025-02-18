/*
 1.Open the browser to the Alchemy site and login
 2. Navigate to sales -> leads page
 3. Find the table on the page and print the first 10 values in the name column and the user column of the table to the console
 4. Close the browser.
 */

package crmactivities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeadsTable {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement userName = driver.findElement(By.name("user_name"));
        WebElement password = driver.findElement(By.name("username_password"));

        // Enter login credentials
        userName.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        driver.findElement(By.name("Login")).click();
	}
	
	@Test
	public void leadsTable() {
		
		// Navigate to leads table
        driver.findElement(By.xpath("//a[contains(@id, 'grouptab_0')]")).click();
        driver.findElement(By.xpath("//a[contains(@id, 'moduleTab_9_Leads')]")).click();

        // Wait for the page to load fully and ensure table is present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Wait for any table to be present in the document
        	Thread.sleep(5000);
            WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table")));

            if (table != null && table.isDisplayed()) {
                System.out.println("Table found in the main document.");

                // Find rows inside tbody (Relative XPath)
                List<WebElement> rows = table.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr"));
                System.out.println("rows: "+rows.size());
                System.out.println("First 10 values in the Name & User columns are:");
                int count=0;
                for (int i=0; i<=rows.size(); i++) {
                	if(count<10) {
                		//if(i%2!=0) {
                			String name = rows.get(i).findElements(By.tagName("td")).get(2).getText();
                			System.out.println("Name: " + name);
                			String user = rows.get(i).findElements(By.tagName("td")).get(7).getText();
                			System.out.println("User: " + user);
                			count+=1;
                		//}
                	}
                }
            }
             else {
                	System.out.println("Table not found in the main document");
                }
           	} catch (Exception e) {
           		
           		System.out.println("Error occurred while waiting for the table: " + e.getMessage());
        }
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
