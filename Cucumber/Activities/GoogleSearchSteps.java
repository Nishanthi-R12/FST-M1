package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchSteps extends BaseClass {

	@Given("User is on Google Home Page")
	public void user_is_on_home_page() throws Throwable {
		//Open the web page
		driver.get("https://www.google.com");
	}
	
	@When("User types in Cheese and hits ENTER")
	public void user_types_cheese_hits_enter() {
		//Type cheese and hit enter
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
	}
	
	@Then("Show how many search results were shown")
	public void showing_search_results() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls"))).click();
		String resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats"))).getText();
		System.out.println("Number of results found: " + resultStats);
	}
}
