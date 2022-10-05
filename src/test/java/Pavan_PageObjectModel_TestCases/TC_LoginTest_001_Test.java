package Pavan_PageObjectModel_TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import Pavan_PageObjectModel_PageObjects.LoginPage;
import Pavan_PageObjectModel_Utility.ExtentReportNG;

public class TC_LoginTest_001_Test extends BaseClass{

	
	
	@Test
	public void loginTest() throws InterruptedException {
		
	
	
		
		String url=prop.getProperty("url");
		driver.get(url);
		logger.info("Launching URL of the application :" +url);
		
		
		
		LoginPage loginpage=new LoginPage(driver);
		
		String userName=prop.getProperty("username");
		loginpage.setUserID(userName);
		logger.info("Entered the username :"+userName);
		
		String pwd=prop.getProperty("password");
		loginpage.setPassword(pwd);
		logger.info("Entered the password :"+pwd);
		
		loginpage.getLogin();
		logger.info("Get logged in to the application");
		waitForElementToBeVisible(By.xpath("//a[normalize-space()='New Customer']"));
		logger.info("Wait for a second till the Home page comes");
		//Thread.sleep(3000);

		
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Guru99 Bank Manager HomePage";
		
		if(actualTitle.equals(expectedTitle)) {
			
			Assert.assertTrue(true);
			logger.info("Home page title is matched, Login successfull..Test case passed");
			
		}
		else {
			
			logger.info("Home page title is not matched, Login not successfull, Test case fialed");
			Assert.assertTrue(false);
		}
		
		
		
		
	}
	
	
	
	
	
	
}
