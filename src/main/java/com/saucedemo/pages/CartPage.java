package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	@FindBy(xpath = "//div[contains(@data-test,'inventory-item-name')]")
	private List<WebElement> cartItems;
	
	@FindBy(xpath="//button[contains(@class,'cart_button')]")
	private List<WebElement> removeCartItemsButton; 

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean itemsInCartAreDisplayed() {
		List<WebElement> itemsInCart = cartItems;
		for (WebElement item : itemsInCart) {
			if (!item.isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean itemsInCartAreNotDisplayed() {
		List<WebElement> itemsInCart = cartItems;
		for (WebElement item : itemsInCart) {
			if (item.isDisplayed()) {
				return false;
			}
		}
		return true;
	} 
	
	public void removeCartItems() {
		List<WebElement> itemsInCart = removeCartItemsButton;
		for (WebElement itemInCart : itemsInCart) {
			itemInCart.click();
		}
	}

}
