package com.qa.spectool.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	private WebDriver driver ;
	

	// 1. private By Locator 
	
	private By loginlink= By.xpath("//span[contains(@class,'MuiTab-wrapper-')][normalize-space()='Log In']");
	private By Idtxt = By.name("username");
	private By Passwordtxt = By.xpath("//input[@name='password']");
	private By LoginBtn= By.xpath("//button[@type='submit']");
	private By forgetpswlnk= By.linkText("Forget password?");
	private By dosinguplnk= By.xpath("//span[normalize-space()='Sign Up']");
	
	
	// 2. public Constructor 
	
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// 3. Page Actions 
  public DashboardPage dologin(String username,String psw) 
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(loginlink)).click();
	    
	    wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(Idtxt)).sendKeys(username);
	    
	    
	    driver.findElement(Passwordtxt).sendKeys(psw);
	    driver.findElement(LoginBtn).click();
	    
	    return new DashboardPage(driver);
  }
  
  public SingupPage dosingup() {
	  driver.findElement(dosinguplnk).click();
	  
	  return new SingupPage(driver);
  }

}
