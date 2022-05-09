package com.Banking.Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_LoginTest_01 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		
		
		com.Banking.Pom.LogInpage l = new com.Banking.Pom.LogInpage(driver);
		l.setUserName(username);
		logger.info("User name is provided");
		Assert.assertEquals(username, username);
		
		l.setPassword(password);
		logger.info("Passsword is provided");
		Assert.assertEquals(password, password);
		
		
		l.clickSubmit();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
		     Assert.assertTrue(true);
		     logger.info("test case passed....");
		} 
		else
		{
			logger.info("test case failed....");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}	
	
}