package com.revature.tests;

import static org.junit.Assert.assertNull;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.revature.models.pages.CartPage;
import com.revature.models.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartTest {

	
	private WebDriver driver;
	private String websiteUrl = "localhost:4200/home";
	private String cartUrl = "localhost:4200/cart";
	
	private CartPage cartPage;
	private LoginPage loginPage; 
	
	@AfterEach
	public void teardown() {	
		this.driver.close();
		this.driver.quit(); 
	}
	
	@Given("I am on the home page")
	public void i_am_on_the_home_page() {
		cartPage.navigateTo(websiteUrl);
	}

	@When("I click on a product on the front page")
	public void i_click_on_a_product_on_the_front_page() {
		cartPage.clickProduct();
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
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("products are visible")
	public void products_are_visible1() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	@When("I am redirected to my cart page")
	public void i_am_redirected_to_my_cart_page1() {
		cartPage.navigateTo(cartUrl);
	}

	@When("products are visible")
	public void products_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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
	
}
