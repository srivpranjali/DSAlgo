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
import utilities.LoggerLoad;

public class LinkedListSD {
	
	private ConfigReader reader = new ConfigReader();
	private WebDriver driver = MyDriverFactory.getDriver();
	private LinkedListPage llPage = new LinkedListPage(driver);

	@When("User clicks Get Started button under Linked List")
	public void user_clicks_get_started_button_under_linked_list() {
		llPage.click_getStarted_LinkedList();
		LoggerLoad.info("User clicks Get Started button for Linked List Page");
	}

	@Given("User is on the Linked List page")
	public void user_is_on_the_linked_list_page() {
		llPage.click_getStarted_LinkedList();
		LoggerLoad.info("User is on Linked List Page");
	    
	}

	

}
