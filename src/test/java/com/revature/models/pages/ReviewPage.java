package com.revature.models.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

	private  WebDriver driver;
	
	@FindBy(id="mat-dialog-2") 
	WebElement review;
	@FindBy(id="review-card") 
	WebElement reviewCard;
	@FindBy(id="addReview") 
	WebElement reviewAddBtn;
	@FindBy(id="revtitle") 
	WebElement reviewTxtbox;
	@FindBy(id="revsubbtn") 
	WebElement submitButton;

	public ReviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo(String websiteUrl) {
		// TODO Auto-generated method stub
		
	}

}
