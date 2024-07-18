package sfa.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

import sfa.base.DriverBuilder;


public class TakeScreenShot {

	
	public static Media takeScreenshot() {
		
		return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)DriverBuilder.getDriver()).getScreenshotAs(OutputType.BASE64)).build();
		
		
		
	}
}
