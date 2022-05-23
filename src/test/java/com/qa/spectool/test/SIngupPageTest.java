package com.qa.spectool.test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.spectool.base.BaseTest;

public class SIngupPageTest extends BaseTest
{
	
	
	
	
public String getRandom() {
	Random random= new Random();
String email=	"javaselenium"+random.nextInt(1000)+"@gmail.com";
return email;
}

@DataProvider
public Object[][] singupData() 
{
	Object[][]data=new Object[][] 
			{
		                           {"Alex","Patel","Abc@12345","ATS","646 culver way","Canada","Ontario","Toronto","M9V 2L1","Engineering Firm","General Manager"
			                        	},
		                           
	        };
	return data;
}


@Test(dataProvider = "singupData")
public void singUpTest(String fName,String lName,String password,String compName,String address,String coName,String provName,String ciName,String postcode,String organiType,String role ) throws InterruptedException {
	signupPage.singUp(getRandom(), fName, lName, password,compName,address,coName,provName,ciName,postcode,organiType,role);
	Assert.assertEquals(driver.getTitle(), "Spec Tool");
}
	

	
	
	
	
	
	
	
}
