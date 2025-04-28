package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import driverFactory.MyDriverFactory;
import pageObjects.ArrayPage;
import utilities.ConfigReader;

public class ArraySD {
	
	private ConfigReader reader = new ConfigReader();
	private WebDriver driver = MyDriverFactory.getDriver();
	private ArrayPage arrayPage = new ArrayPage(driver);
	

	@Given("User is on Login Page of portal")
	public void user_is_on_login_page_of_portal() {
		driver.get(reader.getProperty("login_URL"));
		
	}

	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password() {
		
		String uname = reader.getProperty("username");
		String passwd = reader.getProperty("password");
		arrayPage.login(uname, passwd);
			
	}

	@Then("User is redirected to Home Page")
	public void user_is_redirected_to_home_page() {
		driver.get(reader.getProperty("appHome_URL"));

	}

	@Given("User is logged in to Home Page")
	public void user_is_logged_in_to_home_page() {

	}

	@When("User clicks Get Started button under Array")
	public void user_clicks_get_started_button_under_array() {
		arrayPage.click_getStarted_Arrays();

	}

	@Then("User should be redirected to the {string} page")
	public void user_should_be_redirected_to_the_page(String expectedArrayPageURL) {
		String arrayPageURL = arrayPage.arrayTitle();
		Assert.assertEquals(expectedArrayPageURL, arrayPageURL);

	}




}
