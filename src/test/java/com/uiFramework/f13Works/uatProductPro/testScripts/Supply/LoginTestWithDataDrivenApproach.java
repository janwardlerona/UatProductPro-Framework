package com.uiFramework.f13Works.uatProductPro.testScripts.Supply;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiFramework.f13Works.uatProductPro.helper.assertion.AssertionHelper;
import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.f13Works.uatProductPro.helper.logger.LoggerHelper;
import com.uiFramework.f13Works.uatProductPro.pageObject.Supply.LoginPageSupply;
import com.uiFramework.f13Works.uatProductPro.pageObject.Supply.SupplyNavigationMenu;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;
/**
 * 
 * @author 
 */
public class LoginTestWithDataDrivenApproach extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTestWithDataDrivenApproach.class);
	
	LoginPageSupply login;
	SupplyNavigationMenu navigationMenu;
	
	
	@DataProvider(name="testData")
	public Object[][] testData(){
		Object[][] data = getExcelData("testData.xlsx", "loginData");
		return data;
	}
	@BeforeClass
	public void beforeClass(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		login = new LoginPageSupply(driver);
	}
	@Test(dataProvider="testData")
	public void loginTest(String userName, String password, String runMode){
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");
		}
		login.loginToApplicationSupply(userName, password);
	//	boolean status = login.verifySuccessLoginMsg();
	//	AssertionHelper.updateTestStatus(status);
		//login.logout();
	}
}
