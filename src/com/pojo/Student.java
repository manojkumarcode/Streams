package com.pojo;

import java.util.Arrays;

public class Student {
	private int rollNo;
	private String name;
	private double percentage;
	private int[] marks;
	private int age;
	private int std;

	public Student() {

	}

	public Student(int rollNo, String name, int age, int std) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.std = std;
	}

	public Student(int rollNo, String name, double percentage) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.percentage = percentage;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", percentage=" + percentage + ", marks="
				+ Arrays.toString(marks) + ", age=" + age + ", std=" + std + "]";
	}

}
