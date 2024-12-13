package com.saucedemo.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.base.Base;
import com.saucedemo.pages.LoginPage;

public class LoginTest extends Base {
	private WebDriver driver;

	LoginPage loginPage;

	public LoginTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationUrl(configPropFile.getProperty("browserName"));
		loginPage = new LoginPage(driver);
	}

	@Test(priority=1)
	public void loginValidUser() {
		loginPage.loginUser(dataProp.getProperty("username"), dataProp.getProperty("password"));
		Assert.assertEquals(driver.getCurrentUrl(), dataProp.getProperty("urlAfterLogin"), "Url is not match");
	}

	@Test(priority=2)
	public void loginLockedUser() {
		loginPage.loginUser(dataProp.getProperty("lockedUsername"), dataProp.getProperty("password"));
		Assert.assertEquals(driver.getCurrentUrl(), configPropFile.getProperty("url"), "Url is not match");
		Assert.assertTrue(loginPage.errorLoginUserMessageIsDisplayed(), "Error message is not displayed");
		Assert.assertEquals(loginPage.errorUserMessageText(), dataProp.getProperty("errorLockedUserMessage"));
	}

	@Test(priority=3)
	public void loginProblemUser() {
		loginPage.loginUser(dataProp.getProperty("problemUser"), dataProp.getProperty("password"));
		Assert.assertEquals(driver.getCurrentUrl(), dataProp.getProperty("urlAfterLogin"),
				"Url after login problem user is not match");
	}

	@Test(priority=4)
	public void loginPerformanceUser() {
		loginPage.loginUser(dataProp.getProperty("performanceUser"), dataProp.getProperty("password"));
		Assert.assertEquals(driver.getCurrentUrl(), dataProp.getProperty("urlAfterLogin"), "Url is not match");
	}

	@Test(priority=5)
	public void loginErrorUser() {
		loginPage.loginUser(dataProp.getProperty("errorUser"), dataProp.getProperty("password"));
		Assert.assertEquals(driver.getCurrentUrl(), dataProp.getProperty("urlAfterLogin"), "Url is not match");
	}

	@Test(priority=6)
	public void loginVisualUser() {
		loginPage.loginUser(dataProp.getProperty("visualUser"), dataProp.getProperty("password"));
		Assert.assertEquals(driver.getCurrentUrl(), dataProp.getProperty("urlAfterLogin"), "Url is not match");
	}
	
	@Test(priority=7)
	public void loginWithEmptyCredentials() {
		loginPage.loginUserWithEmptyCredentials();
		Assert.assertTrue(loginPage.errorLoginUserMessageIsDisplayed(), "Error message is not displayed");
	}
	
	@Test(priority=8)
	public void loginWithEmptyUsernameField() {
		loginPage.loginWithEmptyUsernameField(dataProp.getProperty("password"));
		Assert.assertTrue(loginPage.errorLoginUserMessageIsDisplayed(), "Error message for empty username is not displayed");
		Assert.assertEquals(loginPage.errorUserMessageText(), dataProp.getProperty("errorLoginUsernameMessage"));
	}
	
	@Test(priority=9)
	public void loginWithEmptyPasswordField() {
		loginPage.loginWithEmptyPasswordField(dataProp.getProperty("username"));
		Assert.assertTrue(loginPage.errorLoginUserMessageIsDisplayed(), "Error message for empty password is not displayed");
		Assert.assertEquals(loginPage.errorUserMessageText(), dataProp.getProperty("errorLoginPasswordMessage"));
	}
	
	@Test(priority=10)
	public void loginWithInvalidUsername() {
		loginPage.loginUser(dataProp.getProperty("invalidUsername"), dataProp.getProperty("password"));
		Assert.assertTrue(loginPage.errorLoginUserMessageIsDisplayed(), "Error message for invalid username is not displayed");
		Assert.assertEquals(loginPage.errorUserMessageText(), dataProp.getProperty("errorLoginInvalidUsernameAndPasswordMessage"));
	}
	
	@Test(priority=11)
	public void loginWithInvalidPassword() {
		loginPage.loginUser(dataProp.getProperty("username"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.errorLoginUserMessageIsDisplayed(), "Error message for invalid username is not displayed");
		Assert.assertEquals(loginPage.errorUserMessageText(), dataProp.getProperty("errorLoginInvalidUsernameAndPasswordMessage"));
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
