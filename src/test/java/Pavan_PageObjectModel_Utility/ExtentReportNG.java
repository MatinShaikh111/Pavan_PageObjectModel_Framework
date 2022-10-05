package Pavan_PageObjectModel_Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	
	
	public ExtentReports getExtentReport() {
		
		
		String path=System.getProperty("user.dir")+"/TestExecutionReport/AutomationReport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Automation Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Matin Shaikh");
		
		return extent;
		
		//extent.createTest(path);
		
		
	}

}
