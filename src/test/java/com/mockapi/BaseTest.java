package com.mockapi;

import com.mockapi.drivers.GUIDriver;
import com.mockapi.drivers.WebDriverProvider;
import com.mockapi.utils.dataReader.JsonReader;
import org.openqa.selenium.WebDriver;

public class BaseTest implements WebDriverProvider {

    protected GUIDriver driver;
    protected JsonReader testData;

    @Override
    public WebDriver getWebDriver() {

        return driver.get();
    }


}
