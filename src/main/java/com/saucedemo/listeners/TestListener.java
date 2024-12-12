package com.saucedemo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " testing is starting");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " is successfull");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " is failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Testing is finished");
	}
	

}
