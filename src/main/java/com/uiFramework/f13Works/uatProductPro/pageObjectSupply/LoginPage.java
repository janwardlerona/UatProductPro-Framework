package com.uiFramework.f13Works.uatProductPro.pageObjectSupply;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.f13Works.uatProductPro.helper.assertion.VerificationHelper;
import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.f13Works.uatProductPro.helper.javaScript.JavaScriptHelper;
import com.uiFramework.f13Works.uatProductPro.helper.logger.LoggerHelper;
import com.uiFramework.f13Works.uatProductPro.helper.wait.WaitHelper;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;


/**
 * 
 * @author 
 */
public class LoginPage{
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	
	//@FindBy(xpath="//div[contains(text(),'app.uat.f13works.com')]")
	//WebElement shopifyAppLink;
	
	@FindBy(xpath="//*[contains(@id,'mat-input')]")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='mat-input-1']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='mat-flat-button mat-button-base mat-primary']")
	WebElement submitLogin;
	
	@FindBy(xpath="//*[@id='center_column']/p")
	WebElement successMsgObject;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement registrationEmailAddress;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement createAnAccount;
	
	@FindBy(xpath="//*[@id='center_column']/h1")
	WebElement authenticate;
	
	@FindBy(xpath="//*[@id='create-account_form']/div/p")
	WebElement createAnAccountMessage;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//waitHelper.waitForElement(shopifyAppLink,ObjectReader.reader.getExplicitWait());
		//new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Login Page Object Created");

	}
	
	//public void clickOnSignInLink(){
	//	log.info("clicked on app.uat.f13works.com in link...");
	//	logExtentReport("clicked on app.uat.f13works.com in link...");
	//	shopifyAppLink.click();
	//}
	
	public void enterEmailAddress(String emailAddress){
		log.info("entering email address...."+emailAddress);
		logExtentReport("entering email address...."+emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password){
		log.info("entering password...."+password);
		logExtentReport("entering password...."+password);
		this.password.sendKeys(password);
	}
	
	public SupplyNavigationMenu clickOnSubmitButton(){
		log.info("clicking on submit button...");
		logExtentReport("clicking on submit button...");
		//JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		//javaScriptHelper.scrollDownVertically();
		//new JavaScriptHelper(driver).scrollDownVertically();
		submitLogin.click();
		return new SupplyNavigationMenu(driver);
	}
	
	public boolean verifySuccessLoginMsg(){
		return new VerificationHelper(driver).isDisplayed(successMsgObject);
	}
	
	public void enterRegistrationEmail(){
		String email = System.currentTimeMillis()+"@gmail.com";
		log.info("entering registration email.."+email);
		registrationEmailAddress.sendKeys(email);	
	}
	
	public RegistrationPage clickOnCreateAnAccount(){
		createAnAccount.click();
		return new RegistrationPage(driver);
	}
	
	public void loginToApplication(String emailAddress, String password){
		//clickOnSignInLink();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}
	
	//public void logout(){
	//	logout.click();
	//	log.info("clicked on logout link");
	//	waitHelper.waitForElement(shopifyAppLink, ObjectReader.reader.getExplicitWait());
	//}

	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}

}
