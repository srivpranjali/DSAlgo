
package hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import driverFactory.MyDriverFactory;
import utilities.ConfigReader;
import utilities.LoggerLoad;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class appHooks {
	public static WebDriver driver;
		
	@Before
	public void setup() throws Throwable {
		LoggerLoad.info("Execution Started");
		LoggerLoad.info("Loading the Property File");
		String browser = ConfigReader.getBrowserType();
		MyDriverFactory.initializeBrowser(browser);

		driver = MyDriverFactory.getDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@After
	public void tearDown(Scenario scenario) throws Throwable {

		String scenarioName = scenario.getName().replaceAll(" ", "_");

		if (scenario.isFailed()) {
			LoggerLoad.debug("Scenario is failed and taking Screentshot");
			//System.out.println("Scenario is Failed and taking Screenshot");

			byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenarioName);

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File("target/screenshots/" + scenario.getName() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Thread.sleep(3000);
		
		MyDriverFactory.quitDriver();
	}

}



