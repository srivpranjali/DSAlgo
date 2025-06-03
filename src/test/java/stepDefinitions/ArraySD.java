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
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class ArraySD {
	
	private ConfigReader reader = new ConfigReader();
	private WebDriver driver = MyDriverFactory.getDriver();
	private ArrayPage arrayPage = new ArrayPage(driver);

	@When("User clicks Get Started button under Array")
	public void user_clicks_get_started_button_under_array() {
		arrayPage.click_getStarted_Arrays();
		LoggerLoad.info("User clicked Get Started button for Array Page");

	}
	@Given("User is on the Array page")
	public void user_is_on_the_array_page() {
	    arrayPage.get_userOnArrayPage();
	    LoggerLoad.info("User is on Array Page");
	    
	}

	@When("User clicks Array Practice Questions link")
	public void user_clicks_array_practice_questions_link() {
	   arrayPage.click_PracticeQuestions();
	}

	@Then("User is redirected to practice page having {int} links")
	public void user_is_redirected_to_practice_page_having_links(Integer int1) {
		assertEquals(driver.getCurrentUrl(),reader.getProperty("Array_Practice_Questions_URL"));
	}

	@Given("User is on Array Practice Questions page")
	public void user_is_on_array_practice_questions_page() {
		MyDriverFactory.getDriver().get(reader.getProperty("Array_Practice_Questions_URL"));
	      
	}

	@When("User clicks link from the list {string}")
	public void user_clicks_link_from_the_list(String questions) {
	    arrayPage.click_PracticeQuestionsOptions(questions);
	    
	}

	@Then("User should be redirected to {string} page having a question, tryEditor with Run and Submit buttons")
	public void user_should_be_redirected_to_page_having_a_question_try_editor_with_run_and_submit_buttons(String destinationUrl) {
		assertEquals(driver.getCurrentUrl(), destinationUrl);
	    
	}

	@Given("User is on the {string} practice editor page")
	public void user_is_on_the_practice_editor_page(String string) {
		driver.get(reader.getProperty("Search_The_Array_URL"));
	    
	}

	@When("User writes the valid code in practice editor from {string} and {int} and click Run button")
	public void user_writes_the_valid_code_in_practice_editor_from_and_and_click_run_button(String sheetname, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
	    arrayPage.enterCodePractice(sheetname, rownumber);
	    Thread.sleep(2000);
	    arrayPage.click_Run();
	}
	
	@Then("User should be able to see correct output in the practice console")
	public void user_should_be_able_to_see_correct_output_in_the_practice_console() {
	    assertEquals(arrayPage.getResult(), arrayPage.getQuestionOutput(),"The output is incorrect.");
	}
	
	@When("User writes the valid code in editor from {string} and {int} and click Submit button")
	public void user_writes_the_valid_code_in_editor_from_and_and_click_submit_button(String sheetname, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
	    arrayPage.enterCodePractice(sheetname, rownumber);
	    arrayPage.click_Submit();
	    
	}

	@Then("User should be able to see correct output on submission")
	public void user_should_be_able_to_see_correct_output_on_submission() {
		assertEquals(arrayPage.getResult(), arrayPage.getQuestionOutput(),"The output is incorrect.");
	    
	}




}
