package com.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.pojo.Student;

public class TransformationUsingMap {

	public static void main(String[] args) {
		List<Student> students1 = Arrays.asList(new Student(12, "aBC", new int[] { 3, 1, 2 }),
				new Student(17, "CBC", new int[] { 30, 45, 10 }), new Student(1, "XYZ", new int[] { 5, 12, 77 }),
				new Student(16, "a", new int[] { 6, 5, 6 }), new Student(2, "a", new int[] { 7, 9, 60 }),
				new Student(55, "a", new int[] { 30, 50, 5 }));
		
		
		calculateTotalMarks(students1).forEach(System.out::println);
		calculateTotalMarks1(students1).forEach(System.out::println);

	}
	
	//here data is getting transformed from List<Student> to List<Integer>
	public static List<Integer> calculateTotalMarks(List<Student> students) {
		
		return students.stream().map(
				(stu) -> {
					int total = 0; 
					for(int mark : stu.getMarks()) {
						total = total + mark; 
						
					}
					return total;
			
		}).collect(Collectors.toList());
	}
	
	
	public static List<Student> calculateTotalMarks1(List<Student> students) {
		
		return students.stream().map(
				(student) -> {
					int total = 0; 
					for(int mark : student.getMarks()) {
						total = total + mark; 
					}
					student.setPercentage(total);
					return student;
			
		}).collect(Collectors.toList());
	}

}
