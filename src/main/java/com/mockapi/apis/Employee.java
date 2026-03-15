package com.mockapi.apis;

public class Employee {

    private String id;
    private String name;
    private String phone;
    private int salary;
    private boolean married;

    public Employee() {}

    public Employee(String name, String phone, int salary, boolean married) {
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.married = married;
    }

    public Employee(String id, String name, String phone, int salary, boolean married) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.married = married;
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
    public boolean isMarried() { return married; }
    public void setMarried(boolean married) { this.married = married; }
}
