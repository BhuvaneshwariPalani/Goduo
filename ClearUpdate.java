package com.perficient.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.perficient.core.TestDriver;
import com.perficient.pom.ClearUpdatePage;
//This class has been covered with Interface Concept
public class ClearUpdate extends TestDriver {

	ClearUpdatePage CP = new ClearUpdatePage(driver);

	// Using Click method for clearing selected product
	public void clearingProduct() throws Exception {
		waitUntilElementClickable(CP.getClearCart());

		if (click(CP.getClearCart()))
			report("PASS", "Clearcart is clicked", false);
		else
			report("FAIL", "Clearcart is not clicked", true);

	}

	// Using click method returnshop action is performing
	public void clickReturnShop() throws Exception {
		waitUntilElementClickable(CP.getReturnShop());

		if (click(CP.getReturnShop()))
			report("PASS", "Returnshop is clicked", false);
		else
			report("FAIL", "Returnshop is not clicked", true);

	}

	// Using Click Method selecting the new Product (eg:T-Shirt)
	public void clickTShirt() throws Exception {
		waitUntilElementClickable(CP.gettShirt());

		if (click(CP.gettShirt()))
			report("PASS", "T-Shirt is clicked", false);
		else
			report("FAIL", "T-Shirt is not clicked", true);

	}

	// Using Click Method in Color Dropdown
	public void clickShirtColor() throws Exception {
		waitUntilElementClickable(CP.getShirtColor());

		if (click(CP.getShirtColor()))
			report("PASS", "Shirtcolor dropdown is clicked", false);
		else
			report("FAIL", "Shirtcolor dropdown is not clicked", true);

	}

	// Using Dropdown method Selecting T shirt color
	public void selectShirtColor() {
		waitFor(2);
		selectDropDown(CP.getShirtColor(), "visibletext", "Black");

	}

	// Using Click Method in Size dropdown
	public void clickShirtSize() throws Exception {
		waitUntilElementClickable(CP.getShirtSize());

		if (click(CP.getShirtSize()))
			report("PASS", "ShirtSize dropdown is clicked", false);
		else
			report("FAIL", "ShirtSize dropdown is not clicked", true);

	}

	// Using dropdown method Selecting T shirt size
	public void selectShirtSize() {
		waitFor(2);
		selectDropDown(CP.getShirtSize(), "visibletext", "34");
		String size[] = { "32", "34", "36" };

		for (String sizeno : size) {
			System.out.println("Size ==> " + sizeno);
		}
	}

	// Using Click method adding item to add to cart
	public void clickAddCart1() throws Exception {
		waitUntilElementClickable(CP.getAddCart1());

		if (click(CP.getAddCart1()))
			report("PASS", "AddCart1 button is clicked", false);
		else
			report("FAIL", "AddCart1 button is not clicked", true);
		waitFor(2);

	}

	// Usinf Click method navigating to Viewcart page
	public void clickViewCart1() throws Exception {
		waitUntilElementClickable(CP.getViewCart1());

		if (click(CP.getViewCart1()))
			report("PASS", "ViewCart1 button is clicked", false);
		else
			report("FAIL", "ViewCart1 button is not clicked", true);
		waitFor(2);

	}

	// Using Click Method selecting the quantity range
	public void clickQuantity1() throws Exception {

		// Using JavaScript performing Scroll down option
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		waitUntilElementClickable(CP.getQuantity1());

		if (click(CP.getQuantity1()))
			report("PASS", "quantity1 plus button is clicked", false);
		else
			report("FAIL", "quantity1 plus button is not clicked", true);
		waitFor(2);

	}

	// Using Click method updating the amount in the Cart
	public void clickUpdate() throws Exception {
		// Using JavaScript performing Scroll down option
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		waitUntilElementClickable(CP.getUpdateCart());

		if (click(CP.getUpdateCart()))
			report("PASS", " UpdateCart  button is clicked", false);
		else
			report("FAIL", " UpdateCart  button is not clicked", true);
		waitFor(2);

	}

	// Verifying elements in the cart page
	public void verifyCartPage() throws Exception {

		((JavascriptExecutor) driver).executeScript("scroll(0,700)");

		assertEquals(CP.getProductname(), "Chosen product name is displayed or not");
		assertTrue(CP.getSize(), "Chosen Product size is displayed or not");
		assertTrue(CP.getClearCart(), "Clearcart button is displayed or not");
		assertTrue(CP.getUpdateCart(), "Updatecart button is displayed or not");
		verifyPresence(CP.getContinueshop(), "continue shop button is displayed or not");
		assertPresence(CP.getSubtotal(), "Subtotal  is displayed or not");
		assertPresence(CP.getTotal(), "Total is displayed or not");
		assertTrue(CP.getCheckOut(), "checkout button is displayed or not");

	}

	// Using Type method entering invalid coupon code
	public void enterCoupon(String couponTxt) throws Exception {
		waitUntilElementClickable(CP.getCoupon());

		if (type(CP.getCoupon(), couponTxt))
			report("PASS", "Success", false);
		else
			report("FAIL", "Not successful", true);

	}

	// Using Click method selecting the coupon
	public void clickCoupon() throws Exception {

		if (click(CP.getApplycoupon()))
			report("PASS", "Apply coupon button is clicked", false);
		else
			report("FAIL", "Apply coupon  is not clicked", true);

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		// Verification of Invalid Coupon Value
		assertTrue(CP.getCouponerror(), "Error msg is displayed or not");
	}

	// Using Click Method for checkout button
	public void clickCheckOut() throws Exception {
		waitUntilElementClickable(CP.getCheckOut());

		if (click(CP.getCheckOut()))
			report("PASS", " CheckOut button is clicked", false);
		else
			report("FAIL", " CheckOut  button is not clicked", true);

	}

}
