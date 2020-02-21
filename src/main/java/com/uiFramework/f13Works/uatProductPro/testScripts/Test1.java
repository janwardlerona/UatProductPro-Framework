package com.uiFramework.f13Works.uatProductPro.testScripts;

import org.testng.annotations.Test;

import com.uiFramework.f13Works.uatProductPro.helper.assertion.AssertionHelper;
import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;

public class Test1 extends TestBase{

	
	@Test
	public void testLogin(){
		AssertionHelper.markPass();
	}
	
	@Test
	public void testLogin1(){
		AssertionHelper.markFail();
	}
	
	@Test
	public void testLogin2(){
		AssertionHelper.markPass();
	}
	
	@Test
	public void testLogin3(){
		AssertionHelper.markFail();
	}
}
