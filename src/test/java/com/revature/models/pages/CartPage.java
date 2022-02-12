package com.revature.models.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.revature.models.components.FrontPageComponent;
import com.revature.models.components.NavbarComponent;
import com.revature.models.components.ProductModale;

public class CartPage {
	
private  WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
public void navigateTo() {
	driver.get("http://localhost:4200/cart");
}
	
	
}
