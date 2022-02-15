package com.revature.models.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class LoginPage {
	
	@FindBy(id="loginBtnHeader")
	private WebElement loginBtnHeader;
	@FindBy(id="log-out-btn")
	WebElement logoutBtn;
	
	@FindBy(id="login-button-logincomponent")
	private WebElement logBtn;
	
	private  WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	public void clickLoginButton() {
		logBtn.click();	
	}
	
	public void enterUsernameAndPassword(String username, String password) {
		driver.findElement(By.id("username-login")).sendKeys(username);
		driver.findElement(By.id("password-login")).sendKeys(password);
	}
	
	public String getLoginText() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5)) 
				.pollingEvery(Duration.ofMillis(100))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOf(logoutBtn));
		return logoutBtn.getText();
	}

	public String getErrorMessage() {
		WebElement errorMsg = driver.findElement(By.id("Error-login")); 
		return errorMsg.getText();
	}

	public void clickLoginHeader() {
		loginBtnHeader.click();
		
	}
	
}
