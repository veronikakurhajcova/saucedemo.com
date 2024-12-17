package com.saucedemo.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.base.Base;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class CartTest extends Base {
	private WebDriver driver;
	LoginPage loginPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	
	public CartTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationUrl(configPropFile.getProperty("browserName"));
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		loginPage.loginUser(dataProp.getProperty("username"), dataProp.getProperty("password"));
	}
	
	@Test(priority=1)
	public void addProductToCart() {
		inventoryPage.addProductToCart();
		inventoryPage.clickOnShoppingCart();
		Assert.assertTrue(cartPage.itemsInCartAreDisplayed(), "Items is not displayed in Cart");
	}
	
	@Test(priority=2)
	public void removeProductFromCart() {
		inventoryPage.addProductToCart();
		inventoryPage.clickOnShoppingCart();
		cartPage.removeCartItems();
		Assert.assertTrue(cartPage.itemsInCartAreNotDisplayed(), "Item is displayed in Cart");
	}
	
	@Test(priority=3)
	public void addAllProductsToCart() {
		inventoryPage.addAllProductsToCart();
		inventoryPage.clickOnShoppingCart();
		Assert.assertTrue(cartPage.itemsInCartAreDisplayed(), "Added Items in Cart are not displayed");
	}
	
	@Test(priority=4)
	public void removeAllProductsFromCart() {
		inventoryPage.addAllProductsToCart();
		inventoryPage.clickOnShoppingCart();
		cartPage.removeCartItems();
		Assert.assertTrue(cartPage.itemsInCartAreNotDisplayed(), "Items in Cart are displayed");
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver !=null) {
			driver.quit();
		}
	}
}
