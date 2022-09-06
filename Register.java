package com.perficient.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.perficient.core.TestDriver;
import com.perficient.pom.RegisterPage;

public class Register extends TestDriver {

	RegisterPage RP = new RegisterPage(driver);

	// Using Click Method selecting MyAccount
	public void clickAccount() throws Exception {

		waitUntilElementClickable(RP.getMyAccount());

		if (click(RP.getMyAccount()))
			report("PASS", "MyAccount is displayed", false);
		else
			report("FAIL", "MyAccount is not displayed", true);

	}

	// New User Registration
	public void clickRegister() throws Exception {

		waitUntilElementClickable(RP.getRegisterButton());

		if (click(RP.getRegisterButton()))
			report("PASS", "register button is clicked", false);
		else
			report("FAIL", "register button is not clicked", true);

		waitFor(2);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

		assertPresence(RP.getRegister(), "Error msg is displayed or not");

	}

	// User Name Creation
	public void enterUserName(String userNameText) throws Exception {
		waitUntilElementPresent(RP.getUserName());

		if (type(RP.getUserName(), userNameText))
			report("PASS", "Username is entered", false);
		else
			report("FAIL", "Username is not entered", true);

	}

	// Entering Email Id for new user creation
	public void enterEmail(String emailText) throws Exception {
		waitUntilElementPresent(RP.getEmail());

		if (type(RP.getEmail(), emailText))
			report("PASS", "mail is entered", false);
		else
			report("FAIL", "mail is not entered", true);

	}

	// Providing password for new user creation
	public void enterPassword(String passwordText) throws Exception {
		waitUntilElementPresent(RP.getPassword());

		if (type(RP.getPassword(), passwordText))
			report("PASS", "password is entered", false);
		else
			report("FAIL", "password is not entered", true);

	}

	// Verification of Password Visibility
	public void clickingShow() throws Exception {
		waitUntilElementClickable(RP.getShow());

		if (click(RP.getShow()))
			report("PASS", "passwordtxt is shown", false);
		else
			report("FAIL", "passwordtxt is not shown", true);

	}

	// Confirmation New User Registration
	public void clickRegisterButton() throws Exception {

		waitUntilElementClickable(RP.getRegisterButton());

		if (click(RP.getRegisterButton()))
			report("PASS", "register button is clicked", false);
		else
			report("FAIL", "register button is not clicked", true);

	}

}
