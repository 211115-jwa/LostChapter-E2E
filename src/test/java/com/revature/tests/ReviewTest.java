package com.revature.tests;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

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
	
	@Given("the book information popup shows")
	public void the_book_information_popup_shows() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("mat-dialog-2"),0));

		WebElement popupReview = driver.findElement(By.id("mat-dialog-2"));
		assertNotNull(popupReview.getText());
	}

	@Then("the book information popup will show")
	public void the_book_information_popup_will_show() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("mat-dialog-2"),0));

		WebElement popupReview = driver.findElement(By.id("mat-dialog-2"));
		assertNotNull(popupReview.getText());
	}

	@Then("reviews can be viewed below")
	public void reviews_can_be_viewed_below() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("review-card"),0));

		WebElement popupReview = driver.findElement(By.id("review-card"));
		assertNotNull(popupReview.getText());
	}

	@When("I click on the add review button")
	public void i_click_on_the_add_review_button() {
		reviewPage.clickAddReviewButton();
	}

	@Then("I can enter a review title")
	public void i_can_enter_a_review_title() {
		reviewPage.addReview("Title", "I like this movie a lot");
	}

}
