package com.qa.spectool.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.spectool.base.BaseTest;

import io.qameta.allure.Description;

public class LoginPageTest extends BaseTest {
	@Description("login page  title test ")
    @Test
	public void DoLoginTest() throws InterruptedException 
    {
	loginPage.dologin(prop.getProperty("userid"),prop.getProperty("password"));
	Thread.sleep(5000);
	Assert.assertEquals(driver.getCurrentUrl(), "https://spec.atsspecsolutions.com/");
	}
	
	
	
	
}
