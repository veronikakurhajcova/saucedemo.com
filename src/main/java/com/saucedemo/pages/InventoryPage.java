package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	WebDriver driver;
	
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement addToCartSauceLabsBackpageButton;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	private WebElement addToCartSauceLabsBikeLightButton;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement addToCartSauceLabsBoltTShirtButton;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	private WebElement addToCartSauceLabsFleeceJacketButton;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	private WebElement addToCartSauceLabsOnesieButton;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	private WebElement addToCartTestAllTheThingsTShirtButton;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	private List<WebElement> addToCartAllProducts;
	
	@FindBy(xpath="//a[contains(@data-test,'shopping-cart-link')]")
	private WebElement shoppingCartLink;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addAllProductsToCart() {
		List<WebElement> products = addToCartAllProducts;
		for (WebElement product : products) {
			product.click();
		}
	}
	
	public void clickOnShoppingCart() {
		shoppingCartLink.click();
	}
	
	public void addProductToCart() {
		addToCartSauceLabsBackpageButton.click();
	}
	
	
	
	
	

}
