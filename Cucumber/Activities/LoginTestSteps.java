package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoginTestSteps extends BaseClass {
	
	@Given("The user is on the login page")
	public void user_on_the_login_page() {
		
		//Open the browser
		driver.get("https://training-support.net/webelements/login-form");
		
		//Assert page title
		Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
	}
	
	@When("The user enters username and password")
	public void user_enters_credential() {
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}
	
	@And("clicks the submit button")
	public void click_submit_button() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	@Then("get the confirmation message and verify it")
	public void get_confirmation_verify_message() {
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
		
		String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();
		
		//Assertion
		Assertions.assertEquals("Welcome Back, Admin!", message);
		System.out.println("Message displayed in the web page post login is " + message);
	}
}
