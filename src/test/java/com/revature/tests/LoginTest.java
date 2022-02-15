package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.models.pages.LoginPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	private static WebDriver driver;
	private String websiteUrl = "localhost:4200/login";
	private static LoginPage loginPage;
	

	@BeforeAll
	public static void setUpDriver(){
		File file = new File("src/test/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
	}
	
	@AfterEach
	public void teardown() {
		
		this.driver.close();
		this.driver.quit();	
	}
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		loginPage.navigateTo(websiteUrl);
	}

	@When("I enter {string} and {string} to log in")
	public void i_enter_and_to_log_in(String string, String string2) {
		loginPage.enterUsernameAndPassword(string, string2);
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("the username link should contain {string}")
	public void the_username_link_should_contain(String string) {
		String linkText = loginPage.getLoginText();
	    assertEquals(string + " ", linkText);
	    loginPage.clickLoginButton();
	}

	@When("I enters an incorrect {string} and {string}")
	public void i_enters_an_incorrect_and(String string, String string2) {
		loginPage.enterUsernameAndPassword(string, string2);
	}

	@Then("the appropriate error message should appear")
	public void the_appropriate_error_message_should_appear() {
		String errorMsg = loginPage.getErrorMessage();
	    assertTrue(errorMsg.contains("Invalid Credentials"));
	}
	
	@Given("I click the login button in the Header")
	public void i_click_the_login_button_in_the_header() {
		loginPage.clickLoginHeader();
	}



/*
 * 	@Given("I am at the login page")
	public void i_am_at_the_login_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");

		this.driver = new ChromeDriver();

		this.driver.get("http://localhost:4200/login");
		this.loginPage = new LoginPage(driver);
		this.loginPage.navbar.clickLoginButton();

	}

	@When("I type in a username of {string}")
	public void i_type_in_a_username_of(String string) {
		this.loginPage.login.setUsernameText(string);
	}

	@When("I type in the password  {string}")
	public void i_type_in_the_password(String string) {
		this.loginPage.login.setPasswordText(string);
	}

	@When("I click the Login button")
	public void i_click_the_login_button() {
		this.loginPage.login.clickLoginButton();
	}

	@Then("I should be taken to the main page and see username {string} and profile picture")
	public void i_should_be_taken_to_the_main_page_and_see_username_and_profile_picture(String string) {
		
		Assertions.assertEquals(string, this.loginPage.navbar.getCurrentUserUsername());
	}

	@Then("I should be given an error message of {string}")
	public void i_should_be_given_an_error_message_of(String string) {
		
		Assertions.assertEquals(string, this.loginPage.login.getErrorMessage());
	}


	@Then("I should be sent to the admin page")
	public void i_should_be_sent_to_the_admin_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("I am not logged in")
	public void i_am_not_logged_in() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should not see a username and profile picture #might be guest")
	public void i_should_not_see_a_username_and_profile_picture_might_be_guest() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

 */

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		loginPage.navigateTo(websiteUrl);
	}
	
	@When("the user enters {string} and {string} to log in")
	public void the_user_enters_and_to_log_in(String username, String password) {
		loginPage.enterUsernameAndPassword(username, password);
	}
	
	@When("the user clicks the submit button")
	public void the_user_clicks_the_submit_button() {
		loginPage.clickLoginButton();
	}
	
	@Then("the navbar says {string}")
	public void the_navbar_says(String username) {
		String linkText = loginPage.getLoginText();
		assertEquals(username + " ", linkText);
		loginPage.clickLogoutButton();
	}
	
	@Then("the page says Incorrect Credentials")
	public void the_page_says_incorrect_credentials() {
		String errorMsg = loginPage.getErrorMessage();
	    assertTrue(errorMsg.contains("Invalid Credentials"));
	}
	
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
}
