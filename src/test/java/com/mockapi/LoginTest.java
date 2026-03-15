package com.mockapi;

import com.mockapi.drivers.GUIDriver;
import com.mockapi.pages.LoginPage;
import com.mockapi.utils.TimeManager;
import com.mockapi.utils.dataReader.JsonReader;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Swag Labs")
@Feature("UI User Management")
@Story("User Login")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")


public class LoginTest extends BaseTest {
    String timestamp = TimeManager.getSimpleTimestamp();

    @Test
    public void validLoginTC() {
        // Test implementation goes here
        new LoginPage(driver).navigate()
                .enterUsername(testData.getJsonData("usernames"))
                .enterPassword(testData.getJsonData("password"))
                .clickLoginButton();
        new LoginPage(driver).verifyCurrentUrl(testData.getJsonData("postLoginUrl"));
    }

    @Test
    public void invalidLoginTC() {
        // Test implementation goes here
        new LoginPage(driver).navigate()
                .enterUsername(testData.getJsonData("invalidUsername"))
                .enterPassword(testData.getJsonData("invalidPassword"))
                .clickLoginButton();
        new LoginPage (driver).verifyLoginErrorMsg(testData.getJsonData("invalidLoginErrorMsg"));
    }




    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("login-data");
    }
    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
        driver.browser().closeExtensionTab();
    }

    @AfterMethod
    public void tearDown() {
        driver.quitDriver();
    }


}
