package com.saucedemo.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.base.Base;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.Utils;

public class LoginWithExcelTest extends Base {
	private WebDriver driver;

	LoginPage loginPage;

	public LoginWithExcelTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationUrl(configPropFile.getProperty("browserName"));
		loginPage = new LoginPage(driver);
	}

	@Test(dataProvider = "loginData", dataProviderClass = Utils.class)
	public void verifyLogin(String username, String password, String expectedErrorMessage) {
	
		    if ((username != null && !username.isEmpty()) && (password != null && !password.isEmpty())) {
		       
		        loginPage.loginUser(username, password);
		    } else if (username == null || username.isEmpty()) {
		       
		        loginPage.loginUser("", password);
		    } else if (password == null || password.isEmpty()) {
		       
		        loginPage.loginUser(username, "");
		    } else {
		      
		        Assert.fail("Invalid input: both username and password are null or empty.");
		    }
		if (expectedErrorMessage != null && !expectedErrorMessage.isEmpty()) {
			Assert.assertTrue(loginPage.errorLoginUserMessageIsDisplayed(), "Error message is not displayed");
			Assert.assertEquals(loginPage.errorUserMessageText(), expectedErrorMessage,
					"Error message is not as expected");
		}
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
