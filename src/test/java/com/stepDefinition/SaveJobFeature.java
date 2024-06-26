package com.stepDefinition;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.constants.SaveJobLocators;
import com.constants.WebsiteURLConstants;
import com.core.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SaveJobFeature {
    WebDriver driver;

    public SaveJobFeature(){
        driver = DriverManager.getInstance();
    }

    @And("Navigate to Home Page")
    public void navigate_to_home_page(){
		driver.get(WebsiteURLConstants.BASE_URL);
    }

    @And("Click on featured job")
    public void click_on(){		
        By locator = By.cssSelector(SaveJobLocators.FEATURED_JOB_TITLE_LOCATOR);
		DriverManager.WaitForElement(locator);
		driver.findElement(locator).click();
    }

    @And("Click on save job")
    public void click_on_save_job(){
        By locator = By.cssSelector(SaveJobLocators.SAVE_JOB_BUTTON_LOCATOR);
		DriverManager.WaitForElement(locator);
		driver.findElement(locator).click();
    }

    @Then("Should display saved successfully")
    public void should_display_saved_successfully(){
        try{
            By locator = By.xpath(SaveJobLocators.SAVED_ALERT_LOCATOR);
            DriverManager.WaitForElement(locator);
            String alert_meesage = driver.findElement(locator).getText();
            assertTrue("Failed to save the job",(alert_meesage.equals("Done") || alert_meesage.equals("Already Saved!")));
        }
        finally{
            DriverManager.closeDriver();
        }
    }

}