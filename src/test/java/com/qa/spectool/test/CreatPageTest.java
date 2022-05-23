package com.qa.spectool.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.spectool.base.BaseTest;

public class CreatPageTest extends BaseTest {
	
	@BeforeClass
	public void creatPageLogin() 
	{
	    loginPage.dologin(prop.getProperty("userid"),prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] creatprojectData() 
	{
		Object[][]data=new Object[][] 
				{
			                           {"1234","ABC","Canada","Ontario",
			                        	"Toronto","655 Bay St","2022-05-10",
			                        	"12","Commercial","Mall"," This is my new Project"},
			                           
		        };
		return data;
	}
	
	@Test(dataProvider = "creatprojectData")
	public void basicProjectDeatilsTest(String internalnum,String projname,String coname, String provname,
			String ciname,String add,String date,String areasq,String bname,String choosebtype ,String colbrator) throws InterruptedException 
	{
		creatprojectpage=dashboardpage.doClickOnNewProject();
		String actualprojectname=creatprojectpage.basicProjectDeatils(internalnum, projname, coname, provname, ciname, add, date, areasq,bname,choosebtype,colbrator);
		Assert.assertEquals(actualprojectname, projname);
		
	}
	
	

	
}
