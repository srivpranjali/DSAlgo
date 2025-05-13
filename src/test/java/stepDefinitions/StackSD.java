package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.MyDriverFactory;
import utilities.ConfigReader;
import pageObjects.StackPage;
import pageObjects.ArrayPage;
import pageObjects.HomePage;

public class StackSD {

	private ConfigReader reader = new ConfigReader();
	private WebDriver driver = MyDriverFactory.getDriver();
	private StackPage stackPage = new StackPage(driver);
	private HomePage homePage = new HomePage();
	
	@Given("User is in the home page after login")
	public void user_is_in_the_home_page_after_login() {
	    
	}

	@When("User clicks Get Started button in Stack card")
	public void user_clicks_get_started_button_in_stack_card() {
		stackPage.clickGetStartedStack();
	}

	@Then("User should be directed to Stack page")
	public void user_should_be_directed_to_stack_page() {
	    Assert.assertEquals(stackPage.stackTitle(), "Stack");
	}

	@Given("User is in the Stack page")
	public void user_is_in_the_stack_page() {
		MyDriverFactory.getDriver().get(reader.getProperty("Stack URL"));
	}

	@When("User clicks link from the list of {string} in the stack page")
	public void user_clicks_link_from_the_list_of_in_the_stack_page(String string) {
	    stackPage.clickStackLinks(string);
	}

	@Then("User should be redirected to respective page of {string} in the stack page")
	public void user_should_be_redirected_to_respective_page_of_in_the_stack_page(String string) {
		Assert.assertEquals(driver.getCurrentUrl(), string);
	}

	@Given("User is on the particular page {string} in the stack module")
	public void user_is_on_the_particular_page_in_the_stack_module(String string) {
		switch(string) {
			case "Operations in Stack":
				MyDriverFactory.getDriver().get(reader.getProperty("Operations in Stack_URL"));
				break;			
			case "Implementation":
				MyDriverFactory.getDriver().get(reader.getProperty("Implementation_URL"));
				break;
			case "Applications":
				MyDriverFactory.getDriver().get(reader.getProperty("Applications_URL"));
				break;
			default:
				break;
		}
	}

	@When("User clicks on Try Here button of page {string} in the stack module")
	public void user_clicks_on_try_here_button_of_page_in_the_stack_module(String string) {
	    stackPage.clickTryHere();
	}

	@Then("User should be redirected to TryEditor page having Run button in the respective links of stack module")
	public void user_should_be_redirected_to_try_editor_page_having_run_button_in_the_respective_links_of_stack_module() {
		Assert.assertEquals(driver.getCurrentUrl(), reader.getProperty("tryEditorUrl"));
	}

	@Given("User is on the tryEditor page of operations in stack with Run button")
	public void user_is_on_the_try_editor_page_of_operations_in_stack_with_run_button() {
		MyDriverFactory.getDriver().get(reader.getProperty("tryEditorUrl"));
	}

	@When("User writes the valid python code in the editor <print stack1> and click Run button")
	public void user_writes_the_valid_python_code_in_the_editor_print_stack1_and_click_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be able to see correct output <stack1> in the console")
	public void user_should_be_able_to_see_correct_output_stack1_in_the_console() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User is again on the tryEditor page of operations in stack with Run button")
	public void user_is_again_on_the_try_editor_page_of_operations_in_stack_with_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User writes the invalid python code in the editor <print invalid1> and click Run button")
	public void user_writes_the_invalid_python_code_in_the_editor_print_invalid1_and_click_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be able to see error msg pop up in the operations in stack window")
	public void user_should_be_able_to_see_error_msg_pop_up_in_the_operations_in_stack_window() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the editor page in operations in stack with alert error message")
	public void the_user_is_on_the_editor_page_in_operations_in_stack_with_alert_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user click the ok button in the alert window of operations in stack page")
	public void the_user_click_the_ok_button_in_the_alert_window_of_operations_in_stack_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be on the same editor page of operations in stack having Editor and Run button")
	public void the_user_should_be_on_the_same_editor_page_of_operations_in_stack_having_editor_and_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User is on the tryEditor page of implementations with Run button")
	public void user_is_on_the_try_editor_page_of_implementations_with_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User writes the valid python code in the editor <print stack2> and click Run button")
	public void user_writes_the_valid_python_code_in_the_editor_print_stack2_and_click_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be able to see correct output <stack2> in the console")
	public void user_should_be_able_to_see_correct_output_stack2_in_the_console() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User is again on the tryEditor page of implementations with Run button")
	public void user_is_again_on_the_try_editor_page_of_implementations_with_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User writes the invalid python code in the editor <print invalid2> and click Run button")
	public void user_writes_the_invalid_python_code_in_the_editor_print_invalid2_and_click_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be able to see error msg pop up in the implementations window")
	public void user_should_be_able_to_see_error_msg_pop_up_in_the_implementations_window() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the editor page in implementations with alert error message")
	public void the_user_is_on_the_editor_page_in_implementations_with_alert_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user click the ok button in the alert window of implementations page")
	public void the_user_click_the_ok_button_in_the_alert_window_of_implementations_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be on the same editor page of implementations having Editor and Run button")
	public void the_user_should_be_on_the_same_editor_page_of_implementations_having_editor_and_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User is on the tryEditor page of applications with Run button")
	public void user_is_on_the_try_editor_page_of_applications_with_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User writes the valid python code in the editor <print stack3> and click Run button")
	public void user_writes_the_valid_python_code_in_the_editor_print_stack3_and_click_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be able to see correct output <stack3>in the console")
	public void user_should_be_able_to_see_correct_output_stack3_in_the_console() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User is again on the tryEditor page of applications with Run button")
	public void user_is_again_on_the_try_editor_page_of_applications_with_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User writes the invalid python code in the editor <print invalid3> and click Run button")
	public void user_writes_the_invalid_python_code_in_the_editor_print_invalid3_and_click_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be able to see error msg pop up in the applications window")
	public void user_should_be_able_to_see_error_msg_pop_up_in_the_applications_window() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is on the editor page in applications with alert error message")
	public void the_user_is_on_the_editor_page_in_applications_with_alert_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user click the ok button in the alert window of applications")
	public void the_user_click_the_ok_button_in_the_alert_window_of_applications() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be on the same editor page of applications having Editor and Run button")
	public void the_user_should_be_on_the_same_editor_page_of_applications_having_editor_and_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user is again back to the Stack page")
	public void the_user_is_again_back_to_the_stack_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks Practice Questions button in stack module")
	public void the_user_clicks_practice_questions_button_in_stack_module() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be able to see a blank page of Practice Questions in stack module")
	public void the_user_should_be_able_to_see_a_blank_page_of_practice_questions_in_stack_module() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
