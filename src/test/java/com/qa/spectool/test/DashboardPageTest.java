package com.qa.spectool.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.spectool.base.BaseTest;

public class DashboardPageTest extends BaseTest {
	
	
	@BeforeClass
	public void DashboardLogin()
	{
		dashboardpage=loginPage.dologin(prop.getProperty("userid"),prop.getProperty("password"));
	}
	
	@Test
	public void  doClickNewProjectTest()
	{
		dashboardpage.doClickOnNewProject();
		Assert.assertEquals(driver.getCurrentUrl(), "https://spec.atsspecsolutions.com/createNewProject");
}
}
