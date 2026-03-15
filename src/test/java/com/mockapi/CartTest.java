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
@Story("Cart Page")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")


public class CartTest extends BaseTest{
    String timestamp = TimeManager.getSimpleTimestamp();
    @Test
    public void adjustProductsFromCartTC()
    {
        // Test implementation goes here
        new LoginPage(driver).navigate()
                .enterUsername(testData.getJsonData("usernames"))
                .enterPassword(testData.getJsonData("password"))
                .clickLoginButton()
                .addProductOneToCart().addProductTwoToCart()
                .addProductSixToCart().navigateToCartPage()
                .removeProductOneFromCart().verifyProductNumber("2");


    }
        // Test implementation goes here






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
