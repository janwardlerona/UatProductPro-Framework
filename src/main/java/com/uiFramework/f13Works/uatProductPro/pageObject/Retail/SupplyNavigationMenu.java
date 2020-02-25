package com.uiFramework.f13Works.uatProductPro.pageObject.Retail;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.f13Works.uatProductPro.helper.logger.LoggerHelper;
import com.uiFramework.f13Works.uatProductPro.helper.wait.WaitHelper;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;


/**
 * 
 * @author 
 */
public class SupplyNavigationMenu {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(SupplyNavigationMenu.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//span[@class='button-text'][contains(text(),'Home')]")
	public WebElement homeMenu;
	
	@FindBy(xpath="//span[@class='button-text'][contains(text(),'My supply')]")
	public WebElement mySupplyMenu;
	
	
	@FindBy(xpath="//span[@class='button-text'][contains(text(),'My orders')]")
	public WebElement myOrdersMenu;
	
	@FindBy(xpath="//body/app-root/div[@class='app']/app-shell[@class='ng-star-inserted']/mat-sidenav-container[@class='container mat-drawer-container mat-sidenav-container']/mat-sidenav-content[@class='content mat-drawer-content mat-sidenav-content']/div[@class='outlet-container']/app-supply[@class='ng-star-inserted']/app-page/div[@class='page']/div[@class='page-content']/div[@class='ng-star-inserted']/div[@class='ng-star-inserted']/div[@class='ng-star-inserted']/form[@class='ng-untouched ng-pristine ng-valid']/div/app-search-bar[@placeholder='Enter keywords']/app-card/mat-card[@class='mat-card card']/div[@class='ng-untouched ng-pristine ng-valid']/button[@class='mat-button mat-button-base']/span[@class='mat-button-wrapper']/mat-icon[@class='mat-icon notranslate mat-icon-no-color']/*[1] ")
	public WebElement humburgerMenu;

	public SupplyNavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(mySupplyMenu, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("SupplyNavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}
	
	public void mouseOver(String data){
		log.info("doing mouse over on :"+data);
		TestBase.logExtentReport("doing mouse over on :"+data);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}
	

}
