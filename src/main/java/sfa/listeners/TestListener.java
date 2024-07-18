package sfa.listeners;

import com.aventstack.extentreports.Status;

import sfa.base.DriverBuilder;
import sfa.extentReport.ExtentManager;
import sfa.logs.Log;
import sfa.utils.TakeScreenShot;
import sfa.utils.UtilityClass;

import static sfa.extentReport.ExtentTestManager.getTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		Log.info("I am in onStart method " + iTestContext.getName());
		
		iTestContext.setAttribute("WebDriver", DriverBuilder.getDriver());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		Log.info("I am in onFinish method " + iTestContext.getName());
		// Do tier down operations for ExtentReports reporting!
		ExtentManager.extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		Log.info(getTestMethodName(iTestResult) + " test is starting.");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
//		UtilityClass.js.executeScript(
//				"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Results found!\"}}");
		Log.info(getTestMethodName(iTestResult) + " test is succeed.");
		getTest().log(Status.PASS, "Test passed",
				TakeScreenShot.takeScreenshot());

	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
//		UtilityClass.js.executeScript(
//				"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"check logs \"}}");
	Log.info(getTestMethodName(iTestResult) + " test is failed.");
		getTest().log(Status.FAIL, iTestResult.getThrowable(),
				TakeScreenShot.takeScreenshot());

	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		Log.info(getTestMethodName(iTestResult) + " test is skipped.");
		getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
}
