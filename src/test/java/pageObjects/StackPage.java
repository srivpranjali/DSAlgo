package pageObjects;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utils;


public class StackPage {
	
	private WebDriver driver;
	Utils utils = new Utils();
	
	// Link locators
	@FindBy (xpath = "//a[@href='stack']") WebElement getStartedStack;
	@FindBy (xpath = "//a[@href ='operations-in-stack']") WebElement operationsInStackLink;
	@FindBy (xpath ="//a[@href ='implementation']") WebElement implementationLink;
	@FindBy (xpath ="//a[@href ='stack-applications']") WebElement stackApplicationsLink;
	@FindBy (xpath ="//a[@href ='/stack/practice']") WebElement practiceQuestionsLink;
	
	// Try editor locators
	@FindBy (xpath ="//a[@href='/tryEditor']") WebElement tryHereButton;
	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']") WebElement codeEditor;
	@FindBy (id = "output") WebElement codeOutput;
	@FindBy (xpath = "//textarea[@tabindex='0']")WebElement codeInputTextArea;
	@FindBy (xpath = "//button[text() = 'Run']") WebElement runButton;
	@FindBy (xpath = "//input[@type = 'submit']") WebElement submitButton;


	public StackPage(WebDriver browserDriver) {
		driver = browserDriver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickGetStartedStack() {
		getStartedStack.click();
	}

	public String stackTitle() {
		return driver.getTitle();
	}
		
	public void clickStackLinks(String linkText) {
		switch(linkText) {
			case "Operations in Stack":
				operationsInStackLink.click(); break;
			case "Implementation":
				implementationLink.click(); break;
			case "Applications":
				stackApplicationsLink.click(); break;
			case "Practice Questions":
				practiceQuestionsLink.click(); break;
			default:
				break;
		}
	}
	
	public void clickTryHere() {
		tryHereButton.click();
	}
	
	public void clickPracticeQuestions() {
		practiceQuestionsLink.click();
	}
	
	public String practiceQuestionsTitle() {
		return driver.getTitle();
	}
	
	public void clickRun() {
		runButton.click();
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
	
	public String getEditorOutput() {
		return codeOutput.getText();
	}
	
	public String getQuestionOutput() {
		return codeOutput.getText();
	}
	public String getResult() {
		utils.waitForElement(codeOutput);
		return codeOutput.getText();
	}
	
	public void enterCodePython(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		Utils utils = new Utils();
		String code = utils.getCodefromXls(sheetname, rownumber);
		this.enterCode(code, codeEditor);
	}
	
	public void enterCode(String code, WebElement element) {
         new Actions(driver).sendKeys(element, code).perform();
	}
	
	public String getCodeOutput(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		String result = utils.getOutputFromXls(sheetname, rownumber);
		return result;
	}	
	
	public void enterCodePractice(String sheetname, int rownumber) throws InvalidFormatException, IOException, InterruptedException {
		String code = utils.getCodefromXls(sheetname, rownumber);
		utils.enterCodePractice(code, codeInputTextArea, driver);
	}
	
	public String getQuestionOutput(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		Utils utils = new Utils();
		String result = utils.getOutputFromXls(sheetname, rownumber);
		return result;
	}
}
