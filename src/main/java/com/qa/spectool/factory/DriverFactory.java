package com.qa.spectool.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	 public static  WebDriver driver;
	 public Properties prop;
	 
	 public WebDriver init_driver(Properties prop) 
	 {
		 String browser= prop.getProperty("browser").trim();
		 
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		 else if(browser.equalsIgnoreCase("firfox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		 }
		 else if (browser.equalsIgnoreCase("safari"))
		 {
			 driver = new SafariDriver();
		 }
		 else 
		 {
			 System.out.println("please enete valid driver ");
			 
		 }
		 driver.get(prop.getProperty("url").trim());
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 return driver; 
	 }
	 
	 public Properties init_prop()
	 {
		 prop= new Properties();
		 try
		 {
			FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
			prop.load(ip);
		 } 
		 catch (FileNotFoundException e) 
		 {
			 e.printStackTrace();
		 } 
		 catch (IOException e) 
		 {
			e.printStackTrace();
		 }
		 return prop;
	 }
	
	 public static String  getScreenshot() {
		   File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String path= System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		  File destination= new File(path);
		   try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return path;
		   
	   }
	   
}
