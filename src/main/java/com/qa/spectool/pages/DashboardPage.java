package com.qa.spectool.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.spectool.pages.CreatProjectPage;

public class DashboardPage  {
	
	private WebDriver driver;
	
	// 1. private By Locator 
	
	private By newprojectlnk= By.xpath("//span[text()='New Project']");

	
	
	// 2. public Constructor 
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 3. Page Actions 
	

	public  CreatProjectPage doClickOnNewProject() 
	{
		
		
		 WebDriverWait 	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(newprojectlnk)).click();
	     
	     
	     
	     return new CreatProjectPage(driver);
	     
	     
	}
	
	
	
	
}
