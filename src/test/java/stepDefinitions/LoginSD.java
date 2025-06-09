package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;

import driverFactory.MyDriverFactory;
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
		LoggerLoad.info("User is on DSAlgo Home Page");
			
	}

	@When("User clicks Sign in button")
	public void user_clicks_sign_in_button() {
		loginPage.click_signIn();
		LoggerLoad.info("User clicks SignIn button on DSAlgo Home Page");
	 
	}

	@Given("User is on DSAlgo login page")
	public void user_is_on_ds_algo_login_page() {
		loginPage.get_userOnDSAlgoHomePage();
		loginPage.click_signIn();
		LoggerLoad.info("User is on DSAlgo Login Page");
	}

	@When("User enters valid username, password and clicks Login button")
	public void user_enters_valid_username_password_and_clicks_login_button() {
	    String uname = reader.getProperty("username");
	    String passwd = reader.getProperty("password");
		loginPage.login(uname,passwd);
		LoggerLoad.info("User enters valid username and password");
		loginPage.click_login();
		LoggerLoad.info("User clicks Login button");
		
	}

	@Then("User should be redirected to DSAlgo Home Page with message {string}")
	public void user_should_be_redirected_to_ds_algo_home_page_with_message(String message) {
	    assertEquals("NumpyNinja", loginPage.homeTitle(), "DSAlgo Home Page Title verification failed : ");
	    assertEquals(message, loginPage.getMessage(), "Message Verification failed :");
	    LoggerLoad.info("User logs into DSAlgo Home Page successfully");
	    
	}

	@When("User enters invalid username, password and clicks Login button")
	public void user_enters_invalid_username_password_and_clicks_login_button() {
	    loginPage.login("abc", "abc");
	    loginPage.click_login();
	    LoggerLoad.info("User clicks Login with invalid username and invalid password");
	}

	@Then("Verify the message {string}")
	public void verify_the_message(String message) {
	    assertEquals(message, loginPage.getMessage(), "Message Verification failed :");
	    LoggerLoad.info("Login/Logout message is displayed");
	    
	}

	@When("User clicks Login button")
	public void user_clicks_login_button() {
	    loginPage.click_login();
	    LoggerLoad.info("User clicks Login button");
	}

	@Then("Verify the message {string} appears for username")
	public void verify_the_message_appears_for_username(String message) {
	    assertEquals(message, loginPage.getMessageForUsername(), "Message verification failed : ");
	    LoggerLoad.info("\"Please fill out this field\" message is displayed near username");
	}

	@When("User enters username and clicks Login button")
	public void user_enters_username_and_clicks_login_button() {
	    loginPage.login(reader.getProperty("username"), "");
	    LoggerLoad.info("User enters username only");
	    loginPage.click_login();
	    LoggerLoad.info("User clicks Login button");
	}

	@Then("Verify the message {string} appears for password")
	public void verify_the_message_appears_for_password(String message) {
		assertEquals(message, loginPage.getMessageForPassword(), "Message verification failed : ");
		LoggerLoad.info("\"Please fill out this field\" message is displayed near password");
	}

	@When("User enters password and clicks Login button")
	public void user_enters_password_and_clicks_login_button() {
		loginPage.login("",reader.getProperty("password"));
		LoggerLoad.info("User enters password only");
	    loginPage.click_login();
	    LoggerLoad.info("User clicks Login button");
	}

	@Then("User should be redirected to DSAlgo Login Page")
	public void user_should_be_redirected_to_ds_algo_login_page() {
		assertEquals("Login", loginPage.loginTitle(), "DSAlgo Login Page Title verification failed : ");
		LoggerLoad.info("User is on DSAlgo Login Page");
	}

	@When("User clicks Sign out button")
	public void user_clicks_sign_out_button() {
	    loginPage.click_signOut();
	    LoggerLoad.info("User clicks on SignOut button");
	}
	


}
