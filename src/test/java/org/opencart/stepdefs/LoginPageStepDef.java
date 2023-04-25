package org.opencart.stepdefs;

import java.time.Duration;

import org.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {
	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	@Given("I am on the OpenCart login page")
	public void i_am_on_the_open_cart_login_page() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		loginPage = new LoginPage(driver);
	}

	@Given("I have entered a valid email and key")
	public void i_have_entered_a_valid_username_and_password() {
		loginPage.enterEmail("qatestertest@gmail.com");
		loginPage.enterPassword("Test@123");
	}

	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid(String username, String password) {
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
	}

	@When("I click on the login button")
	public void i_click_on_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("I should be logged in successfully")
	public void successful_login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertEquals(loginPage.checkLogoutLink(), true);
	}

	@Then("I should see an error message indicating {string}")
	public void error_message(String errorMessage) {
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
	}

	@When("I click on the \"Forgotten Password\" link")
	public void forgotten_pwd() {
		loginPage.forgottenPasswordLink();
	}

	@Then("I should be redirected to the password reset page")
	public void redireceted() {
		Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));

	}

}
