package com.perficient.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.perficient.core.TestDriver;
import com.perficient.pom.LoginPage;

public class Login extends TestDriver {
	// Object Creation
	LoginPage LP = new LoginPage(driver);

	// Without giving credentials clicking login
	public void clickLogin() throws Exception {

		// waitUntilElementClickable(LP.getLoginButton()); // Explicit Wait
		
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (click(LP.getLoginButton()))
			report("PASS", "login button is clicked", false);
		else
			report("FAIL", "login button is not clicked", true);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

	}

	// Using Click method Entering username
	public void enterUserName(String usernameText) throws Exception {
		waitUntilElementPresent(LP.getUserName());

		if (type(LP.getUserName(), usernameText))
			report("PASS", "Username is entered", false);
		else
			report("FAIL", "Username is not entered", true);

	}

	// Using Click Method Entering incorrect password for Validation
	public void enterPassword(String passwordText) throws Exception {

		waitUntilElementPresent(LP.getPassword());

		if (type(LP.getPassword(), passwordText))
			report("PASS", "password is entered", false);
		else
			report("FAIL", "password is not entered", true);

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

	}

	// Clicking login button
	public void clickLogin1() throws Exception {

		waitUntilElementClickable(LP.getLoginButton());

		if (click(LP.getLoginButton()))
			report("PASS", "login button is clicked", false);
		else
			report("FAIL", "login button is not clicked", true);

		((JavascriptExecutor) driver).executeScript("scroll(0,-300)");

		assertEquals(LP.getIncorrectpassword(), "Error msg is displayed or not");

	}

	// Entering valid password
	public void enterPassword1(String passwordText) throws Exception {

		waitFor(2);

		if (type(LP.getPassword1(), passwordText))
			report("PASS", "password is entered", false);
		else
			report("FAIL", "password is not entered", true);
	}

	// Clicking login button
	public void clickLoginButton() throws Exception {

		assertTrue(LP.getLostpassword(), "lost your password is displayed or not");

		waitUntilElementClickable(LP.getLoginButton());

		if (click(LP.getLoginButton()))
			report("PASS", "login button is clicked", false);
		else
			report("FAIL", "login button is not clicked", true);

		waitFor(2);

	}

}
