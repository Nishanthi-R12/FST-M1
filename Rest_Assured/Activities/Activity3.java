/*
 In this activity, you will create a test class that contains three test cases:

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {

	//Declare request specification
	RequestSpecification requestSpec;
	
	//Declare response specification
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		
		//Create request specification
		requestSpec = new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json") //Set content type
				.setBaseUri("https://petstore.swagger.io/v2/pet") //Set base URL
				.build(); //Build request specification
		
		responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200) //Check status code in response
				.expectContentType("application/json") //Check response content type
				.expectBody("status", equalTo("alive")) //Check if response contains name properly
				.build(); //Build response specification
	}
	
	@DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {
		
		Object[][] testData = new Object[][] {
			{77232, "Johny", "alive"},
			{77233, "Heeno", "alive"}
		};
		return testData;
	}
	
	@Test (priority = 1, dataProvider = "petInfo")
	public void addPets(int petId, String petName, String petStatus) {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		given().spec(requestSpec) //Using request spec
		.body(reqBody) //Sending request body
		.when()
			.post() //Sending post request
		.then().spec(responseSpec) //Assertions using response spec
		.body("name", equalTo(petName)); //Additional assertion
	}
	
	@Test (priority = 2, dataProvider = "petInfo")
	public void deletePets(int petId, String petName, String petStatus) {
		given().spec(requestSpec) //Using request spec
			.pathParam("petId", petId) //Add path parameter
		.when()
			.delete("/{petId}") //Send Get request
		.then()
			.body("code", equalTo(200))
			.body("message", equalTo(""+petId)); //Assertions using response spec
	}
}
