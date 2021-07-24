package stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookSignUpSteps {

	WebDriver driver = BaseClass.driver;

	@Given("^User has opened Facebook application$")
	public void user_has_opened_facebook_application() {
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	@And("^User click on create new account Link$")
	public void user_click_on_create_new_account_link()  throws InterruptedException{		
		WebElement signUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signUp.click();
		Thread.sleep(2000);	
	}

	@When("^User enters \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\"$")
	public void user_enters_something_something_something_something(String firstname, String lastname, String mobileno,
			String password) throws InterruptedException {

		WebElement fName = driver.findElement(By.xpath("//input[@name='firstname']"));
		fName.sendKeys(firstname);

		WebElement lName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lName.sendKeys(lastname);

		WebElement emailID = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		emailID.sendKeys(mobileno);

		WebElement pwd = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		pwd.sendKeys(password);
		Thread.sleep(2000);	
	}

	@And("^User selects (-?\\d+) & \"([^\"]*)\" & \"([^\"]*)\"$")
	public void user_selects(int MOB, String DOB, String YOB) throws InterruptedException {

		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select mon = new Select(month);
		mon.selectByIndex(MOB);
		
		WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dbob = new Select(day);
		dbob.selectByVisibleText(DOB);

		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yea = new Select(year);
		yea.selectByValue(YOB);
		
		Thread.sleep(2000);	
	}
	
	@And("^User selects a gender$")
	public void user_selects_gender() {
		WebElement radio2 = driver.findElement(By.xpath("//*[@type ='radio' and @value ='2']"));
		radio2.click();	
	}

	@And("^User clicks on SignUp button$")
	public void user_clicks_on_signup_button() throws InterruptedException {
		WebElement sbtButton = driver.findElement(By.xpath("//button[@name='websubmit']"));
		sbtButton.click();
		Thread.sleep(2000);	
	}

	@Then("^User should be able to see the success message$")
	public void user_should_be_able_to_see_the_success_message() {

	}
	
	@And("^User creates the new account$")
    public void user_creates_the_new_account(DataTable table) throws Throwable { 	
    	//System.out.println("FirstName is " + table.cell(1, 1));
    	
    	String FirstName = table.cell(1, 1);
    	String LastName = table.cell(2, 1);
    	String MobileNum = table.cell(3, 1);
    	String Password = table.cell(4, 1);
    	String MOB = table.cell(5, 1);
    	String DOB = table.cell(6, 1);
    	String YOB = table.cell(7, 1);
    	
    	
    	WebElement tbFirstName = driver.findElement(By.xpath("//*[@name='firstname']"));
    	WebElement tbLastName = driver.findElement(By.xpath("//*[@name='lastname']"));
    	WebElement tbMobile = driver.findElement(By.xpath("//*[@name='reg_email__']"));
    	WebElement tbPassword = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
    	
    	tbFirstName.sendKeys(FirstName);
    	tbLastName.sendKeys(LastName);
    	tbMobile.sendKeys(MobileNum);
    	tbPassword.sendKeys(Password);
    	
    	WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select mon = new Select(month);
		mon.selectByVisibleText(MOB);
		
		WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dbob = new Select(day);
		dbob.selectByVisibleText(DOB);

		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yea = new Select(year);
		yea.selectByValue(YOB);
		
		Thread.sleep(2000);	

        
    }


}
