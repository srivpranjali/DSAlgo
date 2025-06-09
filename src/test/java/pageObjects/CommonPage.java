package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import driverFactory.MyDriverFactory;
import utilities.ConfigReader;
import utilities.LoggerLoad;
import utilities.Utils;

public class CommonPage {
	
	private WebDriver driver;
	private ConfigReader reader = new ConfigReader();
	private Utils utils = new Utils();
	
	
	@FindBy (xpath = "//a[@href='/tryEditor']") WebElement tryHere_button;
	@FindBy (xpath="//*[@class='input']") WebElement Texteditor;
	@FindBy (xpath="//pre[@role='presentation']") WebElement Texteditor1;
	@FindBy (xpath = "//button[text()='Run']") WebElement run_button;
	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']") WebElement codeEditor;
	@FindBy (id = "output")WebElement codeOutput;
	
	public CommonPage(WebDriver browserDriver) {
		driver = browserDriver;
		PageFactory.initElements(driver,this);
	}
	
	public String getTitle(String title) {
		utils.waitForTitleContains(title);
		return driver.getTitle();
	}
	
	public boolean tryEditorRunBtn() {
		utils.waitForElementVisible(run_button);
		return run_button.isDisplayed();
				
		
	}
	
	public void click_Run() {
		utils.waitForElementClickable(run_button);
		run_button.click();
	}
	

	public String getEditorOutput() {
		return codeOutput.getText();
	}
	
	public void enterCodePython(String sheetname, String testname) throws InvalidFormatException, IOException  {
		
		String code = utils.getCodefromXls(sheetname, testname);
		utils.waitForElementVisible(codeEditor);
		this.enterCode(code, codeEditor );
	}
	
	public void enterCode(String code, WebElement element) {
         new Actions(driver).sendKeys(element, code).perform();
	}
	
	public String getCodeOutput(String sheetname, String testname) throws InvalidFormatException, IOException  {
		String result = utils.getOutputFromXls(sheetname, testname);
		return result;
	}	
	
	

}
