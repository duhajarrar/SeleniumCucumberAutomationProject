package com.stepDefinition;

import com.constants.*;
import com.core.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchFeature {

	WebDriver driver;

	private String option;
	private String search_text;

	public SearchFeature() {
		driver = DriverManager.getInstance();
	}

	@Given("A user navigate to home page.")
	public void a_user_navigate_to_home_page() {
		driver.get(WebsiteURLConstants.BASE_URL);
	}

	@Given("A user enters {string} in search text.")
	public void a_user_enters_in_search_text(String string) {

		this.search_text = string;

		By locator = By.name(SearchLocators.SEARCH_INPUT_LOCATOR);
		DriverManager.WaitForElement(locator);

		WebElement inputText = driver.findElement(locator);
		inputText.clear();
		inputText.sendKeys(this.search_text);
	}

	@Given("A user selects the search option {string}.")
	public void a_user_selects_the_search_option(String string) throws Exception {

		this.option = string;

		WebElement searchOptions = driver.findElement(By.cssSelector(SearchLocators.SEARCH_OPTION_LOCATOR));
		Select selector = new Select(searchOptions);
		selector.selectByValue(this.option);
	}

	@Then("A user clicks on the search button.")
	public void a_user_clicks_on_the_search_button() {

		try {

			WebElement button = driver.findElement(By.cssSelector(SearchLocators.SEARCH_BUTTON_LOCATOR));
			button.click();

			By locator = getResutlsLocator();
			DriverManager.WaitForElement(locator);
			WebElement results = driver.findElement(locator);

			Assert.assertTrue(results.getText().toLowerCase().contains(this.search_text.toLowerCase()));

		} finally {
			DriverManager.closeDriver();
		}
	}

	private By getResutlsLocator() {

		if (this.option.equals(SearchLocators.COMPANIES_OPTION))
			return By.xpath(SearchLocators.COMPANIES_RESULTS_LOCATOR);

		if (this.option.equals(SearchLocators.ARTICLES_OPTION))
			return By.xpath(SearchLocators.ARTICLES_RESULTS_LOCATOR);

		return By.xpath(SearchLocators.JOB_RESULTS_LOCATOR);
	}

}
