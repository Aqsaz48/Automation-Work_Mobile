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

public class LoginTC_Arabic extends Hooks {


	@Test(testName = "TC_001")
	public void loginEmailPwdTest_Ar() throws Throwable {
		loginScreen.switchArabicLanguage();
		loginScreen.continueBtnHomePage_Ar();
		loginScreen.skipBtnHomePage_Ar();
		loginScreen.profileFooterBtn_Ar();
		loginScreen.loginFunctionality_Ar();

	}
	
	@Test(testName = "TC_002")
	public void discoverPageNavigatetion_Ar() throws Throwable {
		
		loginScreen.switchArabicLanguage();
		loginScreen.continueBtnHomePage_Ar();
		loginScreen.skipBtnHomePage_Ar();
		loginScreen.discoverFooterBtn_Ar();
	}	
}
