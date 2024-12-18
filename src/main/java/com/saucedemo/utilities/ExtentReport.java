package com.saucedemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports generateExtentReport() throws IOException {
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		
	
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setReportName("Saucedemo Automation Reesults");
		sparkReporter.config().setTimeStampFormat("dd/mm/yyyyhh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties prop = new Properties();
		File configFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties");
		try {
			FileInputStream fis = new FileInputStream(configFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Tester", "Veronika");
		extentReport.setSystemInfo("Browser name", prop.getProperty("browserName"));
		extentReport.setSystemInfo("URL:", prop.getProperty("url"));
		
		return extentReport;
		
	}
}
