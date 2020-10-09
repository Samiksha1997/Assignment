package StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class exchangeRateIncorrect {
	RequestSpecification res_spec;
	Response res;
	RequestSpecification httpRequest;
	Response response;
	String responseBody;
	
	@Given("^Customer have provided incorrect API for Foreign Exchange rates$")
    public void Customer_have_API_for_Foreign_Exchange_rates() throws Exception {
		RestAssured.baseURI = "https://api.ratesapi.io/api/";
		httpRequest = RestAssured.given();
	}



    @When("^Coustomer hit incorrect API$")
    public void Coustomer_hit_API() throws Exception {
    	response = httpRequest.request(Method.GET);//print the message body of the response received from the server
    }

 

    @Then("^response will be bad request$")
    public void verify_ststus_code() throws Exception {
    	//String responseBody = response.getBody().asString();
		//System.out.println("Response Body is =>  " + responseBody);
    	int code=response.getStatusCode();
    	Assert.assertEquals(code, 400);
    	System.out.println("Status code : "+code);
    }
}
