package com.perficient.objects;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.perficient.core.TestDriver;
import com.perficient.pom.SearchProductPage;

public class SearchProduct extends TestDriver {

	SearchProductPage SP = new SearchProductPage(driver);

	// Verify the texts and clicking search icon
	public void clickSearchButton() throws Exception {

		// Using JavaScript Performing Scroll Down
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		verifyPresence(SP.getHelloname(), "hello name text is displayed or not"); // Negative Scenario failing by known
		assertTrue(SP.getDashboard(), "Dashboard text is visible or not");
		assertEquals(SP.getOrders(), "orders text is visible or not");
		assertEquals(SP.getDownloads(), "Downloads text is visible or not ");
		assertPresence(SP.getAddress(), "Address text is visible or not ");
		verifyPresence(SP.getAccountdetails(), "Accountdetails text is visible or not ");
		verifyPresence(SP.getLogout(), "Logout text is visible or not ");
		waitFor(2);

		// Using JavaScript Performing Scroll up
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
		waitFor(2);

		waitUntilElementClickable(SP.getSearchButton());

		if (click(SP.getSearchButton()))
			report("PASS", "search button is clicked", false);
		else
			report("FAIL", "search button is not clicked", true);

	}

	// Entering product name in search icon
	public void productSearch(String productText) throws Exception {

		verifyPresence(SP.getProductSearch(), "searching product is possible or not ");

		if (type(SP.getProductSearch(), productText))
			report("PASS", "product searching is possible ", false);
		else
			report("FAIL", "product searching is not possible", true);

	}

	// Pressing enter key using Robot Class
	public void pressEnter() throws Exception {
		waitFor(2);
		Robot(SP.getTokyoTalkies());
		waitFor(2);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

	}

}
