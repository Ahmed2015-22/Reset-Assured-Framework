package com.mockapi.apis;

import com.mockapi.utils.dataReader.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Builder {

    private static final String BASE_URI =
            PropertyReader.getProperty("baseUrlApi");

    private Builder() {}

    public static RequestSpecification baseRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();
    }

    public static RequestSpecification jsonRequest(Object body) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .setBody(body)
                .build();
    }

    public static RequestSpecification jsonRequest(Object body, Map<String, String> headers) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .setBody(body)
                .build();
    }
}
