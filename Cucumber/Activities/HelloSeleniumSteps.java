package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HelloSeleniumSteps {
	
	private WebDriver driver;
	private String title;
	
	@Given("user is on the training support home page")
	public void user_is_on_home_page() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
	}
	
	@When("the user checks the title of the page")
	public void user_checks_title_page() {
		title = driver.getTitle();
	}
	
	@Then("they should see Training Support")
	public void user_should_see_training_support_page() {
		Assertions.assertEquals("Training Support", title);
	}
	
	@And("close the browser")
	public void closing_browser() {
		driver.close();
	}
}
