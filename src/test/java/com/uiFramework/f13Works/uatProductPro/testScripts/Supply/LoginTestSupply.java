package com.uiFramework.f13Works.uatProductPro.testScripts.Supply;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.f13Works.uatProductPro.helper.assertion.AssertionHelper;
import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.f13Works.uatProductPro.helper.logger.LoggerHelper;
import com.uiFramework.f13Works.uatProductPro.pageObject.Supply.LoginPageSupply;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;
/**
 * 
 * @author 
 */
public class LoginTestSupply extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTestSupply.class);
	
	@Test(description="Login test with valid credentials")
	public void testLoginToApplication(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPageSupply loginPage = new LoginPageSupply(driver);
		loginPage.loginToApplicationSupply(ObjectReader.reader.getEmailSupply(), ObjectReader.reader.getPasswordSupply());
		
		//boolean status = loginPage.verifySuccessLoginMsg();
		//AssertionHelper.updateTestStatus(status);
	}
}
