package com.HRMpom.testcasescripts;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
//import org.w3c.dom.DOMConfiguration;

import com.HRMpom.pages.Dashboardpage;
import com.HRMpom.pages.LoginPage;
import com.HRMpom.baseclass.Baseclass;
import com.HRMpom.util.Testutil;

//import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

//import Academy.HomePage;

public class LoginPageTest extends Baseclass {

	
	com.HRMpom.pages.HomePage hp;
	LoginPage lp;
	private String loginpageimg;	 
	
	org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(LoginPageTest.class);
	String configurepath=System.getProperty("D:\\seleniumworkspace\\workspace1\\HRMpom\\src\\main\\java\\log4j.properties");
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void setup() throws Exception{
		logger.info("initialization started");
		initialization();
		lp=new LoginPage();		//login page initialization
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		logger.info("title validation started");
		String title=lp.validateloginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
		
	}
	

	@Test(priority=2)
	public void LoginTest() throws Exception{
		
		takescreenshot("loginpageimg");
		logger.info("login screenshot captured");
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	

	@AfterTest
	public void teardown(){
		//driver.quit();
	}
}
