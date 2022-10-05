package Pavan_PageObjectModel_TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pavan_PageObjectModel_PageObjects.LoginPage;

public class TC_LoginTestDDT_002_Test extends BaseClass
{
	
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd, String expResult) throws InterruptedException {
		
		// Access URL from the properties file
		String URL=prop.getProperty("url");
		
		// Launch URL
		driver.get(URL);
		
		// Created LoginPage class object to access login page objects
		LoginPage loginpage=new LoginPage(driver);
		
		
		
		if(expResult.equalsIgnoreCase("Valid")) {
		
			
			loginpage.setUserID(uname);
			loginpage.setPassword(pwd);
			loginpage.getLogin();
		
			String expectedHeading="Welcome To Manager's Page of Guru99 Bank";
			String actualHeading=driver.findElement(By.cssSelector("marquee[class='heading3']")).getText();
			
			
			if(expectedHeading.equalsIgnoreCase(actualHeading)) {
				
				Assert.assertTrue(true);
			}
			else {
				
				Assert.assertTrue(false);
				
			}
			
			
			//Thread.sleep(4000);
			waitForElementToBeVisible(By.xpath("//a[normalize-space()='Log out']"));
			
			// click log out
			driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
			
			//Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
			
		
		}
		
		else if(expResult.equalsIgnoreCase("Invalid")) {
			
			loginpage.setUserID(uname);
			loginpage.setPassword(pwd);
			loginpage.getLogin();
			
			Alert alert=driver.switchTo().alert();
			
			if(alert.getText().contains("User or Password is not valid")) {
				
				Assert.assertTrue(true);
				alert.accept();
				
			}
		
			else {
				
				
				// click log out
				driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
				
				//Thread.sleep(2000);
				Alert logoutAlert=driver.switchTo().alert();
				logoutAlert.accept();
				
				
				Assert.assertTrue(false);
				
			}
		

		}
		
		
		
		
		
		
	}

	
	
	@DataProvider(name="LoginData")
	public Object[][] getData() {
		
		Object[][]data= {
				
				
				
				{"mngr47659","1@1","Valid"},
				{"mngr47629","1@2","Invalid"},
				{"mngr47609","1@2","Invalid"},
				
		
		};
		
		return data;
		
		
	}
	
	
	

}
