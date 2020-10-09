package StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class specificExchangeResponse {
	RequestSpecification res_spec;
	Response res;
	RequestSpecification httpRequest;
	Response response;
	String responseBody;
	
	@Given("^Customer have API for Specific date Foreign Exchange rate$")
    public void Customer_have_API_for_Foreign_Exchange_rates() throws Exception {
		RestAssured.baseURI = "https://api.ratesapi.io/api/2010-01-12";
		httpRequest = RestAssured.given();
	}



    @When("^Coustomer hit Specific date Exchange rate API$")
    public void Coustomer_hit_API() throws Exception {
    	response = httpRequest.request(Method.GET);//print the message body of the response received from the server
    }

 

    @Then("^verify response for specific date exchange rate API$")
    public void verify_the_body() throws Exception {
    	String responseBody = response.getBody().asString();
    	Assert.assertEquals(responseBody.contains("base") /*Expected value*/, true /*Actual Value*/, "Response body does not contain base");
    	System.out.println("Successful");
    	JsonPath j=new JsonPath(response.asString());
    	String s=j.get("base");
    	System.out.println(s);
    	Assert.assertEquals("EUR", s);
    }
}
