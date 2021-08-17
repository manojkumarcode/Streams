package com.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pojo.Department;
import com.pojo.Employee;
import com.pojo.MyTuple;

public class DemoGroupByEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = Arrays.asList(new Employee(1, "ABC", "Mumbai", Department.Development),
				new Employee(101, "ABCD", "Mumbai", Department.DevOPS),
				new Employee(6, "XYZ", "Banglore", Department.Development),
				new Employee(78, "LMN", "Chennai", Department.Development),
				new Employee(1, "ABC", "Chennai", Department.Testing),
				new Employee(10, "ABC", "Banglore", Department.Development),
				new Employee(1, "ABC", "Banglore", Department.Development),
				new Employee(1, "ABC", "Banglore", Department.Testing));

		System.out.println("$$ By dept Type ");

		Map<Department, List<Employee>> departmentType = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		departmentType.forEach((deptName, list) -> {
			System.out.println("deptName" + deptName);
			list.forEach(System.out::println);
		});

		System.out.println("$$ By dept Type and location ");

		Map<MyTuple, List<Employee>> departmentTypeAndLocation = employees.stream().collect(
				Collectors.groupingBy(employee -> new MyTuple(employee.getDepartment(), employee.getLocation())));

		departmentTypeAndLocation.forEach((tuple, list) -> {
			System.out.println(tuple + " ## List -> ");
			System.out.println("----");
			list.forEach(System.out::println);
			System.out.println("------");
		});

	}

}
