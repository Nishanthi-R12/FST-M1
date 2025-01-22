/*
 One test case for sending a POST request on https://petstore.swagger.io/v2/pet
One test case for sending a GET request on https://petstore.swagger.io/v2/pet/{petId}
One test case for sending a DELETE request on https://petstore.swagger.io/v2/pet/{petId}
The test cases must execute in the order:
POST request -> GET request -> DELETE request.
 */

package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Activity1 {
	
	@Test(priority = 1)
	public void addNewPet() {
		Map<String, Object> reqBody = new HashMap<> ();
		reqBody.put("id", 50151);
		reqBody.put("name", "Joe"); 
		reqBody.put("status", "alive");
		
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/pet") //Setting up base URI
				.header("Content-Type", "application/json") //Setting header
				.body(reqBody) //Adding request body
				.when().post(); //Sending POST request
		
		response.then().body("id", equalTo(50151));
		response.then().body("name", equalTo("Joe"));
		response.then().body("status", equalTo("alive"));
	}
	
	@Test(priority = 2)
	public void getPetInfo() {
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/pet") //Setting up base URI
				.header("Content-Type", "application/json") //Setting header
				.when().pathParam("petId", 50151) //Setting path parameter
				.get("/{petId}"); //Send GET request
		
		//Assertion
		response.then().body("id", equalTo(50151));
		response.then().body("name", equalTo("Joe"));
		response.then().body("status", equalTo("alive"));
	}
	
	@Test(priority = 3)
	public void deletePet() {
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/pet") //Setting up base URI
				.header("Content-Type", "application/json") //Setting header
				.pathParam("petId", 50151) //Set path parameter
				.when()
				.delete("/{petId}"); //Sending DELETE request
		
		response.prettyPrint();
		//Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("50151"));
	}
}
