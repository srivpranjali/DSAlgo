
package hooks;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import driverFactory.MyDriverFactory;
import utilities.ConfigReader;
import io.cucumber.java.Before;


public class appHooks {
	public static WebDriver driver;
		
	@Before
	public void setup() throws Throwable {
		String browser = ConfigReader.getBrowserType();
		MyDriverFactory.initializeBrowser(browser);

		driver = MyDriverFactory.getDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}



