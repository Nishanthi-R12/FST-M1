/*
 Open a new browser to https://training-support.net/webelements/tables
Get the title of the page and print it to the console.
Using xpaths on the table:
Find the number of rows and columns in the table and print them.
Find and print all the cell values in the third row of the table.
Find and print the cell value at the second row second column.
Close the browser.
 */

package training;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {

	public static void main(String[] args ) {
		
		//Initialize the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the web page and print the title of web page
		driver.get("https://training-support.net/webelements/tables");
		System.out.println("Title of the web page: " + driver.getTitle());
		
		//Find the no. of rows and columns in the table and print them
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
		System.out.println("Number of rows: " + rows.size());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
		System.out.println("Number of cols: " + cols.size());
		
		//Print the cell value of the third row
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[3]/td"));
		System.out.println("Third row cell values are: ");
		for (WebElement cell : thirdRow) {
			System.out.println(cell.getText());
		}
		//Print the cell value of the second row and second column
		WebElement secondRowCellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]"));
		System.out.println("Second row cell value: " + secondRowCellValue.getText());
		
		//Close the browser
		driver.quit();
	}
}
