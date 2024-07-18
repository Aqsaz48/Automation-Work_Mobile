package sfa.utils;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import sfa.configs.Platforms;


public class MobileGesture {
	private AppiumDriver driver;

	public MobileGesture(WebDriver driver) {
		this.driver = (AppiumDriver)driver;
	}
	public void click(WebElement element) {
		System.out.println(driver.getCapabilities().getPlatformName().name());
		if (driver.getCapabilities().getPlatformName().name()
				.equals(Platforms.ANDROID.name())) {
		driver.executeScript("mobile: clickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));}
		//else if(driver.getCapabilities().getPlatformName().name().equals(Platforms.IOS.name())) {
			Map<String, Object> caps = new HashMap<>();
			caps.put("elementId",  ((RemoteWebElement) element).getId());
			caps.put("x", 50);
			caps.put("y", 50);
			driver.executeScript("mobile: tap", caps);
			//}
	}

	public void longClick(WebElement element, int duration) {
		driver.executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", duration));
	}

	public void dragAndDrop(WebElement dragged, WebElement dropped) {
		int s = dropped.getLocation().getX();
		int s2 = dropped.getLocation().getY();
		System.out.println(s / 2 + " " + s2 / 2);
		driver.executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement) dragged).getId(),
				"endX", dropped.getLocation().getX() + 100, "endY", dropped.getLocation().getY() + 100));
	}

	public void zoomInGesture(WebElement element) {
		driver.executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));
	}

	/**
	 * Swipe gesture is different from scroll is it's opposite of scroll
	 * 
	 * @param element should be scrollable with bounding area(like choose main view)
	 * @param direction left,right,up,down
	 */
	public void swipGesture(WebElement element, String direction) {
		if (driver instanceof AndroidDriver) {
			driver.executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) element).getId(), "direction", direction, "percent", 0.75));
		} else if(driver instanceof IOSDriver) {
			Map<String, Object> caps = new HashMap<>();
			caps.put("elementId",  ((RemoteWebElement) element).getId());
			caps.put("direction", direction);
			driver.executeScript("mobile: swipe", caps);
			
		}
	}

	/**
	 * It Returns Boolean value true if screen still is scrollable use this concept
	 * in code
	 * 
	 * @param element should be scrollable with bounding area
	 * @param direction left,right,up,down
	 */
	public boolean scrollGesture(WebElement element, String direction) {
		boolean scroll = false;
		if (driver instanceof AndroidDriver) {
			System.out.println("***************************************");
		scroll = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", 0.90));
		}
		 else if(driver instanceof IOSDriver) {	 
			    Map<String, Object> caps = new HashMap<>();
				caps.put("elementId",  ((RemoteWebElement) element).getId());
				caps.put("direction", direction);
				driver.executeScript("mobile: scroll", caps);
		 }
		return scroll;
	
	}
}
