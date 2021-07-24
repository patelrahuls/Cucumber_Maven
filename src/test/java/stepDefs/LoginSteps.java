package stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginSteps{
	
	WebDriver driver = BaseClass.driver;

	@Given("^User has opened the Simplilearn application$")
	public void user_has_opened_the_simplilearn_application() {

		driver.get("https://www.Simplilearn.com");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@And("^User click on the Login Link$")
	public void user_click_Login_link() {

		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();

	}

	@When("^User enters correct username \"([^\"]*)\"$")
	public void user_enters_correct_username_something(String username) {
		
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys(username);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userName));

	}

	@Then("^User should be landed on the home Page$")
	public void user_should_be_landed_on_the_home_page() {
		
		WebElement LoginHeading = driver.findElement(By.xpath("//*[@class='content-heading ']"));
		
		String actualHeading = LoginHeading.getText();

		String expHeading = "Welcome back!";

		Assert.assertEquals(expHeading, actualHeading);

	}

	@And("^User enters correct password \"([^\"]*)\"$")
	public void user_enters_correct_password_something(String password) throws InterruptedException {

		WebElement pwd = driver.findElement(By.name("user_pwd"));
		pwd.sendKeys(password);

		WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();

		Thread.sleep(2000);

	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() {
		WebElement submitForm = driver.findElement(By.name("btn_login"));
		submitForm.click();

	}

	@And("^User should be able to see the welcome message$")
	public void user_should_be_able_to_see_the_welcome_message() {

		WebElement error = driver.findElement(By.id("msg_box"));

		String actualMsg = error.getText();

		String ClassName = error.getAttribute("class");
		String tagName = error.getTagName();

		System.out.println("Class Name is: " + ClassName);
		System.out.println("Tag Name is: " + tagName);

		String expectedMsg = "The email or password you have entered is invalid.";

		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Test case Passed");
		} else {
			System.out.println("Test case Failed");
		}

		driver.close();

	}

}
