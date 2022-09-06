package com.perficient.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.perficient.core.TestDriver;
import com.perficient.pom.HomePage;

public class Home extends TestDriver {

	HomePage HP = new HomePage(driver);

	// HomePage Verification
	public void dismissButton() throws Exception {

		assertTrue(HP.getDismissbtn(), "Displaying dismissbtn");
		
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		// Using Click Method closing the alert message
		if (click(HP.getDismissbtn()))
			report("PASS", "Displaying dismiss text", false);
		else
			report("FAIL", "Not displaying dismiss text", true);

		// Using JavaScript performing Scroll Down
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

		// Verification of Homepage using assertion
		verifyPresence(HP.getMailid1(), "maild is displayed or not");
		verifyPresence(HP.getPhonenum(), "Phoneno is displayed or not");
		verifyPresence(HP.getWishlist(), "wishlist is displayed or not");
		verifyPresence(HP.getShoptools(), "shoptools image is displayed or not");
		verifyPresence(HP.getShopnow(), "shopnow is displayed or not");
		verifyPresence(HP.getAccount(), "Myaccount is displayed or not");
		verifyPresence(HP.getCheckout(), "Checkout is displayed or not");
		verifyPresence(HP.getCart(), "Cart is displayed or not");
	}

}