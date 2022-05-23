package com.qa.spectool.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.spectool.factory.DriverFactory;
import com.qa.spectool.pages.CreatProjectPage;
import com.qa.spectool.pages.DashboardPage;
import com.qa.spectool.pages.LoginPage;
import com.qa.spectool.pages.OrganizationDetailsPage;
import com.qa.spectool.pages.SingupPage;



public class BaseTest {
	
	  public Properties prop;
	  public WebDriver driver;
	  public DriverFactory driverFactory;
	  public SingupPage signupPage;
	  public LoginPage loginPage;
	  public CreatProjectPage  creatprojectpage;
	  public DashboardPage dashboardpage;
	  public  OrganizationDetailsPage organizationPage;
	 
	  
	
	   
		
		@BeforeTest
		public void setUp()
		{
			 driverFactory = new DriverFactory();
			 prop=driverFactory.init_prop();
			 driver=driverFactory.init_driver(prop);
			 loginPage=new LoginPage(driver);
			 signupPage= new SingupPage(driver);
			 dashboardpage = new DashboardPage(driver);
			 creatprojectpage = new CreatProjectPage(driver);
			 organizationPage=new OrganizationDetailsPage(driver);
		}
		
		@AfterTest
		public void tearDown() 
		{
    	driver.quit();
		}

}
