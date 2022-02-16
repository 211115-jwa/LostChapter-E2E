package com.revature.tests;

import java.io.File;

import com.revature.models.pages.LoginPage;
import com.revature.models.pages.LogoutPage;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutTest {

	private static LogoutPage LogoutPage;

	private static WebDriver driver;
	private WebDriverWait wdw;
	private String websiteUrl = "http://localhost:4200/home";
	private LogoutPage logoutPage;
	private LoginPage loginPage;

	@BeforeAll
	public static void setUpDriver()
	{
		File file = new File("src/test/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		LogoutPage = new LogoutPage(driver);
	}
	
	@AfterEach
	public void teardown() {

		driver.close();
		driver.quit();	
	}
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		logoutPage.navigateTo(this.websiteUrl);
	}

	@When("the user click the logout button")
	public void the_user_click_the_logout_button() {
		logoutPage.clickLogoutButton();
	}

	@Then("the user should be redirected to the Home page")
	public void the_user_should_be_redirected_to_the_home_page() {
		logoutPage.navigateTo(websiteUrl);
	}
	
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
	
	
	
}