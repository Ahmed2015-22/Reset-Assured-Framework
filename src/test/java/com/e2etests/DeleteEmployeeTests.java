package com.e2etests;

import com.mockapi.apis.EmployeeAPI;
import com.mockapi.apis.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteEmployeeTests extends ABaseTest {

    private EmployeeAPI employeeAPI;
    private String employeeId;

    @BeforeClass
    public void setup() {
        employeeAPI = new EmployeeAPI();
        // ضع هنا الـ employeeId الذي تريد حذفه
        employeeId = "15"; // مثال، يمكن أن يأتي من CREATE أو PATCH
    }

    @Test(priority = 1)
    public void testDeleteEmployee_StatusCode() {
        Response response = employeeAPI.deleteEmployee(employeeId);
        response.then().statusCode(200);
    }

    @Test(priority = 2)
    public void testDeleteEmployee_JSONFormat() {
        Response response = employeeAPI.deleteEmployee(employeeId);
        response.then().contentType(ContentType.JSON);
    }

}
