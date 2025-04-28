package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrayPage {
	
	private WebDriver driver;
	
	// Locators
	@FindBy (xpath = "//input[@id = 'id_username']") WebElement Username;
	@FindBy (xpath = "//input[@id = 'id_password']") WebElement Password;
	@FindBy (xpath = "//input[@value = 'Login']") WebElement Login;
	
	@FindBy (xpath = "//a[@href='array']") WebElement getStarted_Arrays;
	@FindBy (xpath = "//a[@href ='arrays-in-python']") WebElement arrays_in_python;
	@FindBy (xpath ="//a[@href ='arrays-using-list']") WebElement arrays_using_list;
	@FindBy (xpath ="//a[@href ='basic-operations-in-lists']") WebElement basic_operations_in_lists;
	@FindBy (xpath ="//a[@href ='applications-of-array']") WebElement applications_of_array;
	@FindBy (xpath ="//a[@href='/tryEditor']") WebElement try_here;
	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']") WebElement codeEditor;
	@FindBy (id = "output")WebElement codeOutput;
	
	@FindBy (xpath = "//a[@href = '/array/practice']") WebElement practice_Questions;
	@FindBy (xpath = "//a[@href = '/question/1']") WebElement question1;
	@FindBy (xpath = "//a[@href = '/question/2']") WebElement question2;
	@FindBy (xpath = "//a[@href = '/question/3']") WebElement question3;
	@FindBy (xpath = "//a[@href = '/question/4']") WebElement question4;
	
	@FindBy (xpath = "//textarea[@tabindex='0']")WebElement question_CodeInput;
	@FindBy (xpath = "//button[text() = 'Run']") WebElement run_button;
	@FindBy (xpath = "//input[@type = 'submit']") WebElement submit_button;
	@FindBy (id = "output") WebElement question_Output;
	
	public ArrayPage(WebDriver browserDriver) {
		driver = browserDriver;
		PageFactory.initElements(driver,this);
	}
	
	public void login(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		
		Login.click();
	}
	
	public void click_getStarted_Arrays() {
		getStarted_Arrays.click();
	}
	
	public String arrayTitle() {
		return driver.getTitle();
	}
		
}
