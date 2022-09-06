package com.perficient.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.perficient.core.TestDriver;
import com.perficient.pom.OrderDressPage;

public class OrderDress extends TestDriver {
	OrderDressPage OP = new OrderDressPage(driver);

	// Verifying elements using assertions
	public void verifyProduct() throws Exception {
		assertTrue(OP.getProductText(), "product name is visible or not");
		assertTrue(OP.getProductimg(), "product image is visible or not");
		verifyPresence(OP.getFav(), "Favorite symbol is visible or not");
		assertEquals(OP.getComparebtn(), "comparison symbol is visible or not");
		assertPresence(OP.getAddCart(), "comparison symbol is visible or not");

	}

	// Clicking color dropdown
	public void clickColor() throws Exception {

		waitUntilElementClickable(OP.getColor());

		if (click(OP.getColor()))
			report("PASS", "dropdown is clicked", false);
		else
			report("FAIL", "dropdown is not clicked", true);

	}

	// Select color using dropdown method
	public void selectColors() {
		waitFor(2);
		selectDropDown(OP.getColor(), "visibletext", "Black");
		String color[] = { "Red", "Black", "White" };
		for (int i = 0; i < color.length; i++) {
			System.out.println("Color ==> " + color[i]);
		}

	}

	// Clicking size dropdown
	public void clickSize() throws Exception {

		waitUntilElementClickable(OP.getSize());

		if (click(OP.getSize()))
			report("PASS", "dropdown is clicked", false);
		else
			report("FAIL", "dropdown is not clicked", true);

	}

	// select size using dropdown
	public void selectSize() throws Exception {
		waitFor(2);

		selectDropDown(OP.getSize(), "visibletext", "L");

	}

	// Clicking quantity
	public void clickQuantity() throws Exception {

		waitUntilElementClickable(OP.getQuantity());

		if (click(OP.getQuantity()))
			report("PASS", "adding same product", false);
		else
			report("FAIL", "adding same product or not ", true);

	}

	// Clicking addtocart button
	public void clickAddToCart() throws Exception {

		waitUntilElementClickable(OP.getAddCart());

		if (click(OP.getAddCart()))
			report("PASS", "add to cart is clicked", false);
		else
			report("FAIL", "add to cart is not clicked", true);
		waitFor(2);

	}

	// Clicking viewcart for navigating to cart page
	public void clickViewCart() throws Exception {

		waitUntilElementClickable(OP.getViewCart());

		if (click(OP.getViewCart()))
			report("PASS", "viewcart button is clicked", false);
		else
			report("FAIL", "viewcart button is not clicked", true);
		waitFor(2);

	}

}