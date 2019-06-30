package com.HRMpom.pages;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMpom.baseclass.Baseclass;


public class LoginPage extends Baseclass {
	public LoginPage() throws IOException
	{
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement loginbutton;
	
	public String validateloginPageTitle(){
		return driver.getTitle();
		
	}
	public HomePage login(String un,String pwd) throws Exception{
	{
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		return new HomePage();
	}
	
	
	}	

}
