package com.revature.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.revature.models.pages.CartPage;
import com.revature.models.pages.LoginPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartTest {

	
	private static WebDriver driver;
	private String websiteUrl = "http://localhost:4200/home";
	private String cartUrl = "http://localhost:4200/cart";
	
	private static CartPage cartPage;
	private LoginPage loginPage; 
	
	@BeforeAll
	public static void setUpDriver(){
		File file = new File("src/test/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		cartPage = new CartPage(driver);
	}
	
	@AfterEach
	public void teardown() {	
		driver.close();
		driver.quit(); 
	}
	
	@Given("I am on the home page")
	public void i_am_on_the_home_page() {
		cartPage.navigateTo(websiteUrl);
	}

	@When("I put a quantity")
	public void i_put_a_quantity() {
		cartPage.clickQuantity();
	}

	@When("I click add to cart")
	public void i_click_add_to_cart() {
		cartPage.clickAddCart();
	}

	@Then("I am redirected to my cart page")
	public void i_am_redirected_to_my_cart_page() {
		cartPage.navigateTo(cartUrl);
	}

	@Then("products are visible")
	public void products_are_visible1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("product"),0));

		WebElement product = driver.findElement(By.id("product"));
		assertNotNull(product.getText());
	}
	

	@When("I click remove item from cart")
	public void i_click_remove_item_from_cart() {
		cartPage.clickDelete();
	}

	@Then("I should see my cart is empty")
	public void i_should_see_my_cart_is_empty() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("cart"),0));

		WebElement book = driver.findElement(By.id("cart"));
		assertNull(book.getText());
	}
	
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
}

