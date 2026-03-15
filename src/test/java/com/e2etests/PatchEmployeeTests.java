package com.e2etests;

import com.mockapi.apis.EmployeeAPI;
import com.mockapi.apis.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PatchEmployeeTests extends ABaseTest {

    private EmployeeAPI employeeAPI;
    private String employeeId;

    @BeforeClass
    public void setup() {
        employeeAPI = new EmployeeAPI();
        // ضع هنا الـ employeeId الموجود مسبقًا من اختبار CREATE
        employeeId = "1"; // مثال
    }

    @Test(priority = 1)
    public void testPatchEmployee_StatusCode() {
        Employee employee = new Employee();
        employee.setSalary(7000);
        Response response = employeeAPI.patchEmployee(employeeId, employee);
        response.then().statusCode(200);
    }

    @Test(priority = 2)
    public void testPatchEmployee_JSONFormat() {
        Employee employee = new Employee();
        employee.setSalary(7000);
        Response response = employeeAPI.patchEmployee(employeeId, employee);
        response.then().contentType(ContentType.JSON);
    }

    @Test(priority = 3)
    public void testPatchEmployee_SalaryUpdated() {
        Employee employee = new Employee();
        employee.setSalary(7000);
        Response response = employeeAPI.patchEmployee(employeeId, employee);
        Employee patched = response.as(Employee.class);
        assertThat(patched.getSalary(), equalTo(employee.getSalary()));
    }
}
