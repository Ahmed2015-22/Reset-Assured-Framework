package com.e2etests;

import com.mockapi.apis.Employee;
import com.mockapi.apis.EmployeeAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class EmployeeAPICreateTests extends ABaseTest {

    private EmployeeAPI employeeAPI;
    private Employee employeeToCreate;
    private String employeeId;

    @BeforeClass
    public void setup() {
        employeeAPI = new EmployeeAPI();
        // نجهز Employee واحد للCreate Test
        employeeToCreate = new Employee("John Doe", "+201234567890", 5000, true);
    }

    @Test(priority = 1)
    public void testCreateEmployeeStatusCode() {
        Response response = employeeAPI.createEmployee(employeeToCreate);
        response.then().statusCode(201);

        // نخزن الـ employeeId للاختبارات التالية
        Employee created = response.as(Employee.class);
        employeeId = created.getId();
    }

    @Test(priority = 2)
    public void testCreateEmployeeResponseTime() {
        Response response = employeeAPI.createEmployee(employeeToCreate);
        assertTrue(response.getTime() < 800, "Response took too long");
    }

    @Test(priority = 3)
    public void testCreateEmployeeName() {
        Response response = employeeAPI.createEmployee(employeeToCreate);
        Employee created = response.as(Employee.class);
        employeeId = created.getId(); // تحديث الـ employeeId
        assertThat(created.getName(), equalTo(employeeToCreate.getName()));
    }

    @Test(priority = 4)
    public void testCreateEmployeePhone() {
        Response response = employeeAPI.createEmployee(employeeToCreate);
        Employee created = response.as(Employee.class);
        employeeId = created.getId();
        assertThat(created.getPhone(), equalTo(employeeToCreate.getPhone()));
    }

    @Test(priority = 5)
    public void testCreateEmployeeSalary() {
        Response response = employeeAPI.createEmployee(employeeToCreate);
        Employee created = response.as(Employee.class);
        employeeId = created.getId();
        assertThat(created.getSalary(), equalTo(employeeToCreate.getSalary()));
    }

    @Test(priority = 6)
    public void testCreateEmployeeMarried() {
        Response response = employeeAPI.createEmployee(employeeToCreate);
        Employee created = response.as(Employee.class);
        employeeId = created.getId();
        assertThat(created.isMarried(), equalTo(employeeToCreate.isMarried()));
    }
}

