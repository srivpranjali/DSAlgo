package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriverFactory {
	
    public static WebDriver driver;
	
	public static ThreadLocal<WebDriver>tldriver = new ThreadLocal<>();
	
	public static WebDriver initializeBrowser(String browser) {
		System.out.println("browser value is: " +browser);
		
		if(browser.equals("chrome")) {
			tldriver.set(new ChromeDriver());
		}
		else if (browser.equals("firefox")) {
			tldriver.set(new FirefoxDriver());
	    }
		else if (browser.equals("edge")) {
			tldriver.set(new EdgeDriver());
	    }
		else {
			System.out.println("Please pass the correct browser value: " +browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getDriver();

    }
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	public static void quitDriver() throws Throwable {
		if (tldriver.get() != null) {
			tldriver.get().quit();
			tldriver.remove();
		}
	}

}
