package Pavan_PageObjectModel_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewCustomerPage {


	// 1 driver initialization

	WebDriver driver;


	//2. Constructor

	public NewCustomerPage(WebDriver driver) {

		driver=this.driver;
		PageFactory.initElements(driver, this);


	}

	//3. Page Objects

	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement newcustomer;

	@FindBy(name="name")
	WebElement custName;

	@FindBy(name="rad1")
	WebElement gender;


	@FindBy(id="dob")
	WebElement dob;

	@FindBy(name="addr")
	WebElement address;

	@FindBy(name="city")
	WebElement city;

	@FindBy(name="state")
	WebElement state;

	@FindBy(name="pinno")
	WebElement pin;

	@FindBy(name="telephoneno")
	WebElement mobNo;

	@FindBy(name="emailid")
	WebElement email;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="sub")
	WebElement submit;


	//4. Action Methods

	public void clickNewCust() {

		newcustomer.click();
	}


	public void setCustName(String customerName) {

		custName.sendKeys(customerName);

	}

	public void setGender() {

		gender.click();

	}

	public void setDob(String date) {

		dob.sendKeys(date);
	}


	public void setAddress(String addr) {

		address.sendKeys(addr);
	}


	public void setCity(String cityName) {

		city.sendKeys(cityName);

	}

	public void setState(String stateName) {

		state.sendKeys(stateName);

	}


	public void setPin(String pinNo) {

		pin.sendKeys(pinNo);

	}


	public void setMobNo(String mobNum) {

		mobNo.sendKeys(mobNum);

	}

	public void setEmail(String emailAdd) {

		email.sendKeys(emailAdd);

	}

	public void setPassword(String pwd) {

		password.sendKeys(pwd);

	}

	public void clickSubmit() {

		submit.click();
	}





}
