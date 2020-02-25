package com.uiFramework.f13Works.uatProductPro.testScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiFramework.f13Works.uatProductPro.helper.assertion.AssertionHelper;
import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.f13Works.uatProductPro.helper.logger.LoggerHelper;
import com.uiFramework.f13Works.uatProductPro.pageObjectSupply.LoginPage;
import com.uiFramework.f13Works.uatProductPro.pageObjectSupply.SupplyNavigationMenu;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;
/**
 * 
 * @author 
 */
public class LoginTestWithDataDrivenApproach extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTestWithDataDrivenApproach.class);
	
	LoginPage login;
	SupplyNavigationMenu navigationMenu;
	
	
	@DataProvider(name="testData")
	public Object[][] testData(){
		Object[][] data = getExcelData("testData.xlsx", "loginData");
		return data;
	}
	@BeforeClass
	public void beforeClass(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		login = new LoginPage(driver);
	}
	@Test(dataProvider="testData")
	public void loginTest(String userName, String password, String runMode){
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");
		}
		login.loginToApplication(userName, password);
	//	boolean status = login.verifySuccessLoginMsg();
	//	AssertionHelper.updateTestStatus(status);
		//login.logout();
	}
}
