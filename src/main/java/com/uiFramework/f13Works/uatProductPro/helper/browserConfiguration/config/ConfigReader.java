package com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config;

import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.BrowserType;
/**
 * 
 * @author 
 *
 */
public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassword();

}
