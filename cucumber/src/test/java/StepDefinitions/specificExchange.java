package StepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class specificExchange {
	RequestSpecification res_spec;
	Response res;
	RequestSpecification httpRequest;
	Response response;
	String responseBody;
	
	 @Given("^Customer have API for Specific date Foreign Exchange rates$")
    public void Customer_have_API_for_specific_date_Foreign_Exchange_rates() throws Exception {
		RestAssured.baseURI = "https://api.ratesapi.io/api/2010-01-12";
		httpRequest = RestAssured.given();
	}



    @When("^Coustomer hit Specific date API$")
    public void Coustomer_hit_specific_date_API() throws Exception {
    	response = httpRequest.request(Method.GET);//print the message body of the response received from the server
    }

 

    @Then("^Status code will be ok$")
    public void status_code_will_be_ok() throws Exception {
    	//String responseBody = response.getBody().asString();
		//System.out.println("Response Body is =>  " + responseBody);
    	int code=response.getStatusCode();
    	Assert.assertEquals(code, 200);
    	System.out.println("Successful");
    }
}
