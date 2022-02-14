package com.revature.tests;

import java.io.File;

import com.revature.models.pages.LoginPage;
import com.revature.models.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutTest {

	private static LogoutPage LogoutPage;

	private static WebDriver driver;
	private WebDriverWait wdw;
	private String websiteUrl = "localhost:4200";
	private String homeUrl = "localhost:4200/home";
	private LogoutPage logoutPage;

	@BeforeAll
	public static void setUpDriver()
	{
		File file = new File("src/test/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		LogoutPage = new LogoutPage(driver);
	}

	@Given("I am at the Home page")
	public void i_am_at_the_home_page() {
		logoutPage.navigateTo(websiteUrl);
	}
	
	@Given("I click the login button")
	public void i_click_the_login_button() {
		logoutPage.clickLoginButton();
	}

	@When("I click the logout button")
	public void i_click_the_logout_button() {
		logoutPage.clickLogoutButton();
	}

	@Then("I should be redirected to the Home page")
	public void i_should_be_redirected_to_the_home_page() {
		logoutPage.navigateTo(homeUrl);
	}
}
