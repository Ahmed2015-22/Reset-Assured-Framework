package com.mockapi.apis;

import com.mockapi.utils.logs.LogsManager;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;

public class EmployeeAPI {

    private Response response;

    private static final String EMPLOYEES = "/employee";

    @Step("Get all employees")
    public Response getAllEmployees() {
        response = given()
                .spec(Builder.baseRequest())
                .get(EMPLOYEES);
        LogsManager.info(response.asPrettyString());
        return response;
    }

    @Step("Get employee by ID: {id}")
    public Response getEmployeeById(String id) {
        response = given()
                .spec(Builder.baseRequest())
                .pathParam("id", id)
                .get(EMPLOYEES + "/{id}");
        LogsManager.info(response.asPrettyString());
        return response;
    }

    @Step("Create employee")
    public Response createEmployee(Employee employee) {
        response = given()
                .spec(Builder.jsonRequest(employee))
                .post(EMPLOYEES);
        LogsManager.info(response.asPrettyString());
        return response;
    }

    @Step("Update employee by ID: {id}")
    public Response updateEmployee(String id, Employee employee) {
        response = given()
                .spec(Builder.jsonRequest(employee))
                .pathParam("id", id)
                .put(EMPLOYEES + "/{id}");
        LogsManager.info(response.asPrettyString());
        return response;
    }

    @Step("Patch employee by ID: {id}")
    public Response patchEmployee(String id, Employee employee) {
        response = given()
                .spec(Builder.jsonRequest(employee))
                .pathParam("id", id)
                .patch(EMPLOYEES + "/{id}");
        LogsManager.info(response.asPrettyString());
        return response;
    }

    @Step("Delete employee by ID: {id}")
    public Response deleteEmployee(String id) {
        response = given()
                .spec(Builder.baseRequest())
                .pathParam("id", id)
                .delete(EMPLOYEES + "/{id}");
        LogsManager.info(response.asPrettyString());
        return response;
    }
}