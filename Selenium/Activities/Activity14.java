/*
 Open a new browser to https://training-support.net/webelements/tables
Get the title of the page and print it to the console.
Using xpaths on the table:
Find the number of rows and columns in the table and print them.
Find and print the Book Name in the 5th row.
Click the header of the Price column to sort it in ascending order.
Find and print the Book Name in the 5th row again.
Close the browser.
 */

package training;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

public class Activity14 {
	
	public static void main(String[] args) {
	
		//#Initialize the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the web page and print the title of the page
		driver.get("https://training-support.net/webelements/tables");
		System.out.println("Title of the page: " + driver.getTitle());
		
		//Print the no. of rows and columns in the table
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
		System.out.println("No. of rows are " + rows.size());
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
		System.out.println("No. of columns are " + cols.size());
		
		//Print the book name in the 5th row
		WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
		System.out.println("Book name before sorting: " + cellValue.getText());
		
		//Sort the table
		driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th[5]")).click();
		
		//Print the cell value of the second row and second column again
		cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
		System.out.println("Book name after sorting: " + cellValue.getText());
		
		//Close the browser
		driver.quit();
	}
}
