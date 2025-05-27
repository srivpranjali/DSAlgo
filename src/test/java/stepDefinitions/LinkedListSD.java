package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import driverFactory.MyDriverFactory;
import pageObjects.LinkedListPage;
import utilities.ConfigReader;

public class LinkedListSD {
	
	private ConfigReader reader = new ConfigReader();
	private WebDriver driver = MyDriverFactory.getDriver();
	private LinkedListPage llpage = new LinkedListPage(driver);

	@When("User clicks Get Started button under Linked List")
	public void user_clicks_get_started_button_under_linked_list() {
	    
	}

	@Given("User is on the Linked List page")
	public void user_is_on_the_linked_list_page() {
	    
	}

	@Given("User is on the tryEditor page of Linked List with Run button")
	public void user_is_on_the_try_editor_page_of_linked_list_with_run_button() {
	    
	}

}
