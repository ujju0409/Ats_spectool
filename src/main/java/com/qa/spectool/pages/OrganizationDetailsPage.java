package com.qa.spectool.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrganizationDetailsPage
{

	private WebDriver driver;
	
	
	
	//1 . private By Locator 
	
	private By CompanyName = By.xpath("(//input[@type='text'])[1]");
	private By CompanyAddress= By.xpath("(//input[@type='text'])[2]");
	private By country = By.xpath("(//input[@type='text'])[3]");
	private By province = By.xpath("(//input[@type='text'])[4]");
	private By city= By.xpath("(//input[@type='text'])[5]");
	private By Zip= By.xpath("(//input[@type='text'])[6]");
	private By OrganizationType= By.xpath("//div[@id='mui-component-select-firmTypeId']");
	private By NextBtn = By.xpath("//button[@type='submit']");
	private By SingUpBtn = By.xpath("(//button[contains(@class,'MuiButton')])[2]");
	
	
	
	
	
	// 2. public Constructor 
	
	
	public OrganizationDetailsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	// 3. Page Actions 
	
	public void OrganizationInfo(String comName, String comAddress, String countryName,String provinceName,String cityName,String zipCode ,String orgType ) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyName)).sendKeys(comName);
	
		driver.findElement(CompanyAddress).sendKeys(comAddress);
		
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(country)).sendKeys(countryName);
	    
	    driver.findElement(province).sendKeys(provinceName);
	    driver.findElement(city).sendKeys(cityName);
	    driver.findElement(Zip).sendKeys(zipCode);
	    driver.findElement(OrganizationType).click();
	    driver.findElement(By.xpath("//li[contains(text(),'"+orgType+"')]")).click();
	    driver.findElement(NextBtn).click();
	   
	   
	}
	
	public void role(String Name) {
		driver.findElement(By.xpath("//p[contains(text(),'"+Name+"')]")).click();
		
		
		
	}
	
	 public void Submit() {
		 driver.findElement(SingUpBtn).click();
	 }
	
}
