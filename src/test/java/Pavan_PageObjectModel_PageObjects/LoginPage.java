package Pavan_PageObjectModel_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage{
	
	
	//1. Initialize driver
	public WebDriver driver;
	
	
	//2. Constructor
	public LoginPage(WebDriver driver) {
		
		
	
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	//3. LoginPage Objects
	
	@FindBy(name="uid")
	WebElement txtUserId;
	
	
	@FindBy(name="password")
	WebElement txtPassowrd;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	
	//4. Action Methods
	
	public void setUserID(String userid) {
		
		txtUserId.sendKeys(userid);
		
	}
	
	
	public void setPassword(String pwd) {
		
		txtPassowrd.sendKeys(pwd);
		
		
	}
	
	
	public void getLogin() {
		
		btnLogin.click();
	}
	
	

}
