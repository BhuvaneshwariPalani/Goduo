package com.perficient.objects;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.perficient.core.TestDriver;
import com.perficient.pom.BillingDetailsPage;

public class BillingDetails extends TestDriver {

	BillingDetailsPage BP = new BillingDetailsPage(driver);

	// Clearing and Entering First Name of the User
	public void enterFirstName(String firstnameText) throws Exception {
		// Explicit Wait
		waitUntilElementPresent(BP.getFirstName());
		waitFor(2);
		if (clearText(BP.getFirstName()))
			report("PASS", "Firstname is cleared", false);
		else
			report("FAIL", "Firstname is not cleared", true);

		if (type(BP.getFirstName(), firstnameText))
			report("PASS", "Firstname is entered", false);
		else
			report("FAIL", "Firstname is not entered", true);

	}

	// Ternary operation used for validating FirstName of the User
	public boolean firstname() {
		String X = "Bhuvana";
		String Y = "Bhuvanaa";
		String Firstname = (X != Y ? "True" : "False");
		System.out.println(Firstname);
		return false;
	}

	// Clearing and Entering Last Name of the User
	public void enterLastName(String lastnameText) throws Exception {
		waitUntilElementPresent(BP.getLastName());
		// If-Else Condition Statement used for Generating reports for failed scenario
		// which captures the Screenshots
		if (clearText(BP.getLastName()))
			report("PASS", "Lastname is cleared", false);
		else
			report("FAIL", "Lastname is not cleared", true);

		if (type(BP.getLastName(), lastnameText))
			report("PASS", "Lastname is entered", false);
		else
			report("FAIL", "Lastname is not entered", true);

	}

	// Using Dropdown Method
	public void selectCountry() {

		waitFor(2);
		// Using Switch-Case reusable Dropdown Method for selecting the Country
		selectDropDown(BP.getCountry(), "visibletext", "India");

		// Verification of existing Country List
		List<WebElement> country = driver.findElements(By.xpath("//select[@name='billing_country']"));
		for (WebElement listcountry : country) {
			System.out.println(listcountry.getText());
		}

	}

	// Clearing and Entering street name
	public void enterStreet(String streetText) throws Exception {

		waitFor(2);
		if (clearText(BP.getStreet()))
			report("PASS", "Streetname is cleared", false);
		else
			report("FAIL", "S	treetname is not cleared", true);

		waitFor(2);

		if (type(BP.getStreet(), streetText))
			report("PASS", "Streetname is entered", false);
		else
			report("FAIL", "Streetname is not entered", true);

	}

	// Clearing and Entering apartment
	public void enterApartment(String apartmentText) throws Exception {
		waitUntilElementPresent(BP.getApartment());
		waitFor(2);

		if (clearText(BP.getApartment()))
			report("PASS", "Apartment is cleared", false);
		else
			report("FAIL", "Apartment is not cleared", true);

		waitFor(2);

		if (type(BP.getApartment(), apartmentText))
			report("PASS", "apartment is entered", false);
		else
			report("FAIL", "apartment is not entered", true);

	}

	// Clearing and Entering city
	public void enterCity(String cityText) throws Exception {
		waitUntilElementPresent(BP.getCity());

		waitFor(2);

		if (clearText(BP.getCity()))
			report("PASS", "City is cleared", false);
		else
			report("FAIL", "City is not cleared", true);

		waitFor(2);

		if (type(BP.getCity(), cityText))
			report("PASS", "city is entered", false);
		else
			report("FAIL", "city is not entered", true);

	}

	// Selecting state using dropdown method
	public void selectState() throws Exception {
		waitFor(2);

		selectDropDown(BP.getState(), "visibletext", "Tamil Nadu");

	}

	// Clearing and Entering pincode
	public void enterPincode(String pincodeno) throws Exception {

		waitFor(2);

		if (clearText(BP.getPincode()))
			report("PASS", "Pincode is cleared", false);
		else
			report("FAIL", "Pincode is not cleared", true);

		waitFor(2);

		if (type(BP.getPincode(), pincodeno))
			report("PASS", "Pincode is entered", false);
		else
			report("FAIL", "Pincode is not entered", true);

	}

	// Clearing and Entering phone Number
	public void enterPhoneNo(String phoneno) {

		if (clearText(BP.getPhoneNumber()))
			report("PASS", "Phonenumber is cleared", false);
		else
			report("FAIL", "Phonenumber is not cleared", true);

		if (type(BP.getPhoneNumber(), phoneno))
			report("PASS", "Phonenumber is entered", false);
		else
			report("FAIL", "phonenumber is not entered", true);

	}

	// Clearing and Entering mailid
	public void enterMailid(String mailText) throws Exception {
		waitUntilElementPresent(BP.getEmail());

		waitFor(2);

		if (clearText(BP.getEmail()))
			report("PASS", "Emailid is cleared", false);
		else
			report("FAIL", "Emailid is not cleared", true);

		waitFor(2);
		if (type(BP.getEmail(), mailText))
			report("PASS", "email is entered", false);
		else
			report("FAIL", "email is not entered", true);

	}

	// Verification of checkout page
	public void verifyOrderDetails() throws Exception {

		assertEquals(BP.getProductname(), " Check selected product name is displayed or not");
		assertTrue(BP.getSize(), "Check selected size is displayed or not");
		assertEquals(BP.getSubtotal(), "Check the subtotal is displayed or not");
		assertEquals(BP.getTotal(), "Check total is displayed or not");
		assertTrue(BP.getCheckBox(), "Check checkbox  is displayed or not");
		verifyPresence(BP.getPlaceOrder(), " Check Placeorder button is displayed or not");

	}

	// Clicking checkbox for terms and condition and clicking place an order button
	public void clickPlaceOrder1() throws Exception {

		verifyPresence(BP.getPlaceOrder(), "Place order button is displayed or not ");

		// Scroll Down method using JavaScript
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		if (isDisplayed(BP.getCheckBox())) {

			waitFor(2);

			if (click(BP.getCheckBox()))
				report("PASS", "checkbox  is clicked", false);
			else
				report("FAIL", "checkbox  is not clicked", true);
		}

		waitUntilElementClickable(BP.getPlaceOrder());

		if (click(BP.getPlaceOrder()))
			report("PASS", "Placeorder button is clicked", false);
		else
			report("FAIL", "Placeorder button is not clicked", true);

		waitFor(2);

	}

}
