package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.MyDriverFactory;


public class Utils {
	
	WebDriver driver = MyDriverFactory.getDriver();
	
	private ConfigReader configObj = new ConfigReader();
	String xlsfile = configObj.getProperty("xlsFilePath");
	
	private XlsReader reader = new XlsReader(xlsfile);
			
	
	public void waitForElementVisible(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitForElementClickable(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
    }
	
	public void waitForTitleContains(String title) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains(title));
	}
	
	
	public String getCodefromXls(String sheetname, String testname) throws InvalidFormatException, IOException {
		Map<String, String> testdata = reader.getPythonCodeAndOutput(sheetname, testname);
		String code = testdata.get("pythonCode");
		return code;
	}
	
	public String getOutputFromXls(String sheetname, String testname) throws InvalidFormatException, IOException {
		Map<String, String> testdata = reader.getPythonCodeAndOutput(sheetname, testname);
		String result = testdata.get("output");
		return result;
	}
	
	public void enterCode(String code, WebElement element) {
		new Actions(driver).sendKeys(element, code).perform();
	}
	
	public void enterCodePractice(String code, WebElement element, WebDriver driver) throws InterruptedException {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		String[] string1 = code.split("\n");
		for (int i = 0; i < string1.length; i++) {
			if (string1[i].equalsIgnoreCase("\\b")) {
				element.sendKeys(Keys.BACK_SPACE);
			} else {
				element.sendKeys(string1[i]);
				element.sendKeys(Keys.RETURN);
			}
		}
	}

}
