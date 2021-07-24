package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		monochrome=true,
		plugin={"pretty"},//,"html:target/cucumber.html"},
		features = "src/test/java/features",
		tags = {"@DataTable"}, // For Running both these tags
		//tags = {"@NegativeLogin","@Sanity"},		// For Running scenarios having both of these tags must
		//tags = {"@FbSignUp","~@NegativeLoging"},		// For Running scenarios having both of these tags must
		glue = {"stepDefs"}
)

public class TestRunner {

}
