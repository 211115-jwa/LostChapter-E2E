package com.revature.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.models.pages.SearchResultPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTest {

	private static WebDriver driver;
	private static WebDriverWait wait;
	private String websiteUrl = "localhost:4200/home";
	private String searchURL = "localhost:4200/search-results/";
	String badBook = "Harry Potter and the Adventures of Hermione";
	String goodBook = "Harry Potter and the Goblet of Fire";

	private static SearchResultPage searchResultPage;

	@BeforeAll
	public static void setUpDriver()
	{
		File file = new File("src/test/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		searchResultPage = new SearchResultPage(driver);
	}

	@When("I enters an correct book on the search bar")
	public void i_enters_an_correct_book_on_the_search_bar() {
		searchResultPage.searchBook(goodBook);
	}

	@When("I click search")
	public void i_click_search() {
		searchResultPage.clickSearch();
	}

	@When("I enters an incorrect book on the search bar")
	public void i_enters_an_incorrect_book_on_the_search_bar() {
		searchResultPage.searchBook(badBook);
	}
	
	@Then("I am redirected to the search results page and see results")
	public void i_am_redirected_to_the_search_results_page_and_see_results() {
		searchResultPage.navigateTo(searchURL.concat(goodBook));
	}

	@Then("the appropriate search error message should appear")
	public void the_appropriate_search_error_message_should_appear() {
		String errorMsg = searchResultPage.getErrorMessage();
	    assertTrue(errorMsg.contains("Book does not exist, try again"));
	}
	
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
}
