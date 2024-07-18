package sfa.extentReport;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * In this class, we created an ExtentReports object, and it can be reachable via createExtentReports() method.
 * Also, you need to set your ExtentReports report HTML file location.
 */
public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report2.html");
        try {
			reporter.loadJSONConfig(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"spark-config.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}     
      
        reporter.config().setReportName("SFA Automation");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Project:", "Demo");
        extentReports.setSystemInfo("Author:", "Demo");
        extentReports.setSystemInfo("Operating System:", System.getProperty("os.name"));
        extentReports.setSystemInfo("System User:", System.getProperty("user.name"));
        extentReports.setSystemInfo("Java Version:", System.getProperty("java.version"));
//        extentReports.setSystemInfo("Browser version:",((RemoteWebDriver)CreateDriver.getDriver()).getCapabilities().getBrowserVersion());
//        extentReports.setSystemInfo("Browser version:",((RemoteWebDriver)CreateDriver.getDriver()).getCapabilities().getBrowserName());
        return extentReports;
    }
}
