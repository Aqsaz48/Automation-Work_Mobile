package sfa.configs;

import java.io.IOException;
import java.util.Properties;

public class Config {

	private Properties props;

	public Config() throws IOException {
		props = new Properties();
		// **since config file in resources folder so don't need to provide whole path
		props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
	}

	public String getAndroidApp() {
		return props.getProperty("androidApp");

	}

	public String getIosAPP() {

		return props.getProperty("iosApp");
	}

	public String getAndroidAutomation() {

		return props.getProperty("androidAutomationName");
	}

	public String getAndroidPackage() {

		return props.getProperty("androidAppPackage");
	}

	public String getAndroidActivity() {

		return props.getProperty("androidAppAppActivity");
	}
	public String getUrl() {

		return props.getProperty("URL");
	}
	public String emailURL() {

		return props.getProperty("EmailURL");
	}
}
