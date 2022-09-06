package com.perficient.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.perficient.core.TestDriver;
import com.perficient.pom.LogOutPage;

public class LogOut extends TestDriver {

	LogOutPage LP = new LogOutPage(driver);

	// Verify text present after place an order
	public void verifyText() throws Exception {
		waitFor(2);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		assertTrue(LP.getThanku(), " Check an Order is placed or not");

		// Using JavaScript performing Scroll up
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
	}

	// Ternary operator used for validating Thankyou Message
	public boolean orderMsg() {
		String X = "Thankyou";
		String Y = "Thankyou";
		String ordermsg = (X == Y ? "True" : "False");
		System.out.println(ordermsg);
		return false;
	}

	// Clicking my account element
	public void clickingMyAccount() throws Exception {

		waitUntilElementClickable(LP.getMyAccount1());

		if (click(LP.getMyAccount1()))
			report("PASS", "MyAccount is clicked", false);
		else
			report("FAIL", "MyAccount is not clicked", true);

	}

	// Clicking logout element
	public void clickingLogOut() throws Exception {

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

		waitUntilElementClickable(LP.getLogOut());

		if (click(LP.getLogOut()))
			report("PASS", "Logout is clicked", false);
		else
			report("FAIL", "Logout is not clicked", true);

	}

}
