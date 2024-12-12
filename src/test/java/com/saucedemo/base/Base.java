package com.saucedemo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties configPropFile;
	public Properties dataProp;

	public Base() throws IOException {
		configPropFile = new Properties();
		File configFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties");
		try {
			FileInputStream fis = new FileInputStream(configFile);
			configPropFile.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.properties");
		try {
		FileInputStream dataPropFis = new FileInputStream(dataPropFile);
		dataProp.load(dataPropFis);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-search-engine-choice-screen");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Veronika\\Downloads\\geckodriver-v0.35.0-win64 (1)\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		} else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(configPropFile.getProperty("url"));
		
		return driver;
	
		
	}

}
