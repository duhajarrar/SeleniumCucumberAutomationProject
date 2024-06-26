package com.stepDefinition;

import com.constants.LoginLocators;
import com.constants.WebsiteURLConstants;
import com.core.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeature {
	WebDriver driver;

	public LoginFeature(){
		driver = DriverManager.getInstance();
	}

	@Given("Navigate to {string} Page")
	public void navigate_to_page(String string) {
		driver.get(WebsiteURLConstants.BASE_URL + string);
	}

	@When("Enter Email {string}")
	public void enter_email(String string) {
		driver.findElement(By.name("email")).sendKeys(string);
	}

	@When("Enter Password {string}")
	public void enter_password(String string) {
		driver.findElement(By.name("password")).sendKeys(string);
	}

	@When("Click on Login Button")
	public void click_on_login_button(){
		By locator = By.cssSelector(LoginLocators.LOGIN_BTN_LOCATOR);
		DriverManager.WaitForElement(locator);
		driver.findElement(locator).click();
	}

	@Then("It should display {string}")
	public void it_should_display(String string) {
		try{
			By locator_btn = By.cssSelector(LoginLocators.LOGIN_BTN_LOCATOR);
			DriverManager.WaitForElement(locator_btn);
			driver.findElement(locator_btn).click();

			By alert_locator = By.className(LoginLocators.LOGIN_ALERT_LOCATOR);
			DriverManager.WaitForElement(alert_locator);
			Assert.assertEquals(driver.findElement(alert_locator).getText(),"Maximum Password length is 4");

		}
		finally{
			DriverManager.closeDriver();
		}
	}

	@Then("It should navigate to {string}")
	public void it_should_navigate_to(String string) {
		try{
			Assert.assertEquals(driver.getCurrentUrl(), WebsiteURLConstants.BASE_URL + string);
		}
		finally{
			DriverManager.closeDriver();
		}
	}

}
