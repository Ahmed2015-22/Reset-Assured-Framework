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

public class GetSingleEmployeeTests extends ABaseTest {

    private EmployeeAPI employeeAPI;
    private String employeeId;

    @BeforeClass
    public void setup() {
        employeeAPI = new EmployeeAPI();
        // ضع هنا الـ employeeId الموجود مسبقًا، أو استخرجه من اختبار CREATE
        employeeId = "1"; // مثال
    }

    @Test(priority = 1)
    public void testGetEmployeeById_StatusCode() {
        Response response = employeeAPI.getEmployeeById(employeeId);
        response.then().statusCode(200);
    }

    @Test(priority = 2)
    public void testGetEmployeeById_JSONFormat() {
        Response response = employeeAPI.getEmployeeById(employeeId);
        response.then().contentType(ContentType.JSON);
    }

    @Test(priority = 3)
    public void testGetEmployeeById_RequiredProperties() {
        Response response = employeeAPI.getEmployeeById(employeeId);
        Employee emp = response.as(Employee.class);
        assertNotNull(emp.getId());
        assertNotNull(emp.getName());
        assertNotNull(emp.getPhone());
        assertNotNull(emp.getSalary());
        assertNotNull(emp.isMarried());
    }

    @Test(priority = 4)
    public void testGetEmployeeById_PropertyTypes() {
        Response response = employeeAPI.getEmployeeById(employeeId);
        Employee emp = response.as(Employee.class);
        assertTrue(emp.getId() instanceof String);
        assertTrue(emp.getName() instanceof String);
        assertTrue(emp.getPhone() instanceof String);
        assertTrue(emp.getSalary() >= 0); // salary must be number >= 0
        assertTrue(emp.isMarried() == true || emp.isMarried() == false);
    }

    @Test(priority = 5)
    public void testGetEmployeeById_SpecificId() {
        Response response = employeeAPI.getEmployeeById(employeeId);
        Employee emp = response.as(Employee.class);
        assertThat(emp.getId(), equalTo(employeeId));
    }

    @Test(priority = 6)
    public void testGetEmployeeById_SalaryRange() {
        Response response = employeeAPI.getEmployeeById(employeeId);
        Employee emp = response.as(Employee.class);
        assertTrue(emp.getSalary() >= 0 && emp.getSalary() <= 1_000_000);
    }
}
