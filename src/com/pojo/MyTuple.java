package com.pojo;

import java.util.Objects;

public class MyTuple {

	private Department department;
	private String location;

	public MyTuple() {

	}

	public MyTuple(Department department, String location) {
		super();
		this.department = department;
		this.location = location;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyTuple other = (MyTuple) obj;
		return department == other.department && Objects.equals(location, other.location);
	}

	@Override
	public String toString() {
		return "MyTuple [department=" + department + ", location=" + location + "]";
	}

}
