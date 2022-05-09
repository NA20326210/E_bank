package com.Banking.Testcases;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Banking.Utilities.ReadConfig;

public class BaseClass {
	
	public static ReadConfig readconfig = new ReadConfig();
	
	public static String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public static void setUp(String b) throws Exception 
	{   
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(b.equals("chrome"))
		{	
			
		    System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		    driver=new ChromeDriver();
		
	    
		}
		else if(b.equals("firefox"))
		{
		    System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		    driver=new FirefoxDriver();
	    }
		else if(b.equals("ie"))
		{
		    System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
		    driver=new InternetExplorerDriver();
		}
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
        
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.quit();
	}
	
	public void captureScreen (WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");		
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString1 = RandomStringUtils.randomNumeric(4);
		return (generatedString1);
	}
}
