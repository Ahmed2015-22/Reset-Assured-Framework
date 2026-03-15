package com.e2etests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ABaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://697f9730d1548030ab667629.mockapi.io";

          }
}
