package driverFactory;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.LoggerLoad;

public class MyDriverFactory {
	
    //public static WebDriver driver;
	public static ChromeOptions chrome = new ChromeOptions();
	public static EdgeOptions edge = new EdgeOptions();
	public static FirefoxOptions firefox = new FirefoxOptions();
	
	public static ThreadLocal<WebDriver>tldriver = new ThreadLocal<>();
	
	public static WebDriver initializeBrowser(String browser) {
		System.out.println("browser value is: " +browser);
		
		if(browser.equals("chrome")) {
			LoggerLoad.info("Testing on -" +browser);
			WebDriverManager.chromedriver().setup();
			//chrome.setPageLoadStrategy(PageLoadStrategy.EAGER);
			chrome.addArguments("--headless=new");
			tldriver.set(new ChromeDriver(chrome));
		}
		else if (browser.equals("firefox")) {
			LoggerLoad.info("Testing on -" +browser);
			WebDriverManager.firefoxdriver().driverVersion("0.36.0").setup();
			//firefox.setPageLoadStrategy(PageLoadStrategy.EAGER);
			firefox.addArguments("--headless");
			tldriver.set(new FirefoxDriver(firefox));
			
	    }
		else if (browser.equals("edge")) {
			LoggerLoad.info("Testing on -" +browser);
			WebDriverManager.edgedriver().setup();
			edge.setPageLoadStrategy(PageLoadStrategy.EAGER);
			edge.addArguments("--headless=new");
			tldriver.set(new EdgeDriver(edge));
	    }
		else {
			LoggerLoad.error("Please pass the correct browser value" +browser);
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
