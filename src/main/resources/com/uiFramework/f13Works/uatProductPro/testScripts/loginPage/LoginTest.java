package com.uiFramework.f13Works.uatProductPro.testScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.f13Works.uatProductPro.helper.assertion.AssertionHelper;
import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.f13Works.uatProductPro.helper.logger.LoggerHelper;
import com.uiFramework.f13Works.uatProductPro.pageObjectSupply.LoginPage;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;
/**
 * 
 * @author 
 */
public class LoginTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description="Login test with valid credentials")
	public void testLoginToApplication(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(ObjectReader.reader.getEmailSupply(), ObjectReader.reader.getPasswordSupply());
		
		//boolean status = loginPage.verifySuccessLoginMsg();
		//AssertionHelper.updateTestStatus(status);
	}
}
