package com.stepDefinition;

import com.constants.*;
import com.core.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ResumeBuilderFeature {
    WebDriver driver;
    boolean invalidEmail, invalidFirstName, invalidLastName, emptyLastName,
            invalidMobile, invalidPhone, emptyFirstName, invalidSocialFacebook;

    public ResumeBuilderFeature(){
        driver = DriverManager.getInstance();
    }

    @And("Navigate to Resume page")
    public void navigateToPage() {

        driver.get(WebsiteURLConstants.BASE_URL + WebsiteURLConstants.RESUME_BUILDER_URL);
    }


    @And("Enter First Name {string}")
    public void enterFirstName(String firstName) {
        if(!firstName.matches(RegexMatchers.ONLY_LETTERS)){
            this.invalidFirstName = true;
        }
        if(firstName.isEmpty()){
            this.emptyFirstName = true;
        }
        WebElement firstNameElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.FIRST_NAME_LOCATOR));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    @And("Enter Last Name {string}")
    public void enterLastName(String lastName) {
        if(!lastName.matches(RegexMatchers.ONLY_LETTERS)){
            this.invalidLastName = true;
        }
        if(lastName.isEmpty()){
            this.emptyLastName = true;
        }
        WebElement lastNameElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.LAST_NAME_LOCATOR));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    @And("Select BirthdateDay {string}")
    public void selectBirthdateDay(String day) {
        WebElement dayElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.BIRTHDATE_DAY_LOCATOR));
        Select selector = new Select(dayElement);
        selector.selectByValue(day);
    }

    @And("Select BrithdateMonth {string}")
    public void selectBrithdateMonth(String month) {
        WebElement monthElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.BIRTHDATE_MONTH_LOCATOR));
        Select selector = new Select(monthElement);
        selector.selectByValue(month);
    }

    @And("Select BirthdateYear {string}")
    public void selectBirthdateYear(String year) {
        WebElement yearElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.BIRTHDATE_YEAR_LOCATOR));
        Select selector = new Select(yearElement);
        selector.selectByValue(year);
    }

    @And("Select Gender {string}")
    public void selectGender(String gender) {
        WebElement genderElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.GENDER_LOCATOR));
        Select selector = new Select(genderElement);
        selector.selectByValue(gender);
    }

    @And("Input Email {string}")
    public void inputEmail(String email) {
        if(email.isEmpty() || !email.matches(RegexMatchers.EMAIL_VALIDATOR)){
            this.invalidEmail = true;
        }
        WebElement emailElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.EMAIL_LOCATOR));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    @And("Select Country {string}")
    public void selectCountry(String CountryID) {
        WebElement countryElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.COUNTRY_LOCATOR));
        Select selector = new Select(countryElement);
        selector.selectByValue(CountryID);
    }

    @And("Select City {string}")
    public void selectCity(String cityID) {
        WebElement cityElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.CITY_LOCATOR));
        Select selector = new Select(cityElement);
        selector.selectByValue(cityID);
    }

    @And("Enter Mobile {string}")
    public void enterMobile(String mobile) {
        if(!mobile.matches("[0-9]+") || mobile.length() != 10){
            this.invalidMobile = true;
        }
        WebElement firstNameElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.MOBILE_LOCATOR));
        firstNameElement.clear();
        firstNameElement.sendKeys(mobile);
    }

    @And("Enter Phone {string}")
    public void enterPhone(String phone) {
        if(!phone.matches(RegexMatchers.ONLY_DIGITS) || phone.length() != 9){
            this.invalidPhone = true;
        }
        WebElement phoneElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.PHONE_LOCATOR));
        phoneElement.clear();
        phoneElement.sendKeys(phone);
    }

    @And("Enter Social Media Facebook url {string}")
    public void enterSocialMediaFacebookUrl(String url) {
        if (!url.contains(RegexMatchers.FACEBOOK_PROFILE_MATCHER)){
            this.invalidSocialFacebook = true;
        }
        WebElement facebookElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.SOCIAL_FACEBOOK_LOCATOR));
        facebookElement.clear();
        facebookElement.sendKeys(url);
    }

    @And("Enter Social Media Linkedin url {string}")
    public void enterSocialMediaLinkedinUrl(String arg0) {
        WebElement linkedinElement = driver.findElement(By.cssSelector(ResumeBuilderPersonalInformationLocators.SOCIAL_LINKEDIN_LOCATOR));
        linkedinElement.clear();
        linkedinElement.sendKeys(arg0);
    }

    public boolean isElementDisplayed(WebDriver driver, By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            if (element.isDisplayed() && !element.getAttribute("class").equals(ResumeBuilderPersonalInformationLocators.NG_INACTIVE_ELEMENT)) {
                return true;
            }
        }
        return false;
    }

    boolean validateValue(String locator){
        By locatorElement = By.cssSelector(locator);
        return this.isElementDisplayed(driver, locatorElement);
    }

    @And("Click save button")
    public void clickSaveButton() {
        driver.findElement(By.xpath(ResumeBuilderPersonalInformationLocators.SAVE_BUTTON_XPATH)).click();
    }

    @Then("No error should appear")
    public void noErrorShouldAppear() {
        try {

            boolean isFirstNameErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.FIRST_NAME_ERROR_LOCATOR);
            Assert.assertFalse("Validation on Empty First Name Doesn't Work", isFirstNameErrorDisplayed);


            boolean isLastNameErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.LAST_NAME_ERROR_LOCATOR);
            Assert.assertFalse("Validation on Empty Last Name Doesn't Work", isLastNameErrorDisplayed);

            boolean isEmailErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.EMAIL_ERROR_LOCATOR);
            Assert.assertFalse("Validation on Invalid Email Doesn't Work", isEmailErrorDisplayed);

            boolean isMobileErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.MOBILE_ERROR_LOCATOR);
            Assert.assertFalse("Validation on Invalid Mobile Doesn't Work", isMobileErrorDisplayed);

            boolean isPhoneErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.PHONE_ERROR_LOCATOR);
            Assert.assertFalse("Validation on Invalid Phone Doesn't Work", isPhoneErrorDisplayed);

            boolean isFacebookErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.SOCIAL_FACEBOOK_ERROR_LOCATOR);
            Assert.assertFalse("Validation on Invalid Social Facebook Doesn't Work", isFacebookErrorDisplayed);
        }
        finally {
            DriverManager.closeDriver();
        }
    }

    @Then("Validation Email error should appear")
    public void validationEmailErrorShouldAppear() {
        try {
            boolean isErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.EMAIL_ERROR_LOCATOR);
            Assert.assertTrue("Validation on Invalid Email Doesn't Work", isErrorDisplayed);
        }
        finally {
            DriverManager.closeDriver();
        }
    }

    @Then("Phone and Mobile Error Should appear")
    public void phoneAndMobileErrorShouldAppear() {
        try {
        boolean isMobileErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.MOBILE_ERROR_LOCATOR);
        Assert.assertTrue("Validation on Invalid Mobile Doesn't Work", isMobileErrorDisplayed);

        boolean isPhoneErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.PHONE_ERROR_LOCATOR);
        Assert.assertTrue("Validation on Invalid Phone Doesn't Work", isPhoneErrorDisplayed);
        }
        finally {
            DriverManager.closeDriver();
        }
    }

    @Then("First and Last name Error Should Appear")
    public void firstAndLastNameErrorShouldAppear() {
        try {
            boolean isFirstNameErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.FIRST_NAME_ERROR_LOCATOR);
            Assert.assertTrue("Validation on First Name Doesn't Work", isFirstNameErrorDisplayed);

            boolean isLastNameErrorDisplayed = this.validateValue(ResumeBuilderPersonalInformationErrorLocators.LAST_NAME_ERROR_LOCATOR);
            Assert.assertTrue("Validation on Invalid Last Name Doesn't Work", isLastNameErrorDisplayed);
        }
        finally {
            DriverManager.closeDriver();
        }

    }
}
