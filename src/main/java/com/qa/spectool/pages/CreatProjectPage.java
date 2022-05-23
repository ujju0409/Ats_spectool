package com.qa.spectool.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatProjectPage {

	private  WebDriver driver;
    public  WebDriverWait wait;

 	// 1. private By Locator 
	
	
	
	private By internalnotxt=By.xpath("//input[@name='internalNo']");
	private By projectnametxt= By.xpath("//input[@name='name']");
	private By countrytxt= By.xpath("//input[@name='location.country.id']");
	private By provincetxt =By.xpath("//input[@name='location.province.id']");
	private By citytxt = By.xpath("//input[@name='location.city.id']");
	private By addresstxt= By.xpath("//textarea[@name='address']");
	private By datetxt = By.xpath("//input[@name='bidDate']");
	private By areatxt = By.xpath("//input[@name='area']");
	private By nextbtn=By.xpath("//span[text()='Next']");
	private By AddCollaboratorstxt =By.xpath("//input[contains(@id,'mui-autocomplete')]");
	private By finishbtn= By.xpath("//span[text()='Finish']");
	private By mangeprojectLnk= By.xpath("//span[contains(text(),'Manage Projects')]");
	private By serchproducttxt= By.xpath("//input[@placeholder='Enter your search']");
	
	
	private By buildinglnk=By.xpath("//div[contains(@class,'MuiGrid-root-') and contains(@class,'MuiGrid-item-') and contains(@class,'MuiGrid-grid-xs-') and contains(@class,'MuiGrid-grid-md-')]//p");
	
	// 2. public Constructor 
	
	public CreatProjectPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// 3. Page Actions 
	
	
	
	public String basicProjectDeatils(String internalnumber, String projectname, String countryname, String provincename, String cityname, String addres, String bidDate,String area,String buildingName, String ChoosebuildingType,String Collaborators) throws InterruptedException  
	{
		
	
		
			Thread.sleep(5000);
		
		
		
		driver.findElement(internalnotxt).sendKeys(internalnumber);
		driver.findElement(projectnametxt).sendKeys(projectname);
		Thread.sleep(5000);
		driver.findElement(countrytxt).sendKeys(countryname);
		
		Thread.sleep(5000);
		driver.findElement(provincetxt).sendKeys(provincename);
		Thread.sleep(5000);
		driver.findElement(citytxt).sendKeys(cityname);
		
//		wait = new WebDriverWait(driver, Duration.ofSeconds(70));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(internalnotxt)).sendKeys(internalnumber);
//	    
//	    
//	    
//	    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(countrytxt)).sendKeys(countryname);
//	    
//	    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(provincetxt)).sendKeys(provincename);
//	  
//	    wait = new WebDriverWait(driver, Duration.ofSeconds(70));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(citytxt)).sendKeys(cityname);
	    
	    driver.findElement(addresstxt).sendKeys(addres);
	    
	    driver.findElement(datetxt).sendKeys(bidDate);
	    
	    driver.findElement(areatxt).sendKeys(area);
	    
	    driver.findElement(nextbtn).click();
	
	
	
	
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> buildinglist=	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(buildinglnk));
		System.out.println("total Building :"+buildinglist.size());
		for(WebElement e:buildinglist) 
		{
			String text=e.getText();
			if(text.equalsIgnoreCase(buildingName)) 
			{
				e.click();
				break;
			}
		}
		Thread.sleep(5000);
		
		WebElement choosebuildingradiobtn= driver.findElement(By.xpath("//span[text()='"+ChoosebuildingType+"']/./preceding-sibling::span//input"));
		choosebuildingradiobtn.click();
		
		 driver.findElement(nextbtn).click();
		 Thread.sleep(5000);
		driver.findElement(AddCollaboratorstxt).sendKeys(Collaborators);
		driver.findElement(finishbtn).click();
		
//		WebDriverWait	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(mangeprojectLnk)).click();
	    Thread.sleep(5000);
	   driver.findElement(mangeprojectLnk).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(serchproducttxt)).click();
	    
	
	   
	    Thread.sleep(10000);
	    WebElement actualprojectname= driver.findElement(By.xpath("//a[@title='ABC']"));
	    String Text= actualprojectname.getText();
	    System.out.println(Text);
	    return Text;
	    
	}
	

}
