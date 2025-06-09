package testRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import com.aventstack.extentreports.service.ExtentService;
import io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/resources/Features/"},
	glue = {"stepDefinitions", "hooks"},
	
	plugin = {"pretty",
			"html:target/cucumber-firefox.html",
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"timeline:test-output-thread-firefox/"
			        },
    monochrome = true
)
public class FirefoxTestIT {
    @BeforeClass
    public static void setBrowser() {
        System.setProperty("browser", "firefox");
    }
}
