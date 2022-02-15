package com.revature.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

	private  WebDriver driver;
	
	@FindBy(id="mat-dialog-2") 
	WebElement reviewPopup;
	@FindBy(id="review-card") 
	WebElement reviewTable;
	@FindBy(id="addReview") 
	WebElement reviewAddBtn;
	@FindBy(id="revsubbtn") 
	WebElement submitButton;
	
	@FindBy(id="revtitle") 
	WebElement reviewTitle;
	@FindBy(id="revtext") 
	WebElement reviewText;

	public ReviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddReviewButton() {
		reviewAddBtn.click();
	}

	public void addReview(String string, String string2) {
		WebElement slider = driver.findElement(By.id("slider1"));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, 30, 0).build();
        action.perform();
        
		reviewTitle.sendKeys(string);
		reviewText.sendKeys(string2);
	}

}
