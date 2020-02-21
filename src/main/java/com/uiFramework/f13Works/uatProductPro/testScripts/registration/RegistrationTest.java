package com.uiFramework.f13Works.uatProductPro.testScripts.registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.f13Works.uatProductPro.helper.assertion.AssertionHelper;
import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.f13Works.uatProductPro.helper.logger.LoggerHelper;
import com.uiFramework.f13Works.uatProductPro.pageObjectSupply.LoginPage;
import com.uiFramework.f13Works.uatProductPro.pageObjectSupply.MyAccountPage;
import com.uiFramework.f13Works.uatProductPro.pageObjectSupply.RegistrationPage;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;

/**
 * @author
 */
public class RegistrationTest extends TestBase{
	
	private final Logger log = LoggerHelper.getLogger(RegistrationTest.class);
	LoginPage loginPage;
	RegistrationPage register;
	MyAccountPage myAccountPage;
	
	@Test
	public void testRegistration(){
		// go to application
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		loginPage = new LoginPage(driver);

		loginPage.enterRegistrationEmail();
		
		register = loginPage.clickOnCreateAnAccount();
		
		// enter registration data
		register.setMrRadioButton();
		register.setFirstName("firstName");
		register.setLastname("lastname");
		register.setPassword("password");
		register.setAddress("address");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		register.setYourAddressFirstName("yourAddressFirstName");
		register.setYourAddressLastName("yourAddressLastName");
		register.setYourAddressCompany("yourAddressCompany");
		register.setYourAddressCity("yourAddressCity");
		register.setYourAddressState("Alaska");
		register.setYourAddressPostCode("99501");
		register.setMobilePhone("9999999999");
		register.setAddressAlias("addressAlias");
		register.clickRegistration();
		
		myAccountPage = new MyAccountPage(driver);
		boolean status = myAccountPage.isYourAccountPageMessage();
		
		AssertionHelper.updateTestStatus(status);
	}
}
