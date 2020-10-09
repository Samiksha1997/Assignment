package StepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class exchangeRateResponse {
	RequestSpecification res_spec;
	Response res;
	RequestSpecification httpRequest;
	Response response;
	String responseBody;
	
	@Given("^API for Foreign Exchange rates$")
    public void Customer_have_API_for_Foreign_Exchange_rates() throws Exception {
		RestAssured.baseURI = "https://api.ratesapi.io/api/latest";
		httpRequest = RestAssured.given();
	}



    @When("^Coustomer hit latest rate API$")
    public void Coustomer_hit_API() throws Exception {
    	response = httpRequest.request(Method.GET);//print the message body of the response received from the server
    }

 

    @Then("^verify the body as base$")
    public void verify_the_body() throws Exception {
    	//String responseBody = response.getBody().asString();
		//System.out.println("Response Body is =>  " + responseBody);
    	String responseBody = response.getBody().asString();
    	Assert.assertEquals(responseBody.contains("base") /*Expected value*/, true /*Actual Value*/, "Response body does not contain base");
    	System.out.println("Successful");
    	JsonPath j=new JsonPath(response.asString());
    	String s=j.get("base");
    	System.out.println(s);
    	Assert.assertEquals("EUR", s);
    }
}
