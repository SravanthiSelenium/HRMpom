package com.HRMpom.testcasescripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRMpom.pages.LoginPage;
import com.HRMpom.baseclass.Baseclass;

//import Academy.HomePage;

public class HomePageTest extends Baseclass{

	com.HRMpom.pages.HomePage hp;
	LoginPage lp;
	//public String Homepageimg;
	org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(HomePageTest.class);
	String configurepath=System.getProperty("D:\\seleniumworkspace\\workspace1\\HRMpom\\src\\main\\java\\log4j.properties");

		public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws Exception{
		initialization();
		lp=new LoginPage();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		//String Homepageimg = null ;
		takescreenshot("Homepageimg");
		logger.info("homepage screenshot captured");
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
	String homePageTitle=hp.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "OrangeHRM");
	}
//"Homepage title not matched"
	
	@AfterMethod
	public void teardown(){
		//driver.quit();
		
	}
	
}
