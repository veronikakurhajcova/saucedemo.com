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
	private WebElement errorLockedUserMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validLoginUser(String username, String password) {
		inputUsername.sendKeys(username);
		inputUserPassword.sendKeys(password);
		loginSubmitButton.click();
	}
	
	public void loginLockedUser(String username, String password) {
		inputUsername.sendKeys(username);
		inputUserPassword.sendKeys(password);
		loginSubmitButton.click();
	}
	
	public void loginProblemUser(String username, String password) {
		inputUsername.sendKeys(username);
		inputUserPassword.sendKeys(password);
		loginSubmitButton.click();
	}
	
	public boolean errorLoginUserMessageIsDisplayed() {
		boolean errorLockedUserTextMessage = errorLockedUserMessage.isDisplayed();
		return errorLockedUserTextMessage;
	}
	
	public String errorLockedUserMessageText() {
		String errorLockedUserTextMessage = errorLockedUserMessage.getText();
		return errorLockedUserTextMessage;
	}
	
	
}
