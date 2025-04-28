package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = null;
	private static String browserType = "chrome";

	public static void setBrowserType(String browser) {
		browserType = browser;
	}
	
	public static String getBrowserType() throws Throwable {
		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("Browser not provided in the configuration");
	}

	public static String getProperty(String key) {
		if (prop == null)
			initializeProperty();
		return prop.getProperty(key);
	}

	public static Properties initializeProperty() {

		prop = new Properties();

		try {
			FileInputStream fileInput = new FileInputStream("./src/test/resources/Config/config.properties");
			prop.load(fileInput);
			fileInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

}
