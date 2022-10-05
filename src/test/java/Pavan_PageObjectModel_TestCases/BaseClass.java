package Pavan_PageObjectModel_TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	//1. driver
	public static WebDriver driver;
	public static Logger logger;
	public static Properties prop;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws IOException {

		prop=new Properties();
		String projectPath=System.getProperty("user.dir");
		System.out.println("projectPath :"+projectPath);
		FileInputStream file=new FileInputStream(projectPath+"/config.properties");
		prop.load(file);

		logger=Logger.getLogger("Pavan_PageObjectModel_Framework");
		PropertyConfigurator.configure("Log4j.properties");


		if(browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}

		else if(browser.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();

		}


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		

		


	}





	@AfterClass
	public void tearDown() {

		driver.quit();

	}

	public String takeScreenshot(String testCaseName) throws IOException {


		// Take Screenshot

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//Screenshots"+testCaseName+".png");
		FileUtils.copyFile(source, file);

		return System.getProperty("user.dir")+"//Screenshots"+testCaseName+".png";
	}

	public void waitForElementToBeVisible(By locator) {


		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}


}
