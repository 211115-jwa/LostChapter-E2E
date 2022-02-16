package com.revature.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	private  WebDriver driver;
	@FindBy(id="product")
	WebElement product;
	@FindBy(id="qty") 
	WebElement quantity;
	@FindBy(id="delete")
	WebElement delete;
	@FindBy(id="add") 
	WebElement addCart;

	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo(String url) {
		driver.get(url);
	}

	public void clickProduct() {
		//driver.findElement(By.id("product")).click();
		product.getText();
	}

	public void clickQuantity() {
		quantity.click();
	}

	public void clickAddCart() {
		addCart.click();
	}

	public void clickDelete() {
		delete.click();
	}

}

