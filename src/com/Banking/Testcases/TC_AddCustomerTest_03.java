package com.Banking.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.Pom.AddCustomerPage;
import com.Banking.Pom.LogInpage;

public class TC_AddCustomerTest_03 extends BaseClass {
	
	@Test
	public void addCustomerTest() throws InterruptedException, IOException
	{
		
		LogInpage l = new LogInpage(driver);
		
		l.setUserName(username);
		logger.info("User name is provided");
	
		l.setPassword(password);
		logger.info("Passsword is provided");
		
		l.clickSubmit();
		
		Thread.sleep(2000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
	    addcust.clickAddNewCustomer();
        
		Thread.sleep(3000);
		
		logger.info("providing customer details....");
		
		addcust.custName("Naresh");
		addcust.custgender("male");
		addcust.custdob("08","22","1996");
		addcust.custaddress("INDIA");
		addcust.custcity("CHN");
		addcust.custstate("TN");
		addcust.custpinno("600062");
		addcust.custtelephoneno("7871038210");
		Thread.sleep(5000);
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(2000);
		
	    boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

}
