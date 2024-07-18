package sfa.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import sfa.configs.Constants;

public class LoginScreen {

	private WebDriver driver;

	public LoginScreen(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	//Finding elements

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	private WebElement continueBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='استمرار']")
	private WebElement continueBtn_Ar;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
	private WebElement skipBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='تخطي']")
	private WebElement skipBtn_Ar;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Profile']")
	private WebElement profileIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='حسابك']")
	private WebElement profileIcon_Ar;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='استكشف']")
	private WebElement discoverIcon_Ar;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In']")
	private WebElement loginBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='سجل دخولك']")
	private WebElement loginBtn_Ar;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email *']")
	private WebElement emailTxtBox;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='البريد الإلكتروني *']")
	private WebElement emailTxtBox_Ar;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Password *']")
	private WebElement passwordTxtBox;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='كلمة المرور *']")
	private WebElement passwordTxtBox_Ar;
		
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Log In'])[2]")
	private WebElement loginBtnLoginPage;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='تسجيل الدخول'])[2]")
	private WebElement loginBtnLoginPage_Ar;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Check the CSGs Guide Book']")
	private WebElement csgGuideBookSearchBox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Groups']")
	private WebElement groupsIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Discover']")
	private WebElement discoverIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search  events, groups ..']")
	private WebElement searchDiscoverBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search for events and groups']")
	private WebElement searchBOXNextPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
	private WebElement searchBtn;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement arabicLanguageBtn;

	
	//Creating unit methods to use anywhere, single entity
	
	public void continueBtnHomePage() throws Throwable {
		Thread.sleep(5000);
		this.continueBtn.click();
	}
	
	public void continueBtnHomePage_Ar() throws Throwable {
		Thread.sleep(5000);
		this.continueBtn_Ar.click();
	}
	
	public void switchArabicLanguage() throws Throwable {
		this.arabicLanguageBtn.isDisplayed();
		Thread.sleep(5000);
		this.arabicLanguageBtn.click();
		Thread.sleep(15000);
	}

	public void skipBtnHomePage() throws Throwable {
		Thread.sleep(1000);
		this.skipBtn.click();
	}
	
	public void skipBtnHomePage_Ar() throws Throwable {
		Thread.sleep(1000);
		this.skipBtn_Ar.click();
	}
	
	public void profileFooterBtn() throws Throwable {
		Thread.sleep(1000);
		this.profileIcon.click();
	}
	
	public void profileFooterBtn_Ar() throws Throwable {
		Thread.sleep(1000);
		this.profileIcon_Ar.click();
	}

	public void loginBtn() throws Throwable {
		Thread.sleep(1000);
		this.loginBtn.click();
	}
	
	public void loginBtn_Ar() throws Throwable {
		Thread.sleep(1000);
		this.loginBtn_Ar.click();
	}
	
	public void enterEmailID(String email) throws Throwable {
		Thread.sleep(3000);
		this.emailTxtBox.click();
		Thread.sleep(1000);
		this.emailTxtBox.sendKeys(email);
	}
	
	public void enterEmailID_Ar(String email) throws Throwable {
		Thread.sleep(3000);
		this.emailTxtBox_Ar.click();
		Thread.sleep(1000);
		this.emailTxtBox_Ar.sendKeys(email);
	}

	public void enterPassword(String pwd) throws Throwable {
		Thread.sleep(1000);
		this.passwordTxtBox.click();
		Thread.sleep(1000);
		this.passwordTxtBox.sendKeys(pwd);
	}
	
	public void enterPassword_Ar(String pwd) throws Throwable {
		Thread.sleep(1000);
		this.passwordTxtBox_Ar.click();
		Thread.sleep(1000);
		this.passwordTxtBox_Ar.sendKeys(pwd);
	}

	public void clickSignInBtn() throws Throwable {
		Thread.sleep(1000);
		this.loginBtnLoginPage.click();
	}
	
	public void clickSignInBtn_Ar() throws Throwable {
		Thread.sleep(1000);
		this.loginBtnLoginPage_Ar.click();
	}
	
	public void loginFunctionality() throws Throwable {
		this.loginBtn();
		Thread.sleep(1000);
		this.enterEmailID(Constants.EMAILID);
		Thread.sleep(1000);
		this.enterPassword(Constants.PASSWORD);
		Thread.sleep(1000);
		this.clickSignInBtn();
		Thread.sleep(5000);
	}
	
	public void loginFunctionality_Ar() throws Throwable {
		this.loginBtn_Ar();
		Thread.sleep(1000);
		this.enterEmailID_Ar(Constants.EMAILID);
		Thread.sleep(1000);
		this.enterPassword_Ar(Constants.PASSWORD);
		Thread.sleep(1000);
		this.clickSignInBtn_Ar();
		Thread.sleep(5000);
	}

	public void groupsFooterBtn() throws Throwable {
		Thread.sleep(1000);
		this.groupsIcon.click();
	}
	
	public void clickCsgGuideBookSearchBox() throws Throwable {
		Thread.sleep(1000);
		this.csgGuideBookSearchBox.click();		
	}
	
	public void discoverFooterBtn() throws Throwable {
		Thread.sleep(1000);
		this.discoverIcon.click();		
	}
	
	public void discoverFooterBtn_Ar() throws Throwable {
		Thread.sleep(1000);
		this.discoverIcon_Ar.click();		
	}
	
	public void discoverSearchTxtBox(String searchTxt) throws Throwable {
		Thread.sleep(1000);
		this.searchDiscoverBtn.click();	
		Thread.sleep(1000);
		this.searchBOXNextPage.click();
		Thread.sleep(1000);
		this.searchBOXNextPage.sendKeys(searchTxt);
		Thread.sleep(1000);
		this.searchBtn.click();
	}
}
