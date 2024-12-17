package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;
	
	@FindBy(id="first-name")
	private WebElement firstNameField;
	
	@FindBy(id="last-name")
	private WebElement lastNameField;
	
	@FindBy(id="postal-code")
	private WebElement zipCodeField;
	
	@FindBy(id="continue")
	private WebElement checkoutContinueButton;
	
	@FindBy(xpath="//div[@data-test='inventory-item-price']")
	private WebElement inventoryItemPrice;
	
	@FindBy(xpath="//div[@data-test='total-label']")
	private WebElement summaryTotalPrice;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validFillCheckoutForm(String firstname, String lastname, String zipCode) {
		firstNameField.sendKeys(firstname);
		lastNameField.sendKeys(lastname);
		zipCodeField.sendKeys(zipCode);
		checkoutContinueButton.click();
	}

	public boolean checkIfInventoryItemPriceIsVisible() {
		boolean checkInventoryItemPrice =  inventoryItemPrice.isDisplayed();
		return checkInventoryItemPrice;
	}
	
	public boolean checkIfSummaryTotalPriceIsVisible() {
		boolean checkSummaryTotalPrice = summaryTotalPrice.isDisplayed();
		return checkSummaryTotalPrice;
	}
	
	

}
