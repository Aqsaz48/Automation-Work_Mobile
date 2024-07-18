package sfa.utils;

import static sfa.base.DriverBuilder.driver;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import sfa.base.DriverBuilder;

public class UtilityClass {

	// public static Logger log = LoggerHelper.getLogger(UtilityClass.class);
	// public static UtilityClass utilityClass = new UtilityClass();
	public static String dateToSelect;
	Actions act = new Actions(DriverBuilder.getDriver());
	public static WebDriverWait wait = new WebDriverWait(DriverBuilder.getDriver(), Duration.ofSeconds(20));
	public static JavascriptExecutor js = (JavascriptExecutor) DriverBuilder.getDriver();

	public static void verifyText(WebElement ele, String expectedTxtMSg) {

		System.out.println("Verifying text message");
		UtilityClass.waitForElement(ele);
		String actualTxtMsg = ele.getText();
		Assert.assertEquals(actualTxtMsg, expectedTxtMSg);
	}

	public static void verifyTitle(String expectedTitleText) {

		System.out.println("Verifying title message");
		String actualTitleText = DriverBuilder.getDriver().getTitle();
		System.out.println("actualTitleText Value of Title is -----> " + actualTitleText);
		System.out.println("expectedTitleText Value of Title is -----> " + expectedTitleText);
		Assert.assertEquals(actualTitleText, expectedTitleText);
	}

//***************************************************************************************
//							Notification Handler Code
//***************************************************************************************

	public static void notificationHandler(List<WebElement> ele, String str) throws Throwable {
		int ddSize = ele.size();
		// log.info("Inside Notification");
		for (int i = 0; i < ddSize; i++) {
			// log.info(">-------->Notifications Available in the list :>--------> " +
			// ele.get(i).getText());
			Thread.sleep(1000);
			if (ele.get(i).getText().endsWith(str)) {
				String str1 = ele.get(i).getText();
				System.out.println("Value of Notification is: " + str1);
				break;
			}
		}
		// log.info("==============================================================================");
		System.out.println("Task name" + str + "not available in Notification list");
		// log.info("==============================================================================");

	}

//***************************************************************************************
//							Dropdown Code
//***************************************************************************************

	public void dropDownHandle(List<WebElement> ele, String str) throws Throwable {
		int ddSize = ele.size();

		for (int i = 0; i < ddSize; i++) {
			// log.info("Values available on dropdown are: "+ele.get(i).getText());
			Thread.sleep(1000);
			if (ele.get(i).getText().equalsIgnoreCase(str)) {
				// log.info("Clicking on dropdown value: " + ele.get(i).getText());
				ele.get(i).click();
				break;
			}
		}
	}

//***************************************************************************************
//						Search Code
//***************************************************************************************

	public void searchHandle(List<WebElement> ele, String str) throws Throwable {
		int ddSize = ele.size();

		for (int i = 0; i < ddSize; i++) {
			// log.info("Values available on search results are: " + ele.get(i).getText());
			Thread.sleep(1000);
		}
	}

//***************************************************************************************
//						Time selection Code
//***************************************************************************************
	public static void selectTime() throws Throwable {
		final DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.HOUR, 0);
		c.add(Calendar.MINUTE, 3);
		Date currentDatePlusOne = c.getTime();
		String extendedTime = dateFormat.format(currentDatePlusOne);
		// System.out.println(dateFormat.format(currentDatePlusOne));
		System.out.println("Entering time to extended time: " + extendedTime);
		Thread.sleep(1000);
		// CreateTaskPage.selectTime.clear();
		Thread.sleep(1000);
		// CreateTaskPage.selectTime.sendKeys(extendedTime);
	}

//***************************************************************************************
//						Calendar Code
//***************************************************************************************
	private static String getCurrentDay() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 0);
		Date tomorrow = calendar.getTime();
		// SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
		// String strDate = formatter.format(tomorrow);

		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		String strDate = formatter.format(tomorrow);

		// log.info("Please see the date and format: " + strDate);

		return strDate;
	}

//	public static void calanderControl() throws Throwable {
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		dateToSelect = getCurrentDay();
//		//log.info("Date to Select Value is: " + dateToSelect);
//		Thread.sleep(2000);
//
//		WebElement tableBody = CreateTaskPage.datePicker;
//		List<WebElement> columns = tableBody.findElements(By.tagName("td"));
//		//log.info("columns are" + columns);
//
//		int size = columns.size();
//		//log.info("size of table" + size);
//		int i = Integer.parseInt(dateToSelect) + 3;
//		//log.info("Value of j" + i);
//
//		// //log.info("Reached at foreach loop");
//
//		WebElement eachCell = driver.findElement(By.xpath("((//table/tbody)[2])/tr/td"));
//		String tabIndex = eachCell.getAttribute("tabindex");
//		System.out.println("Value of Tab index is: " + tabIndex);
//		String ariaDisabled = eachCell.getAttribute("aria-disabled");
//		System.out.println("Value of aria disabeld is: " + ariaDisabled);
//
//		CreateTaskPage.currentDate.click();
//		System.out.println("Clicking on Todays date");
//	}

//##################################################################################################################################################
//In case if above code don't work change the "i" in below can and uncomment it. Value of i will be index of active first date in calendar.	
//##################################################################################################################################################	
	/*
	 * public static void calanderControl() throws Throwable {
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); dateToSelect
	 * = getCurrentDay(); //log.info("Date to Select Value is: "+dateToSelect);
	 * Thread.sleep(2000);
	 * 
	 * WebElement tableBody = CreateTaskPage.datePicker; List<WebElement> columns =
	 * tableBody.findElements(By.tagName("td")); //log.info("columns are" +columns);
	 * 
	 * int size = columns.size(); //log.info("size of table" +size); int i =
	 * Integer.parseInt(dateToSelect)+3; //log.info("Value of i" +i);
	 * 
	 * //log.info("Reached at foreach loop");
	 * 
	 * driver.findElement(By.xpath("(((//table/tbody)[2])/tr/td)["+i+"]")).click();
	 * //CreateTaskPage.dueDateDoneBtn.click(); }
	 */

//***************************************************************************************
//							Current Status Code
//***************************************************************************************

	public static void verifyCurrentStatus(WebElement ele) {
		String currentStatus = ele.getText();
		// log.info("Value of current status is: " + currentStatus);
	}

//***************************************************************************************
//							Button click Code
//***************************************************************************************
	public static void clickButton(WebElement ele) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			// log.info("Clicking on --->" + ele.getText() + " Button");
			ele.click();

		} catch (Exception e) {
			e.printStackTrace();
			// log.info(e.getMessage());
		}
	}

//***************************************************************************************
//								Wait for Element Code
//***************************************************************************************

	public static void waitForElement(WebElement ele) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			// log.info("wait for element ele value" + ele);
		} catch (Exception e) {
			e.printStackTrace();
			// log.info(e.getMessage());
			System.out.println("Element doesn't exist verify it...!!!");
		}
	}

//***************************************************************************************
//									Toast message Code
//***************************************************************************************

	public static void verifyValidation(WebElement ele, String expectedToastMSg) {

		System.out.println("Verifyingtext");
		UtilityClass.waitForElement(ele);
		String toastMsgTxt = ele.getText();
		// log.info("**********************************************");
		// log.info("Toast message is----> " + toastMsgTxt);
		// log.info("**********************************************");
		// log.info("Validating toast message");
		Assert.assertEquals(toastMsgTxt, expectedToastMSg);
	}

	public static void scrollToElement() {

		js.executeScript("javascript:window.scrollBy(250,350)");
	}

	public static void clickJsElement(WebElement ele) {
		js.executeScript("arguments[0].click()", ele);
	}

	public static void androidKeyboard(String text) {
		Iterator<String> numbersList = Arrays.asList(text.split("")).iterator();
		AndroidDriver driver = (AndroidDriver) DriverBuilder.getDriver();
		while (numbersList.hasNext()) {
			String letter = numbersList.next();
			switch (letter) {
			case "A":
			case "a":
				driver.pressKey(new KeyEvent(AndroidKey.A));
				break;
			case "B":
			case "b":
				driver.pressKey(new KeyEvent(AndroidKey.B));
				break;
			case "C":
			case "c":
				driver.pressKey(new KeyEvent(AndroidKey.C));
				break;
			case "D":
			case "d":
				driver.pressKey(new KeyEvent(AndroidKey.D));
				break;
			case "E":
			case "e":
				driver.pressKey(new KeyEvent(AndroidKey.E));
				break;
			case "F":
			case "f":
				driver.pressKey(new KeyEvent(AndroidKey.F));
				break;
			case "G":
			case "g":
				driver.pressKey(new KeyEvent(AndroidKey.G));
				break;
			case "H":
			case "h":
				driver.pressKey(new KeyEvent(AndroidKey.H));
				break;
			case "I":
			case "i":
				driver.pressKey(new KeyEvent(AndroidKey.I));
				break;
			case "J":
			case "j":
				driver.pressKey(new KeyEvent(AndroidKey.J));
				break;
			case "K":
			case "k":
				driver.pressKey(new KeyEvent(AndroidKey.K));
				break;
			case "L":
			case "l":
				driver.pressKey(new KeyEvent(AndroidKey.L));
				break;
			case "M":
			case "m":
				driver.pressKey(new KeyEvent(AndroidKey.M));
				break;
			case "N":
			case "n":
				driver.pressKey(new KeyEvent(AndroidKey.N));
				break;
			case "O":
			case "o":
				driver.pressKey(new KeyEvent(AndroidKey.O));
				break;
			case "P":
			case "p":
				driver.pressKey(new KeyEvent(AndroidKey.P));
				break;
			case "Q":
			case "q":
				driver.pressKey(new KeyEvent(AndroidKey.Q));
				break;
			case "R":
			case "r":
				driver.pressKey(new KeyEvent(AndroidKey.R));
				break;
			case "S":
			case "s":
				driver.pressKey(new KeyEvent(AndroidKey.S));
				break;
			case "T":
			case "t":
				driver.pressKey(new KeyEvent(AndroidKey.T));
				break;
			case "U":
			case "u":
				driver.pressKey(new KeyEvent(AndroidKey.U));
				break;
			case "V":
			case "v":
				driver.pressKey(new KeyEvent(AndroidKey.V));
				break;
			case "W":
			case "w":
				driver.pressKey(new KeyEvent(AndroidKey.W));
				break;
			case "X":
			case "x":
				driver.pressKey(new KeyEvent(AndroidKey.X));
				break;
			case "Y":
			case "y":
				driver.pressKey(new KeyEvent(AndroidKey.Y));
				break;
			case "Z":
			case "z":
				driver.pressKey(new KeyEvent(AndroidKey.Z));
				break;
			case "1":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
				break;
			case "2":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
				break;
			case "3":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
				break;
			case "4":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
				break;
			case "5":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
				break;
			case "6":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
				break;
			case "7":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
				break;
			case "8":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
				break;
			case "9":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
				break;
			case "0":
				driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
				break;
			case ".":
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_DOT));
				break;
			case " ":
				driver.pressKey(new KeyEvent(AndroidKey.SPACE));
				break;
			default:
				throw new IllegalArgumentException("Unsupported key: " + letter);
			}
		}
	}
}