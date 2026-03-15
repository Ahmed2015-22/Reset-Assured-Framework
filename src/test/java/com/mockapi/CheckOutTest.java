package com.mockapi;

import com.mockapi.drivers.GUIDriver;
import com.mockapi.pages.LoginPage;
import com.mockapi.utils.dataReader.JsonReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    JsonReader loginData = new JsonReader("login-data");
    JsonReader checkoutData = new JsonReader("checkout-data");

    @Test
    public void completeCheckOutTC()
    {

        new LoginPage(driver).navigate().enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addProductOneToCart().addProductTwoToCart()
                .addProductSixToCart().navigateToCartPage()
                .removeProductSixFromCart().clickCheckoutButton()
                .enterFirstName(checkoutData.getJsonData("First-name"))
                .enterLastName(checkoutData.getJsonData("Second-name"))
                .enterPostalCode(checkoutData.getJsonData("ZIP-code"))
                .clickContinueButton().clickFinishButton()
                .verifyHeaderTag("Thank you for your order!");
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
