package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import driverFactory.MyDriverFactory;
import pageObjects.ArrayPage;
import pageObjects.LoginPage;
import utilities.ConfigReader;
import utilities.LoggerLoad;


public class LoginSD {
	
	private ConfigReader reader = new ConfigReader();
	private WebDriver driver = MyDriverFactory.getDriver();
	private LoginPage loginPage = new LoginPage(driver);
	
	@Given("User is on DSAlgo Home page")
	public void user_is_on_ds_algo_home_page() {
		loginPage.get_userOnDSAlgoHomePage();
			
	}

	@When("User clicks Sign in button")
	public void user_clicks_sign_in_button() {
		loginPage.click_signIn();
	 
	}

	@Given("User is on DSAlgo login page")
	public void user_is_on_ds_algo_login_page() {
		loginPage.get_userOnDSAlgoHomePage();
		loginPage.click_signIn();
	}

	@When("User enters valid username, password and clicks Login button")
	public void user_enters_valid_username_password_and_clicks_login_button() {
	    String uname = reader.getProperty("username");
	    String passwd = reader.getProperty("password");
		loginPage.login(uname,passwd);
		loginPage.click_login();
	}

	@Then("User should be redirected to DSAlgo Home Page with message {string}")
	public void user_should_be_redirected_to_ds_algo_home_page_with_message(String message) {
	    assertEquals("NumpyNinja", loginPage.homeTitle(), "DSAlgo Home Page Title verification failed : ");
	    assertEquals(message, loginPage.getMessage(), "Message Verification failed :");
	    
	}

	@When("User enters invalid username, password and clicks Login button")
	public void user_enters_invalid_username_password_and_clicks_login_button() {
	    loginPage.login("abc", "abc");
	    loginPage.click_login();
	}

	@Then("Verify the message {string}")
	public void verify_the_message(String message) {
	    assertEquals(message, loginPage.getMessage(), "Message Verification failed :");
	    
	}

	@When("User clicks Login button")
	public void user_clicks_login_button() {
	    loginPage.click_login();
	}

	@Then("Verify the message {string} appears for username")
	public void verify_the_message_appears_for_username(String message) {
	    assertEquals(message, loginPage.getMessage(), "Message verification failed : ");
	}

	@When("User enters username and clicks Login button")
	public void user_enters_username_and_clicks_login_button() {
	    loginPage.login(reader.getProperty("username"), "");
	    loginPage.click_login();
	}

	@Then("Verify the message {string} appears for password")
	public void verify_the_message_appears_for_password(String message) {
		assertEquals(message, loginPage.getMessage(), "Message verification failed : ");
	}

	@When("User enters password and clicks Login button")
	public void user_enters_password_and_clicks_login_button() {
		loginPage.login("",reader.getProperty("password"));
	    loginPage.click_login();
	}

	@Then("User should be redirected to DSAlgo Login Page")
	public void user_should_be_redirected_to_ds_algo_login_page() {
		assertEquals("Login", loginPage.loginTitle(), "DSAlgo Login Page Title verification failed : ");
	}

	@When("User clicks Sign out button")
	public void user_clicks_sign_out_button() {
	    loginPage.click_signOut();
	}
	


}
