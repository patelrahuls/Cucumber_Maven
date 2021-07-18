package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/features",
		tags = {"@NegativeLogin"},
		glue = {"stepDefs"}
)

public class TestRunner {
	

}
