package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		monochrome=true,
		plugin={"pretty"},//,"html:target/cucumber.html"},
		features = "src/features",
		//tags = {"@NegativeLogin,@PositiveLogin"}, // For Running both these tags
		//tags = {"@NegativeLogin","@Sanity"},		// For Running scenarios having both of these tags must
		tags = {"@Sanity","~@NegativeLoging"},		// For Running scenarios having both of these tags must
		glue = {"stepDefs"}
)

public class TestRunner {

}
