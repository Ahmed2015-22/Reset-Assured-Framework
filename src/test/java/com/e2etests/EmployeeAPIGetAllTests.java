package com.e2etests;

import com.mockapi.apis.Employee;
import com.mockapi.apis.EmployeeAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeAPIGetAllTests extends ABaseTest{
    private EmployeeAPI employeeAPI;
    private List<Employee> employees;

    @BeforeClass
    public void setup() {
        employeeAPI = new EmployeeAPI();
        Response response = employeeAPI.getAllEmployees();
        response.then().statusCode(200);
        employees = response.jsonPath().getList("", Employee.class);
    }
    @Test(priority = 1)
    public void testGetAllEmployeesResponseTime() {
        Response response = employeeAPI.getAllEmployees();
        assertTrue(response.getTime() < 10000, "Response took too long");
    }
    @Test(priority = 2)
    public void testGetAllEmployeesNotEmpty() {
        assertTrue(employees.size() > 0, "Employees list is empty");
    }
    @Test(priority = 3)
    public void testGetAllEmployeesUniqueIds() {
        Set<String> ids = new HashSet<>();
        for (Employee e : employees) {
            assertTrue(ids.add(e.getId()), "Duplicate ID: " + e.getId());
        }
    }
    @Test(priority = 4)
    public void testGetAllEmployeesSalaryRange() {
        for (Employee e : employees) {
            assertTrue(e.getSalary() >= 0 && e.getSalary() <= 1_000_000, "Invalid salary: " + e.getSalary());
        }
    }
    @Test(priority = 5)
    public void testGetAllEmployeesNameAndPhoneNotEmpty() {
        for (Employee e : employees) {
            assertTrue(e.getName() != null && e.getName().length() > 0, "Name is empty");
            assertTrue(e.getPhone() != null && e.getPhone().length() > 0, "Phone is empty");
        }
    }
    @Test(priority = 6)
    public void testGetAllEmployeesMarriedBoolean() {
        for (Employee e : employees) {
            assertTrue(e.isMarried() == true || e.isMarried() == false, "Married field not boolean");
        }
    }
    @Test(priority = 7)
    public void testGetAllEmployeesContainsId1() {
        boolean containsId1 = employees.stream().anyMatch(e -> e.getId().equals("1"));
        assertTrue(containsId1, "Employee with ID 1 not found");
    }

}
