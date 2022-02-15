package com.revature.models.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	private  WebDriver driver;

	//	@FindBy(id="featuredbooks")
	//	private WebElement featureDisplay;
	//	
	//	@FindBy(id="booktitlegenre")
	//	private WebElement genreDisplay;
	//	
	//	@FindBy(id="salebooks")
	//	private WebElement saleDisplay;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo() {
		driver.get("http://localhost:4200/home");
	}
}
