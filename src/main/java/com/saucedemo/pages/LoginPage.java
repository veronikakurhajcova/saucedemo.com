package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="user-name")
	private WebElement inputUsername;
	
	@FindBy(id="password")
	private WebElement inputUserPassword;
	
	@FindBy(id="login-button")
	private WebElement loginSubmitButton;
	
	@FindBy(xpath="//h3[contains(@data-test,'error')]")
	private WebElement errorUserMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginUser(String username, String password) {
		inputUsername.sendKeys(username);
		inputUserPassword.sendKeys(password);
		loginSubmitButton.click();
	}
	
	public boolean errorLoginUserMessageIsDisplayed() {
		boolean errorLockedUserTextMessage = errorUserMessage.isDisplayed();
		return errorLockedUserTextMessage;
	}
	
	public String errorUserMessageText() {
		String errorLockedUserTextMessage = errorUserMessage.getText();
		return errorLockedUserTextMessage;
	}
	
	public void loginUserWithEmptyCredentials() {
		inputUsername.sendKeys("");
		inputUserPassword.sendKeys("");
		loginSubmitButton.click();
	}
	
	public void loginWithEmptyUsernameField(String password) {
		inputUsername.sendKeys("");
		inputUserPassword.sendKeys(password);
		loginSubmitButton.click();
	}
	
	public void loginWithEmptyPasswordField(String username) {
		inputUsername.sendKeys(username);
		inputUserPassword.sendKeys("");
		loginSubmitButton.click();
	}
	
	
}
