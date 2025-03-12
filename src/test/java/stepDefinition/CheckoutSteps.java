package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
	WebDriver driver;
	
	@Given("the user has logged in to the SauceDemo platform")
	public void the_user_has_logged_in_to_the_sauce_demo_platform() throws InterruptedException {
		driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
	}
	
	@Given("the user has added a product to their shopping cart")
	public void the_user_has_added_a_product_to_their_shopping_cart() throws InterruptedException {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);	
	}
	
	@When("the user navigates to the checkout page")
	public void the_user_navigates_to_the_checkout_page() throws InterruptedException {
		driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);
	}
	
	@When("the user provides their checkout information")
	public void the_user_provides_their_checkout_information() throws InterruptedException {
		driver.findElement(By.id("first-name")).sendKeys("Pravallika");
        driver.findElement(By.id("last-name")).sendKeys("Anubothu");
        driver.findElement(By.id("postal-code")).sendKeys("522201");
        Thread.sleep(2000);	
	}
	
	@When("the user proceeds to the next checkout step")
	public void the_user_proceeds_to_the_next_checkout_step() throws InterruptedException {
		driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
	}
	
	@When("the user confirms the order details")
	public void the_user_confirms_the_order_details() throws InterruptedException {
		driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);
	}
	
	@Then("the order confirmation should be displayed")
	public void the_order_confirmation_should_be_displayed() throws InterruptedException {
		Thread.sleep(2000);  
	    String confirmationText = driver.findElement(By.className("complete-header")).getText();
	    Assert.assertTrue(confirmationText.equalsIgnoreCase("Thank you for your order!"));
	    driver.quit();
	    
	}
}
