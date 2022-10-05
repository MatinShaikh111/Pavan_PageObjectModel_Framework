package Pavan_PageObjectModel_TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Pavan_PageObjectModel_PageObjects.LoginPage;
import Pavan_PageObjectModel_PageObjects.NewCustomerPage;

public class TC_AddNewCustomer_003 extends BaseClass
{
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));

		// Do login first
		LoginPage loginPage=new LoginPage(driver);
		
		String userName=prop.getProperty("username");
		loginPage.setUserID(userName);
		
		String password=prop.getProperty("password");
		loginPage.setPassword(password);
		loginPage.getLogin();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
		Thread.sleep(4000);
		
		
		NewCustomerPage newcustomer=new NewCustomerPage(driver);
		newcustomer.setCustName("Tom");
		
		
	}
	
	
	
	

}
