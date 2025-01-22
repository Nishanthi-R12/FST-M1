/*
 One test case for sending a POST request on https://petstore.swagger.io/v2/user
One test case for sending a GET request on https://petstore.swagger.io/v2/user/{username}
One test case for sending a DELETE request on https://petstore.swagger.io/v2/user/{username}
The test cases must execute in the order:
POST request -> GET request -> DELETE request.
 */

package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Activity2 {
	
	@Test(priority = 1)
	public void addNewUserFromFile() throws IOException {
		
		//Import JSON file
		FileInputStream inputJSON = new FileInputStream("C:\\Users\\LENOVO\\Nishanthi\\fst-m1-restassured\\src\\test\\java\\activities\\userInfo.json");
		
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/user") //Setting up base URI
				.header("Content-Type", "application/json") //Setting headers
				.body(inputJSON) //Passing request body from file
				.when().post(); //Sending POST request
		
		inputJSON.close();
		
		//Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("2012"));
	
	}
	
@Test(priority=2)
public void getUserInfo() {
	// Import JSON file to write to
	File outputJSON = new File("src/test/java/activities/userGETResponse.json");

	Response response = given()
		.baseUri("https://petstore.swagger.io/v2/user") // Set base URI
		.header("Content-Type", "application/json") // Set headers
		.pathParam("username", "nishanthir") // Pass request body from file
		.when().get("/{username}"); // Send POST request
	
	// Get response body
	String resBody = response.getBody().asPrettyString();

	try {
		// Create JSON file
		outputJSON.createNewFile();
		// Write response body to external file
		FileWriter writer = new FileWriter(outputJSON.getPath());
		writer.write(resBody);
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	// Assertion
	response.then().body("id", equalTo(2012));
	response.then().body("username", equalTo("nishanthir"));
	response.then().body("firstName", equalTo("Nishanthi"));
	response.then().body("lastName", equalTo("Rajendran"));
	response.then().body("email", equalTo("nishanthir@mail.com"));
	response.then().body("password", equalTo("password123"));
	response.then().body("phone", equalTo("9003573030"));
}

@Test(priority=3)
public void deleteUser() throws IOException {
	Response response = given()
		.baseUri("https://petstore.swagger.io/v2/user") // Set base URI
		.header("Content-Type", "application/json") // Set headers
		.pathParam("username", "nishanthir") // Add path parameter
		.when().delete("/{username}"); // Send POST request

	// Assertion
	response.then().body("code", equalTo(200));
	response.then().body("message", equalTo("nishanthir"));
}
}
