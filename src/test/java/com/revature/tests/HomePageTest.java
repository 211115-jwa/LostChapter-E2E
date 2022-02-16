package com.revature.tests;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNotNull;
import com.revature.models.pages.HomePage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest {
	
	private static HomePage homePage;
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void setUpDriver()
	{
		File file = new File("src/test/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
	}
	
	
	
	@AfterEach
	public void teardown() {
		
		this.driver.close();
		this.driver.quit();	
	}
	
	@Given("The user is on the home component")
	public void the_user_is_on_the_home_component() {
	 homePage.navigateTo();
	}

	@Then("The featured books display")
	public void the_featured_books_display() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("featuredbooks"),0));
		WebElement book = driver.findElement(By.id("featuredbooks"));
		assertNotNull(book.getText());
	}
//	@When("The user clicks on the nonfiction tab")
//	public void the_user_clicks_on_the_nonfiction_tab() {
//		WebElement postp = driver.findElement(By.id("nonfiction"));
//		postp.click();
//	}

	@Then("The sale books display")
	public void the_sale_books_display() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("salebooks"),0));

		WebElement book = driver.findElement(By.id("salebooks"));
		assertNotNull(book.getText());
	}

	
	@Then("The specific books by genre will display")
	public void the_specific_books_by_genre_will_display() {
		//change to fluent
//		WebDriverWait waitb = new WebDriverWait(driver,15);
//		waitb.until(ExpectedConditions.presenceOfElementLocated(By.id("booktitlegenre")));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("genr"),0));

		WebElement book = driver.findElement(By.id("genr"));
		assertNotNull(book.getText());
	}
	
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
}
