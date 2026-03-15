package com.e2etests;

import com.mockapi.apis.EmployeeAPI;
import com.mockapi.apis.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;

public class UpdateEmployeeTests extends ABaseTest {

    private EmployeeAPI employeeAPI;
    private String employeeId;

    @BeforeClass
    public void setup() {
        employeeAPI = new EmployeeAPI();
        // ضع هنا الـ employeeId الموجود مسبقًا من اختبار CREATE
        employeeId = "1"; // مثال
    }

    @Test(priority = 1)
    public void testUpdateEmployee_StatusCode() {
        Employee employee = new Employee(employeeId, "John Updated", "+201234567890", 6000, false);
        Response response = employeeAPI.updateEmployee(employeeId, employee);
        response.then().statusCode(200);
    }

    @Test(priority = 2)
    public void testUpdateEmployee_JSONFormat() {
        Employee employee = new Employee(employeeId, "John Updated", "+201234567890", 6000, false);
        Response response = employeeAPI.updateEmployee(employeeId, employee);
        response.then().contentType(ContentType.JSON);
    }

    @Test(priority = 3)
    public void testUpdateEmployee_Name() {
        Employee employee = new Employee(employeeId, "John Updated", "+201234567890", 6000, false);
        Response response = employeeAPI.updateEmployee(employeeId, employee);
        Employee updated = response.as(Employee.class);
        assertThat(updated.getName(), equalTo(employee.getName()));
    }

    @Test(priority = 4)
    public void testUpdateEmployee_Salary() {
        Employee employee = new Employee(employeeId, "John Updated", "+201234567890", 6000, false);
        Response response = employeeAPI.updateEmployee(employeeId, employee);
        Employee updated = response.as(Employee.class);
        assertThat(updated.getSalary(), equalTo(employee.getSalary()));
    }

    @Test(priority = 5)
    public void testUpdateEmployee_Married() {
        Employee employee = new Employee(employeeId, "John Updated", "+201234567890", 6000, false);
        Response response = employeeAPI.updateEmployee(employeeId, employee);
        Employee updated = response.as(Employee.class);
        assertThat(updated.isMarried(), equalTo(employee.isMarried()));
    }
}