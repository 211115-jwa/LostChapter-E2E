package com.revature.tests;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.models.pages.ReviewPage;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReviewTest {


	private static WebDriver driver;
	private String websiteUrl = "localhost:4200/home";
	private static ReviewPage reviewPage;


	@BeforeAll
	public static void setUpDriver(){
		File file = new File("src/test/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		reviewPage = new ReviewPage(driver);
	}

	@AfterEach
	public void teardown() {

		this.driver.close();
		this.driver.quit();	
	}

	@When("I click on a product on the front page")
	public void i_click_on_a_product_on_the_front_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the book information popup will show")
	public void the_book_information_popup_will_show() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("reviews can be viewed below")
	public void reviews_can_be_viewed_below() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on the add review button")
	public void i_click_on_the_add_review_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I can enter a review title")
	public void i_can_enter_a_review_title() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
