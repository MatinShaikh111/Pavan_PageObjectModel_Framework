package Pavan_PageObjectModel_Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pavan_PageObjectModel_TestCases.BaseClass;

public class Listeners extends BaseClass implements ITestListener{
	
	ExtentTest test;
	String filePath;
	ExtentReports extent;

	@Override
	public void onTestStart(ITestResult result) {
		
		
		// Created ExtentReportNG class object where ExtentReport code is written
		ExtentReportNG extentreportng=new ExtentReportNG();
		
		// Call getExtentReport() method which is present inside the ExtentReportNG class
		 extent=extentreportng.getExtentReport();
		 // This code tells to start creating an extent report once @Test started
		 test=extent.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test case passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// It will give console error message
		test.fail(result.getThrowable());  // 
		try {
			
			//called takeScreenshot from BaseClass
			filePath=takeScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filePath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

	
	
	
	
	
}
