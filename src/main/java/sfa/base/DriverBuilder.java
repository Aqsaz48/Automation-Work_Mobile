package sfa.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import sfa.configs.Config;
import sfa.configs.Constants;
import sfa.configs.Platforms;

// This class manages setting up and accessing the WebDriver for different platforms.

public class DriverBuilder {
    // ThreadLocal variable to hold WebDriver instance for each thread
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    // Non-thread-safe WebDriver instance
    public static WebDriver cdriver;
    
    private DriverBuilder() {
        // Private constructor to prevent instantiation of this class
    }
    
    // WebDriverWait instance for waiting for elements in the WebDriver
    public static WebDriverWait wait;
    
    // Method to get the WebDriver instance for the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Initialize the WebDriver with the given capabilities based on the platform.
     *
     * @param platformName     The name of the platform (Android, iOS, etc.)
     * @param platformVersion  The version of the platform
     * @param deviceName       The name of the device
     * @param testName         The name of the test
     * @throws IOException     If an I/O error occurs
     * @throws Exception       If the provided platformName is not available in Constants.java
     */
    public static void initializeDriver(Platforms platformName, String platformVersion, String deviceName,
            String testName) throws IOException {
        UiAutomator2Options androidCap;
        XCUITestOptions iosCap;
        Config config = new Config();
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("appiumVersion", "2.0.0");
        
        switch (platformName) {
        case ANDROID:
            // Setting up capabilities for Android platform
            androidCap = new UiAutomator2Options();
            androidCap.setPlatformName(platformName.name()).setPlatformVersion(platformVersion).setDeviceName(deviceName).setAutoGrantPermissions(true).setApp(config.getAndroidApp());
            androidCap.setCapability("unicodeKeyboard", true);
            androidCap.setCapability("resetKeyboard", true);
            
            // Setting BrowserStack capabilities
            androidCap.setCapability("project", "SFA");
            androidCap.setCapability("build", "SFA-18/07/24");
            androidCap.setCapability("bstack:options", browserstackOptions);
            androidCap.setCapability("name", testName);
            androidCap.setCapability("browserstack.debug", true);
            
            try {
                // Creating AndroidDriver instance with BrowserStack URL
                driver.set(new AndroidDriver(new URL("https://" + Constants.BS_USERNAME + ":" + Constants.BS_ACCESSKEY
                        + "@hub-cloud.browserstack.com/wd/hub"), androidCap));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            break;

        case LOCAL_ANDROID:
            // Setting up capabilities for local Android device
            androidCap = new UiAutomator2Options();
            androidCap.setPlatformVersion(platformVersion).setDeviceName(deviceName).setAppActivity(config.getAndroidActivity()).setAppPackage(config.getAndroidPackage()).setAutoGrantPermissions(true)
                    .setNoReset(false).setNewCommandTimeout(Duration.ofMinutes(2));
            androidCap.setCapability("unicodeKeyboard", true);
            androidCap.setCapability("resetKeyboard", true);
            
            try {
                // Creating AndroidDriver instance with local Appium server URL
                driver.set(new AndroidDriver(new URL("http://0.0.0.0:4723/"), androidCap));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            
            break;
            
        default:
            // Handling case where an unsupported platform is requested
            throw new RuntimeException("Wrong PlatformName");
        }
        
        // Setting implicit wait timeout for the WebDriver
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    
    // Method to create WebDriverWait instance with specified timeout
    public static WebDriverWait waitUntil(int timeOut) {
         return new WebDriverWait(DriverBuilder.getDriver(), Duration.ofSeconds(timeOut));
    }
}
