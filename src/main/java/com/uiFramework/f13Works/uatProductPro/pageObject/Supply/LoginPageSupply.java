package com.uiFramework.f13Works.uatProductPro.pageObject.Supply;

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
public class LoginPageSupply{
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPageSupply.class);
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[contains(@id,'mat-input')]")
	WebElement emailSupply;
	
	@FindBy(xpath="//input[@id='mat-input-1']")
	WebElement passwordSupply;
	
	@FindBy(xpath="//button[@class='mat-flat-button mat-button-base mat-primary']")
	WebElement submitLogin;
	
	@FindBy(xpath="//*[@id='center_column']/p")
	WebElement productProLogo;
	

	public LoginPageSupply(WebDriver driver) {
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
	
	//Supply
	public void enterEmailSupply(String emailSupply){
		log.info("entering emailSupply...."+emailSupply);
		logExtentReport("entering passwordSupply...."+emailSupply);
		this.emailSupply.sendKeys(emailSupply);
	}
	
	public void enterPasswordSupply(String passwordSupply){
		log.info("entering passwordSupply...."+passwordSupply);
		logExtentReport("entering passwordSupply...."+passwordSupply);
		this.passwordSupply.sendKeys(passwordSupply);
	}
	
	public SupplyNavigationMenu clickOnSubmitButton(){
		log.info("clicking on submit button...");
		logExtentReport("clicking on submit button...");
		submitLogin.click();
		return new SupplyNavigationMenu(driver);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateProductProImage(){
		return productProLogo.isDisplayed();
	}
	
	public void loginToApplicationSupply(String emailSupply, String passwordSupply){
		enterEmailSupply(emailSupply);
		enterPasswordSupply(passwordSupply);
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
