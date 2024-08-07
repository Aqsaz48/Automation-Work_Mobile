package sfa.listeners;


import static sfa.extentReport.ExtentTestManager.getTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;

import sfa.utils.TakeScreenShot;
public class Retry implements IRetryAnalyzer {
    private        int count  = 0;
    private static int maxTry = 1; //Run the failed test 2 times
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                     //Check if test not succeed
            if (count < maxTry) {                           //Check if maxTry count is reached
                count++;                                    //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE); //Mark test as failed and take base64Screenshot
                extendReportsFailOperations(iTestResult);   //ExtentReports fail operations
                return true;                                //Tells TestNG to re-run the test
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);     //If test passes, TestNG marks it as passed
        }
        return false;
    }
    public void extendReportsFailOperations(ITestResult iTestResult) {
        getTest().log(Status.FAIL, iTestResult.getThrowable(),
                TakeScreenShot.takeScreenshot());
    }
}
