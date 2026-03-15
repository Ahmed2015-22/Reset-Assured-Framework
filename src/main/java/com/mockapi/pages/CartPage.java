package com.mockapi.pages;

import com.mockapi.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CartPage {
    private GUIDriver driver;
    public CartPage(GUIDriver driver) {
        this.driver = driver;
    }


    private final By shoppingCartBadge = By.id("shopping_cart_container");
    private final By productNumber = By.className("shopping_cart_badge");

    private final By ProductOneRemoveFromCartButton = By.id("remove-sauce-labs-backpack");
    private final By ProductTwoRemoveFromCartButton = By.id("remove-sauce-labs-bike-light");
    private final By ProductThreeRemoveFromCartButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By ProductFourRemoveFromCartButton = By.id("remove-sauce-labs-fleece-jacket");
    private final By ProductFiveRemoveFromCartButton = By.id("remove-sauce-labs-onesie");
    private final By ProductSixRemoveFromCartButton = By.id("remove-test.allthethings()-t-shirt-(red)");

    @Step("Navigate to Cart Page")
    public CartPage navigateToCartPage() {
        driver.element().click(shoppingCartBadge);
        return this;
    }
    @Step("Remove product one from cart")
    public CartPage removeProductOneFromCart() {
        driver.element().click(ProductOneRemoveFromCartButton);
        return this;
    }
    @Step("Remove product two from cart")
    public CartPage removeProductTwoFromCart() {
        driver.element().click(ProductTwoRemoveFromCartButton);
        return this;
    }
    @Step("Remove product three from cart")
    public CartPage removeProductThreeFromCart() {
        driver.element().click(ProductThreeRemoveFromCartButton);
        return this;
    }
    @Step("Remove product four from cart")
    public CartPage removeProductFourFromCart() {
        driver.element().click(ProductFourRemoveFromCartButton);
        return this;
    }
    @Step("Remove product five from cart")
    public CartPage removeProductFiveFromCart() {
        driver.element().click(ProductFiveRemoveFromCartButton);
        return this;
    }
    @Step("Remove product six from cart")
    public CheckOutPage removeProductSixFromCart() {
        driver.element().click(ProductSixRemoveFromCartButton);
        return new CheckOutPage(driver);
    }

    //Validations
    @Step("Get product number in cart")
    public String getProductNumber() {
        return driver.element().getText(productNumber);
    }
    public CartPage verifyProductNumber(String expectedNumber) {
        String actualNumber = getProductNumber();
        driver.verification().Equals(actualNumber, expectedNumber, "Product number in cart is not as expected");
        return this;
    }



}
