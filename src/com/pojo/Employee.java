package com.pojo;

public class Employee {
	private int empId;
	private String name;
	private String location;
	private Department department;

	public Employee() {

	}

	public Employee(int empId, String name, String location, Department department) {
		super();
		this.empId = empId;
		this.name = name;
		this.location = location;
		this.department = department;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", location=" + location + ", department=" + department + "]";
	}

}
