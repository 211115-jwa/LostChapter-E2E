package com.revature.models.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	private  WebDriver driver;
	
	@FindBy(id="logoutBtn")
	private WebElement logoutBtn;
	@FindBy(id="loginBtn")
	private WebElement loginBtn;

	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo(String string) {
		driver.get(string);
	}
	public void clickLogoutButton() {
		logoutBtn.click();
	}
	public void clickLoginButton() {
		loginBtn.click();
	}

}
