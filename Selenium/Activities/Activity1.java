/* Open the training support site. (https://training-support.net)
Print the title of the page
Click the about us button
Print the title of the new page*/

package training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
	
public class Activity1 {

	public static void main(String[] args) {
		//Initialize the FireFox driver
		WebDriver driver = new FirefoxDriver();
		
		//Opening the web page
		driver.get("https://training-support.net");
		
		//Verifying the page title
		System.out.println("Page title is: " + driver.getTitle());
		
		//Find the About Us link and click it
		driver.findElement(By.linkText("About Us")).click();
		
		//Print the page title of the About Us page
		System.out.println("New page title is: " + driver.getTitle());
		
		//Closing browser
		driver.quit();
	}
}
