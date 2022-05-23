package com.qa.spectool.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SingupPage {
	
	
	private WebDriver driver;
	
	
	// 1.  Private By locator 
	private By sinuplink= By.xpath("//span[text()='Sign Up']");
	private By email= By.name("email");
	private By firstNametxt = By.xpath("(//input[@type='text'])[2]");
	private By lastNametxt= By.xpath("(//input[@type='text'])[3]");
	private By passwordtxt = By.xpath("(//input[@name='password'])[1]");
    private By confirmPasswordtxt =By.xpath("(//input[@name='password'])[2]");
    private By contiuneBtn = By.xpath("//button[@type='submit']");
    private By companyNametxt = By.xpath("(//input[@type='text'])[1]");
	private By companyAddresstxt= By.xpath("(//input[@type='text'])[2]");
	private By countrytxt = By.xpath("(//input[@type='text'])[3]");
	private By provincetxt = By.xpath("(//input[@type='text'])[4]");
	private By citytxt= By.xpath("(//input[@type='text'])[5]");
	private By ziptxt= By.xpath("(//input[@type='text'])[6]");
	private By OrganizationType= By.xpath("//div[@id='mui-component-select-firmTypeId']");
	private By nextBtn = By.xpath("//button[@type='submit']");
	private By singUpBtn = By.xpath("(//button[contains(@class,'MuiButton')])[2]");
	

	
	// 2. public Constructor 
    

	public SingupPage(WebDriver driver) {
		this.driver = driver;
	}
    
	
	// 3. Page Actions 
	
	public void singUp(String emailID, String firstName, String lastName, String psw,String comName, String comAddress, String countryName,String provinceName,String cityName,String zipCode ,String orgType,String Name) throws InterruptedException
	{
		Thread.sleep(7000);
		driver.findElement(sinuplink).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(sinuplink)).click();
	
	    Thread.sleep(5000);
	    driver.findElement(email).sendKeys(emailID);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(emailID);
//		
		driver.findElement(firstNametxt).sendKeys(firstName);
		driver.findElement(lastNametxt).sendKeys(lastName);
		driver.findElement(passwordtxt).sendKeys(psw);
		driver.findElement(confirmPasswordtxt).sendKeys(psw);
		
		driver.findElement(contiuneBtn).click();
		
		
	  WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(companyNametxt)).sendKeys(comName);
	
		driver.findElement(companyAddresstxt).sendKeys(comAddress);
		
		Thread.sleep(5000);
		driver.findElement(countrytxt).sendKeys(countryName);
		
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(countrytxt)).sendKeys(countryName);
		Thread.sleep(5000);
	    driver.findElement(provincetxt).sendKeys(provinceName);
		Thread.sleep(5000);
	    driver.findElement(citytxt).sendKeys(cityName);
	    driver.findElement(ziptxt).sendKeys(zipCode);
		Thread.sleep(5000);
	    driver.findElement(OrganizationType).click();
	    driver.findElement(By.xpath("//li[contains(text(),'"+orgType+"')]")).click();
	    driver.findElement(nextBtn).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//p[contains(text(),'"+Name+"')]")).click();
		Thread.sleep(5000);
	    driver.findElement(singUpBtn).click();
	}
	
	
	
	
	
}


