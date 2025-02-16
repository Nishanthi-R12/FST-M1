package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class AlertTestSteps extends BaseClass {
	
	Alert alert;
	
	@Given("User is on the page")
	public void user_on_the_page() {
		
		//Open the browser
		driver.get("https://training-support.net/webelements/alerts");
	}
	
	@When("User clicks the simple alert button")
	public void simpleAlert() {
		
		//Finding simple alert button and click it
		driver.findElement(By.id("simple")).click();
	}
	
	@When("User clicks the confirm alert button")
	public void confirmAlert() {
		
		//Finding confirm alert button and click it
		driver.findElement(By.id("confirmation")).click();
	}
	
	@When("User clicks the prompt alert button")
	public void promptAlert() {
		
		//Finding prompt alert button and click it
		driver.findElement(By.id("prompt")).click();
	}
	
	@Then("Alert opens")
	public void alertOpens_switchfocus() {
		
		alert = driver.switchTo().alert();
	}
	
	@And("Read the text from it and print the same")
	public void read_text_and_print() {
		
		System.out.println("Alert message is " + alert.getText());
	}
	
	@And("Write a custom message in it")
	public void customMessageToPrompt() throws InterruptedException {
		alert.sendKeys("Welcome");
		Thread.sleep(2000);
	}
	
	@And("Close the alert")
	public void closeAlert() {
		alert.accept();
	}
	
	@And("Close the alert with cancel")
	public void closeAlertByCancel() {
		alert.dismiss();
	}
	
	@And("Read the result text")
	public void readResult() {
		String message = driver.findElement(By.id("result")).getText();
		System.out.println("Action Performed is " + message);
	}
}
