package com.mockapi;

import com.e2etests.ABaseTest;
import com.mockapi.apis.EmployeeAPI;
import com.mockapi.apis.Employee;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;


public class EmployeeTests extends ABaseTest {
    private final EmployeeAPI employeeAPI = new EmployeeAPI();
    private String employeeId;

    // ===== 1 - GET ALL EMPLOYEES =====
    @Test(priority = 1)
    public void testGetAllEmployees() {
        Response response = employeeAPI.getAllEmployees();

        // ===== 1. تحقق من Status Code =====
        response.then().statusCode(200);

        // ===== 2. تحقق من Response Time =====
        assertTrue(response.getTime() < 800, "Response took too long");

        // ===== 3. تحويل الـ JSON Array لـ List<Employee> =====
        List<Employee> employees = response.jsonPath().getList("", Employee.class);

        // ===== 4. تحقق إن الـ Array مش فاضي =====
        assertTrue(employees.size() > 0, "Employees list is empty");

        // ===== 5. تحقق من الـ IDs unique =====
        Set<String> ids = new HashSet<>();
        for (Employee e : employees) {
            assertTrue(ids.add(e.getId()), "Duplicate ID: " + e.getId());

            // ===== 6. تحقق من salary منطقي =====
            assertTrue(e.getSalary() >= 0 && e.getSalary() <= 1_000_000, "Invalid salary: " + e.getSalary());

            // ===== 7. تحقق من الاسم والـ phone مش فاضي =====
            assertTrue(e.getName() != null && e.getName().length() > 0, "Name is empty");
            assertTrue(e.getPhone() != null && e.getPhone().length() > 0, "Phone is empty");

            // ===== 8. تحقق من نوع married =====
            assertTrue(e.isMarried() == true || e.isMarried() == false, "Married field is not boolean");
        }

        // ===== 9. Optional: تحقق من وجود أي Employee (مافيش افتراض ID) =====
        System.out.println("Total employees fetched: " + employees.size());
    }

    // ===== 2 - CREATE NEW EMPLOYEE =====
    @Test(priority = 2)
    public void testCreateEmployee() {
        Employee employee = new Employee("John Doe", "+201234567890", 5000, true);
        Response response = employeeAPI.createEmployee(employee);
        response.then().statusCode(201);
        assertTrue(response.getTime() < 800);

        Employee created = response.as(Employee.class);
        employeeId = created.getId(); // save for next tests

        assertThat(created.getName(), equalTo(employee.getName()));
        assertThat(created.getPhone(), equalTo(employee.getPhone()));
        assertThat(created.getSalary(), equalTo(employee.getSalary()));
        assertThat(created.isMarried(), equalTo(employee.isMarried()));
    }

    // ===== 3 - GET SINGLE EMPLOYEE =====
    @Test(priority = 3)
    public void testGetEmployeeById() {
        Response response = employeeAPI.getEmployeeById(employeeId);
        response.then().statusCode(200);

        Employee emp = response.as(Employee.class);
        assertThat(emp.getId(), equalTo(employeeId));
    }

    // ===== 4 - UPDATE EMPLOYEE =====
    @Test(priority = 4)
    public void testUpdateEmployee() {
        Employee employee = new Employee(employeeId, "John Updated", "+201234567890", 6000, false);
        Response response = employeeAPI.updateEmployee(employeeId, employee);
        response.then().statusCode(200);

        Employee updated = response.as(Employee.class);
        assertThat(updated.getName(), equalTo(employee.getName()));
        assertThat(updated.getSalary(), equalTo(employee.getSalary()));
        assertThat(updated.isMarried(), equalTo(employee.isMarried()));
    }

    // ===== 5 - PATCH EMPLOYEE =====
    @Test(priority = 5)
    public void testPatchEmployee() {
        Employee employee = new Employee();
        employee.setSalary(7000); // partial update
        Response response = employeeAPI.patchEmployee(employeeId, employee);
        response.then().statusCode(200);

        Employee patched = response.as(Employee.class);
        assertThat(patched.getSalary(), equalTo(employee.getSalary()));
    }

    // ===== 6 - DELETE EMPLOYEE =====
    @Test(priority = 6)
    public void testDeleteEmployee() {
        Response response = employeeAPI.deleteEmployee(employeeId);
        response.then().statusCode(200);

        Employee deleted = response.as(Employee.class);
        assertThat(deleted.getId(), equalTo(employeeId));
    }


}
