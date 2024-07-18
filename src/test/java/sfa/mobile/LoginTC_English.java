package sfa.mobile;

import static sfa.extentReport.ExtentTestManager.getTest;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import sfa.configs.Constants;
import sfa.configs.RandomText;
import sfa.hooks.Hooks;
import sfa.utils.TakeScreenShot;

// This class contains test cases related to the login functionality in the mobile application.

public class LoginTC_English extends Hooks {

    // Test case for logging in with email and password
    @Test(testName = "TC_001")
    public void loginEmailPwdTest() throws Throwable {
        loginScreen.continueBtnHomePage(); // Clicking continue button on home page
        loginScreen.skipBtnHomePage(); // Skipping button on home page
        loginScreen.profileFooterBtn(); // Clicking profile footer button
        loginScreen.loginFunctionality(); // Executing login functionality
    }
    
    // Test case for group functionality
    @Test(testName = "TC_002")
    public void groupFunctionality() throws Throwable {
        loginScreen.continueBtnHomePage(); // Clicking continue button on home page
        loginScreen.skipBtnHomePage(); // Skipping button on home page
        loginScreen.groupsFooterBtn(); // Clicking groups footer button
        loginScreen.clickCsgGuideBookSearchBox(); // Clicking search box in CSG guide book
    }
    
    // Test case for discovering functionality related to Cricket
    @Test(testName = "TC_003")
    public void discoverFunctionalityCricket() throws Throwable {
        loginScreen.continueBtnHomePage(); // Clicking continue button on home page
        loginScreen.skipBtnHomePage(); // Skipping button on home page
        loginScreen.discoverFooterBtn(); // Clicking discover footer button
        loginScreen.discoverSearchTxtBox("Cricket"); // Performing search for Cricket
    }
    
    // Test case for discovering functionality related to Football
    @Test(testName = "TC_004")
    public void discoverFunctionalityFootBall() throws Throwable {
        loginScreen.continueBtnHomePage(); // Clicking continue button on home page
        loginScreen.skipBtnHomePage(); // Skipping button on home page
        loginScreen.discoverFooterBtn(); // Clicking discover footer button
        loginScreen.discoverSearchTxtBox("Football"); // Performing search for Football
    }
}
