package com.Banking.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInpage {
	
	public static WebDriver driver;
	
	public LogInpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement userName;
	
	@FindBy(css="input[type*='password']")
	@CacheLookup
	WebElement passWord;
	
	@FindBy(xpath="//input[@type='submit' or @name='btnLogin']")
	@CacheLookup
	WebElement loginBtn;
	
    @FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
    @CacheLookup
    WebElement lnkLogout;
	

	public void setUserName(String uName) {
		userName.sendKeys(uName);
	}

	public void setPassword(String pwd) {
		passWord.sendKeys(pwd);
	}

	public void clickSubmit() {
		loginBtn.click();

	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	      
	}

