package sfa.hooks;

import static sfa.extentReport.ExtentTestManager.startTest;

import java.io.IOException;
import java.lang.reflect.Method;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import sfa.base.DriverBuilder;
import sfa.configs.Platforms;
import sfa.locators.LoginScreen;
import sfa.utils.JavaScriptExecute;
import sfa.utils.MobileGesture;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;


public class Hooks {
	private ExtentTest parentTest;
	protected LoginScreen loginScreen;
	
	protected MobileGesture mobileGesture;
	
	
	protected JavaScriptExecute js;
	

	//	***************************************************************
	//				From Below web panels are there
	//	***************************************************************

	@Parameters({"platform","version","device"})
	@BeforeMethod
	public void setup(Platforms platform , @Optional String version, @Optional String device, Method method) throws IOException {
		DriverBuilder.initializeDriver(platform, version, device, method.getAnnotation(Test.class).description());
		loginScreen = new LoginScreen(DriverBuilder.getDriver());
		
		if(DriverBuilder.getDriver() instanceof AndroidDriver || DriverBuilder.getDriver() instanceof IOSDriver ) {
		mobileGesture = new MobileGesture(DriverBuilder.getDriver());
		}
	
         js = new JavaScriptExecute(DriverBuilder.getDriver());

		//	***************************************************************
		//				From Below extend report classes
		//	***************************************************************
		parentTest = startTest(method.getName(), method.getAnnotation(Test.class).description());
		parentTest.assignCategory(method.getAnnotation(Test.class).groups());
		parentTest.assignCategory(DriverBuilder.getDriver().getClass().getSimpleName());
		parentTest.assignAuthor("Author");

	}

	@AfterMethod(alwaysRun = true)
	public void closeTest() {
		DriverBuilder.getDriver().quit();
		DriverBuilder.driver.remove();
	

	}
}
