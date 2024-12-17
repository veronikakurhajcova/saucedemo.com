package com.saucedemo.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.base.Base;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class ShoppingAndOrderPlacementTest extends Base {
	WebDriver driver;
	LoginPage loginPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;

	
	public ShoppingAndOrderPlacementTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = initializeBrowserAndOpenApplicationUrl(configPropFile.getProperty("browserName"));
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		
	}
	
	@Test
	public void verifySuccessfulPurchaseFlow() throws IOException {
		loginPage.loginUser(dataProp.getProperty("username"), dataProp.getProperty("password"));
		inventoryPage.addProductToCart();
		inventoryPage.clickOnShoppingCart();
		cartPage.clickOnCheckoutButton();
		checkoutPage.validFillCheckoutForm(dataProp.getProperty("checkoutFirstname"),
				dataProp.getProperty("checkoutLastname"),
				dataProp.getProperty("checkoutZipCode"));
		
		Assert.assertTrue(checkoutPage.checkIfInventoryItemPriceIsVisible(), "Inventory Price is not visible");
		Assert.assertTrue(checkoutPage.checkIfSummaryTotalPriceIsVisible(), "Summary total price is not visible");
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	

}
