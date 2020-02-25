package com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.uiFramework.f13Works.uatProductPro.helper.browserConfiguration.BrowserType;
import com.uiFramework.f13Works.uatProductPro.helper.resource.ResourceHelper;
/**
 * 
 * @author 
 *
 */
public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		try {
			String filePath = ResourceHelper.getResourcePath("src/main/resources/configfile/config.properties");
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);
			
			String filePath1 = ResourceHelper.getResourcePath("src/main/resources/configfile/config1.properties");
			file = new FileInputStream(new File(filePath1));
			OR = new Properties();
			OR.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

	public String getUrl() {
		if(System.getProperty("url")!=null){
			return System.getProperty("url");
		}
		return OR.getProperty("applicationUrl");
	}

	//Supply Environment
	public String getEmailSupply() {
		if(System.getProperty("emailSupply")!=null){
			return System.getProperty("emailSupply");
		}
		return OR.getProperty("emailSupply");
	}

	public String getPasswordSupply() {
		if(System.getProperty("passwordSupply")!=null){
			return System.getProperty("passwordSupply");
		}
		return OR.getProperty("passwordSupply");
	}
	
	//Retail Environment
	public String getEmailRetail() {
		if(System.getProperty("emailRetail")!=null){
			return System.getProperty("emailRetail");
		}
		return OR.getProperty("emailSupply");
	}

	public String getPasswordRetail() {
		if(System.getProperty("passwordRetail")!=null){
			return System.getProperty("passwordRetail");
		}
		return OR.getProperty("passwordRetail");
	}

}
