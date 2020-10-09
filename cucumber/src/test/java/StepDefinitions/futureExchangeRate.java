package StepDefinitions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class futureExchangeRate {
	RequestSpecification res_spec;
	Response res;
	RequestSpecification httpRequest;
	Response response;
	String responseBody;
	
	@Given("^Customer have API for future date Foreign Exchange rate$")
    public void Customer_have_API_for_Foreign_Exchange_rates() throws Exception {
		RestAssured.baseURI = "https://api.ratesapi.io/api/2020-11-12";
		httpRequest = RestAssured.given();
	}



    @When("^Coustomer hit Specific date Exchange rate API for future date$")
    public void Coustomer_hit_API() throws Exception {
    	response = httpRequest.request(Method.GET);//print the message body of the response received from the server
    }

 

    @Then("^verify date for specific date exchange rate API$")
    public void verify_the_body() throws Exception {
    	
    	LocalDate today=LocalDate.now();
    	System.out.println("Todays date : "+today);
    	
    	//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    	//String strDate = dateFormat.format(today);
    	String strDate=today.toString();

    	
    	JsonPath j=new JsonPath(response.asString());
    	String s=j.get("date");
    	
    	Assert.assertNotSame(s, strDate);
    }
}
