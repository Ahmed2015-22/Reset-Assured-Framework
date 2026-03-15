package com.mockapi.pages;

import com.mockapi.drivers.GUIDriver;
import com.mockapi.utils.dataReader.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private GUIDriver driver;
    public LoginPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Step("Navigate to Home Page")
    public LoginPage navigate() {
        driver.browser().navigateTo(PropertyReader.getProperty("baseUrlWeb"));
        return this;
    }
    @Step("Enter username {username}")
    public LoginPage enterUsername(String username) {
        driver.element().type(usernameInput, username);
        return this;
    }
    @Step("Enter password {password}")
    public LoginPage enterPassword(String password) {
        driver.element().type(passwordInput, password);
        return this;
    }
    @Step("Click login button")
    public LandingPage clickLoginButton() {
        driver.element().click(loginButton);
        return new LandingPage(driver);
    }

    //Validations
    @Step("Verify login error message {errorExpected}")
    public LoginPage verifyLoginErrorMsg (String errorExpected)
    {
        String errorActual = driver.element().getText(errorMessage);
        driver.verification().Equals(errorActual,errorExpected, "Login error message is not as expected");
        return this;
    }
    @Step("Verify current URL is {expectedUrl}")
    public LoginPage verifyCurrentUrl (String expectedUrl) {
        String actualUrl = driver.browser().getCurrentUrl();
        driver.verification().Equals(actualUrl, expectedUrl, "Current URL is Correct");
        return this;
    }
}
