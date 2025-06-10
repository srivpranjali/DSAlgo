package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import driverFactory.MyDriverFactory;
import pageObjects.LoginPage;
import pageObjects.ArrayPage;
import pageObjects.LinkedListPage;
import pageObjects.CommonPage;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class CommonSD {
	
	private ConfigReader reader = new ConfigReader();
	private WebDriver driver = MyDriverFactory.getDriver();
	private LoginPage loginPage = new LoginPage(driver);
	private ArrayPage arrayPage = new ArrayPage(driver);
	private LinkedListPage llPage = new LinkedListPage(driver);
	private CommonPage commonPage = new CommonPage(driver);
	
	

	@Given("User is on Login Page of portal")
	public void user_is_on_login_page_of_portal() {
		loginPage.get_userOnDSAlgoHomePage();
		loginPage.click_signIn();
		LoggerLoad.info("User is on Login Page of DSAlgo portal");
		
	}

	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password() {
		
		String uname = ConfigReader.getProperty("username");
		String passwd = ConfigReader.getProperty("password");
		loginPage.login(uname, passwd);
		loginPage.click_login();
		LoggerLoad.info("User click login with valid username and password");			
	}

	@Given("User is logged in to Home Page")
	public void user_is_logged_in_to_home_page() {
		driver.get(ConfigReader.getProperty("appHome_URL"));
		LoggerLoad.info("User successfully logs in to Home Page of DSAlgo portal");

	}


	@Then("User should be redirected to the {string} page")
	public void user_should_be_redirected_to_the_page(String new_page) {
		if (new_page.equals("Array")) {
			LoggerLoad.info("User directed to Array Page");
			assertEquals(new_page, commonPage.getTitle(new_page), "Array Page Title verification failed : " );
		}
		else if (new_page.equals("Linked List")) {
			LoggerLoad.info("User directed to Linked List Page");
			assertEquals(new_page, commonPage.getTitle(new_page), "Linked List Page Title verification failed : " );
		}
	}

	@When("User clicks link from the list of topics covered {string}")
	public void user_clicks_link_from_the_list_of_topics_covered(String option_page) {
	    if ((option_page.equals("Arrays in Python")) ||
	    		(option_page.equals("Arrays Using List")) ||
	    		(option_page.equals("Basic Operations in Lists")) ||
	    		(option_page.equals("Applications of Array"))) {
	    	
	    	arrayPage.click_ArrayOptions(option_page);
	    	LoggerLoad.info("User clicked on the Page - " +option_page);
	    }
	    
	    else if ((option_page.equals("Introduction")) ||
	    		(option_page.equals("Creating Linked LIst")) ||
	    		(option_page.equals("Types of Linked List")) ||
	    		(option_page.equals("Implement Linked List in Python")) ||
	    		(option_page.equals("Traversal")) ||
	    		(option_page.equals("Insertion")) ||
	    		(option_page.equals("Deletion"))) {
	    	
	    	llPage.click_LinkedListOptions(option_page);
	    	LoggerLoad.info("User clicked on the Page - " +option_page);
	    }
	    
	}

	@Then("User should be redirected to respective page of {string}")
	public void user_should_be_redirected_to_respective_page_of(String opt_page) {
		
		if (opt_page.equals("Arrays in Python")) {
			LoggerLoad.info("User directed to Arrays in Python Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Arrays in Python Page Title verification failed :");
		}
		else if (opt_page.equals("Arrays Using List")) {
			LoggerLoad.info("User directed to Arrays Using List Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Arrays Using List Page Title verification failed :");
		}
		else if (opt_page.equals("Basic Operations in Lists")) {
			LoggerLoad.info("User directed to Basic Operations in Lists Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Basic Operations in Lists Page Title verification failed :");
		}
		else if (opt_page.equals("Applications of Array")) {
			LoggerLoad.info("User directed to Applications of Array Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Applications of Array Page Title verification failed :");
		}
		
		else if (opt_page.equals("Introduction")) {
			LoggerLoad.info("User directed to Introduction Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Introduction Page Title verification failed :");
		}
		else if (opt_page.equals("Creating Linked LIst")) {
			LoggerLoad.info("User directed to Creating Linked LIst Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Creating Linked LIst Page Title verification failed :");
		}
		else if (opt_page.equals("Types of Linked List")) {
			LoggerLoad.info("User directed to Types of Linked List Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Types of Linked List Page Title verification failed :");
		}
		else if (opt_page.equals("Implement Linked List in Python")) {
			LoggerLoad.info("User directed to Implement Linked List in Python Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Implement Linked List in Python Page Title verification failed :");
		}
		else if (opt_page.equals("Traversal")) {
			LoggerLoad.info("User directed to Traversal Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Traversal Page Title verification failed :");
		}
		else if (opt_page.equals("Insertion")) {
			LoggerLoad.info("User directed to Insertion Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Insertion Page Title verification failed :");
		}
		else if (opt_page.equals("Deletion")) {
			LoggerLoad.info("User directed to Deletion Page");
			assertEquals(opt_page, commonPage.getTitle(opt_page), "Deletion Page Title verification failed :");
		}
		
	 
	}

	@When("User clicks on Try Here button of page {string}")
	public void user_clicks_on_try_here_button_of_page(String try_page) {
		if ((try_page.equals("Arrays in Python")) ||
	    		(try_page.equals("Arrays Using List")) ||
	    		(try_page.equals("Basic Operations in Lists")) ||
	    		(try_page.equals("Applications of Array"))) {
	    	
	    	arrayPage.click_TryHere();
	    	LoggerLoad.info("User clicked on Try Here Button for Array");
	    }
	    
	    else if ((try_page.equals("Introduction")) ||
	    		(try_page.equals("Creating Linked LIst")) ||
	    		(try_page.equals("Types of Linked List")) ||
	    		(try_page.equals("Implement Linked List in Python")) ||
	    		(try_page.equals("Traversal")) ||
	    		(try_page.equals("Insertion")) ||
	    		(try_page.equals("Deletion"))) {
	    	
	    	llPage.click_TryHere();
	    	LoggerLoad.info("User clicked on Try Here Button for Linked List");
	    }
	    
	}
	
	@Then("User should be redirected to TryEditor page having Run button")
	public void user_should_be_redirected_to_try_editor_page_having_run_button() {
		LoggerLoad.info("User directed to TryEditor Page");
		assertTrue(commonPage.tryEditorRunBtn(), "Run Button is not displayed on TryEditor Page");
		LoggerLoad.info("User is on TryEditor Page with Run Button displayed");
	    
	}

	@When("User writes the valid code in editor from {string} and {string} and click Run button")
	public void user_writes_the_valid_code_in_editor_from_and_and_click_run_button(String sheetname, String testname) throws InvalidFormatException, IOException {
	    commonPage.enterCodePython(sheetname, testname);
	    commonPage.click_Run();
	    LoggerLoad.info("User enters and run valid python code in TryEditor block");
	}

	@Then("User should be able to see correct output in the console")
	public void user_should_be_able_to_see_correct_output_in_the_console() throws InvalidFormatException, IOException {
		assertEquals(commonPage.getCodeOutput("dsalgocode", "Print valid Hello"),commonPage.getEditorOutput());
		LoggerLoad.info("TryEditor block is successfully executed with correct output");
	}

	@When("User writes the invalid code in editor from {string} and {string} and click Run button")
	public void user_writes_the_invalid_code_in_editor_from_and_and_click_run_button(String sheetname, String testname) throws InvalidFormatException, IOException {
	    commonPage.enterCodePython(sheetname, testname);
	    commonPage.click_Run();
	    LoggerLoad.info("User enters and run invalid python code in TryEditor block");
	    
	}

	@Then("User should be able to see error message in alert window")
	public void user_should_be_able_to_see_error_message_in_alert_window() {
		driver.switchTo().alert().accept();
		LoggerLoad.info("Error message is displayed in alert window");
	}





}
