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
import utilities.LoggerLoad;

public class ArraySD {
	
	private WebDriver driver = MyDriverFactory.getDriver();
	private ArrayPage arrayPage = new ArrayPage(driver);

	@When("User clicks Get Started button under Array")
	public void user_clicks_get_started_button_under_array() {
		arrayPage.click_getStarted_Arrays();
		LoggerLoad.info("User clicks Get Started button for Array Page");

	}
	@Given("User is on the Array page")
	public void user_is_on_the_array_page() {
	    arrayPage.click_getStarted_Arrays();
		LoggerLoad.info("User is on Array Page");
	    
	}

	@Given("User is on Array Practice Questions page")
	public void user_is_on_array_practice_questions_page() {
		arrayPage.get_userOnPracticeArrayPage();
		LoggerLoad.info("User is on Array Practice Questions page");
	      
	}

	@When("User clicks link from the list {string}")
	public void user_clicks_link_from_the_list(String questions) {
	    arrayPage.click_PracticeQuestionsOptions(questions);
	    LoggerLoad.info("User clicks Practice Question link" +questions);
	}

	@When("User writes the valid code in practice editor from {string} and {string} and click Run button")
	public void user_writes_the_valid_code_in_practice_editor_from_and_and_click_run_button(String sheetname, String testname) throws InvalidFormatException, IOException, InterruptedException {
	    arrayPage.enterCodePractice(sheetname, testname);
	    Thread.sleep(2000);
	    arrayPage.click_Run();
	    LoggerLoad.info("User enters and run python code in TryEditor block");
	}
	
	@Then("User should be able to see correct output in the practice console")
	public void user_should_be_able_to_see_correct_output_in_the_practice_console() {
	    assertEquals(arrayPage.getResult(), arrayPage.getQuestionOutput(),"The output is incorrect.");
	    LoggerLoad.info("TryEditor block is successfully executed with correct output");
	}
	
	@When("User writes the valid code in editor from {string} and {string} and click Submit button")
	public void user_writes_the_valid_code_in_editor_from_and_and_click_submit_button(String sheetname, String testname) throws InvalidFormatException, IOException, InterruptedException {
	    arrayPage.enterCodePractice(sheetname, testname);
	    arrayPage.click_Submit();
	    LoggerLoad.info("User enters and submit python code in TryEditor block");
	}

	@Then("User should be able to see correct output on submission")
	public void user_should_be_able_to_see_correct_output_on_submission() {
		assertEquals(arrayPage.getResult(), arrayPage.getQuestionOutput(),"The output is incorrect.");
		LoggerLoad.info("TryEditor block is successfully submitted with correct output");
	}
	
	@When("User clicks link {string}")
	public void user_clicks_link(String practiceQues) {
		arrayPage.click_PracticeQuestionsOptions(practiceQues);
	}
	
	
	@Then("User should be redirected to question page")
	public void user_should_be_redirected_to_question_page() {
		assertEquals(arrayPage.practiceQuestionsTitle(),"Assessment");
	}




}
