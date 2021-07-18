package stefDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


public class CalculatorSteps {

	int result;
	
	@Given("^The Calulator application is open$")
    public void the_calulator_application_is_open(){
        System.out.println("Calculator is opened");
        
    }

    @When("^I add two numbers (-?\\d+) and (-?\\d+)$")
    public void i_add_two_numbers_something_and_something(int num1, int num2){
    	 result = num1 + num2;
        
    }
    
    @When("^I multiply two numbers (-?\\d+) and (-?\\d+)$")
    public void i_multiply_two_numbers_something_and_something(int num1, int num2){
    	 result = num1 * num2;
        
    }

    @Then("^I should see result as (-?\\d+)$")
    public void i_should_see_result_as_something(int expResult) {
    	 
		/*
		 * if(result==expresult) { System.out.println("Test Passed"); } else {
		 * System.out.println("Test Failed"); }
		 */
    	 
    	 Assert.assertEquals(expResult, result);
    	 
       
    }


}
