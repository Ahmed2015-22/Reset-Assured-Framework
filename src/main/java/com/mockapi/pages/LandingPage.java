package com.mockapi.pages;

import com.mockapi.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LandingPage {
    private GUIDriver driver;
    public LandingPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By pageTitle = By.className("title");
    private final By shoppingCartBadge = By.id("shopping_cart_container");
    private final By productNumber = By.className("shopping_cart_badge");

    private final By ProductOneAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By ProductTwoAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By ProductThreeAddToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By ProductFourAddToCartButton = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By ProductFiveAddToCartButton = By.id("add-to-cart-sauce-labs-onesie");
    private final By ProductSixAddToCartButton = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    //Actions
    @Step("Click menu button")
    public LandingPage clickMenuButton() {
        driver.element().click(menuButton);
        return this;
    }
    @Step("Click logout link")
    public LandingPage clickLogoutLink() {
        driver.element().click(logoutLink);
        return this;
    }

    @Step("Click shopping cart badge")
    public LandingPage clickShoppingCartBadge() {
        driver.element().click(shoppingCartBadge);
        return this;
    }


    @Step("Add product one to cart")
    public LandingPage addProductOneToCart() {
        driver.element().click(ProductOneAddToCartButton);
        return this;
    }
    @Step("Add product two to cart")
    public LandingPage addProductTwoToCart() {
        driver.element().click(ProductTwoAddToCartButton);
        return this;
    }
    @Step("Add product three to cart")
    public LandingPage addProductThreeToCart() {
        driver.element().click(ProductThreeAddToCartButton);
        return this;
    }
    @Step("Add product four to cart")
    public LandingPage addProductFourToCart() {
        driver.element().click(ProductFourAddToCartButton);
        return this;
    }
    @Step("Add product five to cart")
    public LandingPage addProductFiveToCart() {
        driver.element().click(ProductFiveAddToCartButton);
        return this;
    }
    @Step("Add product six to cart")
    public CartPage addProductSixToCart() {
        driver.element().click(ProductSixAddToCartButton);
        return new CartPage(driver);
    }




    public String getPageTitle() {
        return driver.element().getText(pageTitle);
    }
    public String getProductNumber() {
        return driver.element().getText(productNumber);
    }
    //Validations
    /*public LandingPage verifyPageTitle(String expectedTitle) {
        String actualTitle = getPageTitle();
        driver.verification().Equals(actualTitle, expectedTitle, "Page title is not as expected");
        return this;
    }  */
    @Step("Verify product number in cart is {expectedNumber}")
    public LandingPage verifyProductNumber(String expectedNumber) {
        String actualNumber = getProductNumber();
        driver.verification().Equals(actualNumber, expectedNumber, "Product number in cart is not as expected");
        return this;
    }


}
