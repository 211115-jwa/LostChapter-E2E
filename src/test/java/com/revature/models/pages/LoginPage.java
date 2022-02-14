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
	
	@FindBy(id="username")
	private WebElement usernameInput;
	@FindBy(id="passwd")
	private WebElement passwordInput;
	@FindBy(id="loginBtn")
	private WebElement loginBtn;
	@FindBy(id="sL")
	private WebElement logBtn;
	@FindBy(id="usernameLink")
	WebElement usernameLink;
	
	private  WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	public void clickLoginButton() {
		loginBtn.click();	
	}
	
	public void enterUsernameAndPassword(String username, String password) {
		
		//usernameInput.sendKeys(username);
		//passwordInput.sendKeys(password);
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("passwd")).sendKeys(password);
	}
	
	public String getLoginText() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5)) // .withTimeout(5, TimeUnit.SECONDS)
				.pollingEvery(Duration.ofMillis(100))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOf(usernameLink));
		return usernameLink.getText();
	}

	public String getErrorMessage() {
		WebElement errorMsg = driver.findElement(By.tagName("")); // Doesn't have to be Tag name
		return errorMsg.getText();
	}
	
}


//public NavbarComponent navbar;
//public LoginComponent login; 
//public static String pageUrl = "";
//
//
//public LoginPage(WebDriver driver) {
//	
//	this.navbar = new NavbarComponent(driver);
//	this.login = new LoginComponent(driver);
//	
//}