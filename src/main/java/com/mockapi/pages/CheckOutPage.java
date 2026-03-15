package com.mockapi.pages;


import com.mockapi.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CheckOutPage {
    private GUIDriver driver;
    public CheckOutPage(GUIDriver driver) {
        this.driver = driver;
    }

    By CheckoutButton = By.id("checkout");
    By FirstNameInput = By.id("first-name");
    By LastNameInput = By.id("last-name");
    By PostalCodeInput = By.id("postal-code");
    By ContinueButton = By.id("continue");
    By FinishButton = By.id("finish");
    By BackHomeButton = By.id("back-to-products");
    By headerTag = By.tagName("h2");

    //Actions
    @Step("Click checkout button")
    public CheckOutPage clickCheckoutButton() {
        driver.element().click(CheckoutButton);
        return this;
    }
    @Step("Enter first name {firstName}")
    public CheckOutPage enterFirstName(String firstName) {
        driver.element().type(FirstNameInput, firstName);
        return this;
    }
    @Step("Enter last name {lastName}")
    public CheckOutPage enterLastName(String lastName) {
        driver.element().type(LastNameInput, lastName);
        return this;
    }
    @Step("Enter postal code {postalCode}")
    public CheckOutPage enterPostalCode(String postalCode) {
        driver.element().type(PostalCodeInput, postalCode);
        return this;
    }
    @Step("Click continue button")
    public CheckOutPage clickContinueButton() {
        driver.element().click(ContinueButton);
        return this;
    }
    @Step("Click finish button")
    public CheckOutPage clickFinishButton() {
        driver.element().click(FinishButton);
        return this;
    }
    //Validations
    @Step("Verify header tag is {expectedHeader}")
    public CheckOutPage verifyHeaderTag (String expectedHeader) {
        String actualHeader = driver.element().getText(headerTag);
        driver.verification().Equals(actualHeader, expectedHeader, "Header tag is as expected");
        return this;
    }

}
