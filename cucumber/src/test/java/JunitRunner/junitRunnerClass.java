package JunitRunner;

import org.junit.runner.RunWith;

//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = {"C:\\Users\\samiksha.dhulap\\git\\Assignment\\cucumber\\src\\test\\java\\features"}
 ,glue={"StepDefinitions"}
 )
 
public class junitRunnerClass {
 
}