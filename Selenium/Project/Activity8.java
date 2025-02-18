/*
 1. Open the browser to the Alchemy CRM site and login
 2. Navigate to sales -> accounts page
 3. Find the table on the page and print the names of the first 5 odd numbered rows of the table to the console
 4. Close the browser
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

public class Activity8 {

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
    public void accounts() {
        // Navigate to accounts
        driver.findElement(By.xpath("//a[contains(@id, 'grouptab_0')]")).click();
        driver.findElement(By.xpath("//a[contains(@id, 'moduleTab_9_Accounts')]")).click();

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
               
                // Loop through odd-numbered rows and print the text in each cell
              /*  int rowCount = 0;
                for (WebElement row : rows) {
                    if (rowCount % 2 != 0) { // Odd numbered rows (0-based index, odd numbers will be 1, 3, 5, etc.)
                        List<WebElement> columns = row.findElements(By.tagName("td"));
                        for (WebElement column : columns) {
                            System.out.print(column.getText() + " ");
                            //System.out.println(columns.get(0).getText());
                        }
                        System.out.println();
                    }
                    rowCount++;
                    if (rowCount >= 10) break; // Limit to first 5 odd-numbered rows
                }*/
                
                int count = 0;
                for(int i=0; i<=rows.size(); i++) {
                	if(count<5) {
                	if(i%2==0) {
                		String a= rows.get(i).findElements(By.tagName("td")).get(2).getText();
                		System.out.println(a);
                		count+=1;
                       }
                	}
                	
                }
            } else {
                System.out.println("Table not found in the main document.");
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
