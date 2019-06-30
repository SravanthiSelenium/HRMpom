package com.HRMpom.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Baseclass {
	
	public static  WebDriver driver;
	  public static Properties prop;
	

	public Baseclass() throws IOException
	{
		 
		   prop=new Properties();
		   FileInputStream fip=new FileInputStream("D:\\seleniumworkspace\\workspace1\\HRMpom\\src\\main\\java\\com\\HRMpom\\config\\config.properties");
		   prop.load(fip);
		   
	}
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","D:\\seleniumworkspace\\chromedriver.exe")	;
		driver=new ChromeDriver();
		}
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\seleniumworkspace\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
	public void takescreenshot(String str) throws IOException{
		DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss"); // date and time format specification
		Date d=new Date();// it will collect the current system date
		String time=df.format(d);
		System.out.println(time);
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("D:\\seleniumworkspace\\workspace1\\HRMpom\\Screenshots\\"+str+time+".png"));
	}
	
}

