package com.revature.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	private WebDriver driver;
	@FindBy(id="search")
	private WebElement searchBtn;

	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo(String websiteUrl) {
		driver.get(websiteUrl);
	}
	
	public String getErrorMessage() {
		WebElement errorMsg = driver.findElement(By.tagName("")); // Doesn't have to be Tag name
		return errorMsg.getText();
	}

	public void clickSearch() {
		searchBtn.click();
	}

	public void searchBook(String string) {
		driver.findElement(By.id("search")).sendKeys(string);	
	}

}
