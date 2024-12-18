package com.saucedemo.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.saucedemo.utilities.ExtentReport;


public class TestListener implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest("Automation saucedemo test");
		extentTest.log(Status.INFO, result.getName() + "start executing");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName() + " is successfull");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, result.getName() + " is failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getName() + " is skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		try {
			extentReport = ExtentReport.generateExtentReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();	
		
		String pathOfExtentReports = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReports);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
