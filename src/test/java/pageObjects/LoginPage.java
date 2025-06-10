package pageObjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import driverFactory.MyDriverFactory;
import utilities.ConfigReader;
import utilities.Utils;

public class LoginPage {
	
	private WebDriver driver;
	private ConfigReader reader = new ConfigReader();
	private Utils utils = new Utils();
	
	
	@FindBy (xpath = "//input[@id = 'id_username']") WebElement Username;
	@FindBy (xpath = "//input[@id = 'id_password']") WebElement Password;
	@FindBy (xpath = "//input[@value = 'Login']") WebElement Login;
	
	@FindBy (xpath = "//a[@href = '/login']") WebElement SignIn;
	@FindBy (xpath = "//a[@href = '/logout']") WebElement SignOut;
	@FindBy (xpath = "//div[@role='alert']") WebElement AlertElement;
	
	
	
	public LoginPage(WebDriver browserDriver) {
		driver = browserDriver;
		PageFactory.initElements(driver,this);
	}
	
	public void get_userOnDSAlgoHomePage() {
		driver.get(reader.getProperty("appHome_URL"));
	}
	
	public void click_signIn() {
		SignIn.click();
	}
	
	public void click_login() {
		Login.click();
	}
	
	public void click_signOut() {
		SignOut.click();
	}
	
	public void login(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
	
	}
	
	public String homeTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("NumpyNinja"));
		return driver.getTitle();
	}
	
	public String loginTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Login"));
		return driver.getTitle();
	}
	
	public String getMessage() {
		return AlertElement.getText();
	}
	
	public String getMessageForUsername() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String message = (String) js.executeScript(
	            "return arguments[0].validationMessage;", Username
	        );
		return message;
	}
	
	public String getMessageForPassword() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String message = (String) js.executeScript(
	            "return arguments[0].validationMessage;", Password
	        );
		return message;
	}

	}

