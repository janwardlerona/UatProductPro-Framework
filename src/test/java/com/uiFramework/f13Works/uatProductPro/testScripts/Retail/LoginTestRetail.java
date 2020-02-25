package com.uiFramework.f13Works.uatProductPro.testScripts.Retail;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.f13Works.uatProductPro.helper.assertion.AssertionHelper;
import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.f13Works.uatProductPro.helper.logger.LoggerHelper;
import com.uiFramework.f13Works.uatProductPro.pageObject.Retail.LoginPageRetail;
import com.uiFramework.f13Works.uatProductPro.pageObject.Supply.LoginPageSupply;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;
/**
 * 
 * @author 
 */
public class LoginTestRetail extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTestRetail.class);
	
	@Test(description="Login test with valid credentials")
	public void testLoginToApplication(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPageRetail loginPage = new LoginPageRetail(driver);
		loginPage.loginToApplicationRetail(ObjectReader.reader.getEmailRetail(), ObjectReader.reader.getPasswordRetail());
		
		//boolean status = loginPage.verifySuccessLoginMsg();
		//AssertionHelper.updateTestStatus(status);
	}
}
