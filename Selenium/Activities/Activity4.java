/* Open a new browser to https://training-support.net/webelements/target-practice
Get the title of the page and print it to the console.
Using xpath:
Find the 3rd header on the page and print it's text to the console.
Find the 5th header on the page and print it's color.
Using any other locator:
Find the purple button and print all it's classes.
Find the slate button and print it's text.
Close the browser.*/

package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {
	public static void main(String[] args) {
		//Create new instance of the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Navigate to the browser web page
		driver.get("https://training-support.net/webelements/target-practice");
		
		//Print the title of the page
		System.out.println("Page title is " + driver.getTitle());
		
		//Find the 3rd header on the page and print it's text to the console
		String thirdHeaderText = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
		System.out.println("Third header on the page is " + thirdHeaderText);
		
		//Find the 5th header on the page and print it's color.
		//String fifthHeaderText = driver.findElement(By.xpath("//h5[contains[text(), '#5')]")).getText();
		//System.out.println("Fifth header on the page is Heading " + fifthHeaderText);
		String fifthHeaderTextColor = driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color");
		
		System.out.println("Color as RGB: " + fifthHeaderTextColor);
		System.out.println("Color as hexcode: " + fifthHeaderTextColor);
		
		//Find the purple button and print its classes
		String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
		System.out.println("Class of purple button is " + purpleButtonClass);
		
		//Find the grey button and print its text
		String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
		System.out.println(slateButtonText);
		
		//Closing the browser
		driver.quit();
		
	}
}
