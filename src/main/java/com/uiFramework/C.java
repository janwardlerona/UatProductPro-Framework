package com.uiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.f13Works.uatProductPro.testbase.TestBase;

public class C extends TestBase{
	int i = 1;
	
	@Test
	public void testLoginC(){

			System.out.println(i);
			i++;
			Assert.assertTrue(false);	
		
		
	}

}
