package com.revature.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	private  WebDriver driver;
	
	@FindBy(id="loginBtn")
	private WebElement loginBtn;
	@FindBy(id="loginBtnHeader")
	private WebElement loginBtnHeader;
	@FindBy(id="log-out-btn")
	WebElement logoutBtn;

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
	
	public void enterCredentials(String string, String string2) {
		driver.findElement(By.id("username-login")).sendKeys(string);
		driver.findElement(By.id("password-login")).sendKeys(string2);
	}

}
