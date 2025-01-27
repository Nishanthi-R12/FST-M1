
package restProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ProjectActivity {

		//Declare request specification
		RequestSpecification requestSpec;
		
		//Declare response specification
		ResponseSpecification responseSpec;
		
		String sshKey;
		int id;
		
		@BeforeClass
		public void setUp() {
			
			//Create request specification
			requestSpec = new RequestSpecBuilder()
					.addHeader("Content-Type", "application/json")
					.addHeader("Authorization", "token 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") //Add authorization header
					.setBaseUri("https://api.github.com") //Set base URL
					.build(); //Build request specification		
			}
		
		@Test (priority = 1)
		public void addSSHKey() {
			
			Map<String, String> reqBody = new HashMap<> ();
			reqBody.put("title", "TestAPIKey");
			reqBody.put("key", "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHRUK0aDS00Qfnp6CY1MvVtYSv4/nBIsWNLdx3XQ0Muv");
			
			Response response = given().spec(requestSpec)
					.body(reqBody)
					.when().post("/user/keys");
			response.prettyPrint();
			//Assertion
			response.then().statusCode(201);
			
			id = response.getBody().path("id");
			System.out.println("id : " + id);
			
			//response.then().body("code", equalTo(201));
			//response.then().body("sshKeyId", equalTo("id"));
		}
		
		@Test (priority = 2)
		public void getSSHKey() {
			
			Response response = given()
					.spec(requestSpec) 
					.pathParam("keyId", id) 
					.when().get("/user/keys/{keyId}");
			
			// Get response body & do assertion
				response.then().statusCode(200).log().all();
		}
		
		@Test (priority = 3)
		public void deleteSSHKey() {
			
			Response response = given()
					.spec(requestSpec)
					.pathParam("keyId", id) 
					.when().delete("/user/keys/{keyId}");
			
			response.then().statusCode(204).log().all();
		}
}
