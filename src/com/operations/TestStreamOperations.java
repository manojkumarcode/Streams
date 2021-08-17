package com.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pojo.Student;

public class TestStreamOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student> students = Arrays.asList(new Student(12, "abc", 98.78d), new Student(17, "abc", 50.70d),
				new Student(5, "XYZ", 78.78d), new Student(27, "a", 70.70d), new Student(33, "XYZ", 87.80d),
				new Student(34, "abc", 45.70d));
		
//		displayForEach(students);
//		displayStream(students);
		System.out.println("filter");
		filter(students, 50).forEach(System.out::println);
		
		System.out.println("findAllStudentsByPercentage");
		findAllStudentsByPercentage(students, 50).forEach(System.out::println);
		
		System.out.println("findAllStudentsByPercentage_limit ");
		findAllStudentsByPercentage_limit(students, 50).forEach(System.out::println);
		
		System.out.println("findNoOfStudentsByPercentage ");
		System.out.println(findNoOfStudentsByPercentage(students, 50));
		
		Optional<Student> optional = findOneStudentByName(students, "XYZ");
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}else {
			System.out.println("Not found");
		}
		
		Optional<Student> optional2 = findOneStudentByName(students, "XYZ1");
		if(optional2.isPresent()) {
			System.out.println(optional2.get());
		}else {
			System.out.println("Not found");
		}


	}
	
	public static void displayForEach(List<Student> students) {
		students.forEach(System.out::println);
	}
	
	public static void displayStream(List<Student> students) {
		students.stream().forEach(System.out::println);
	}
	
	public static List<Student> filter(List<Student> students, long per) {
		List<Student> stu_per = new ArrayList<Student>();
		for (Student student : students) {
			if(student.getPercentage() >= per) {
				stu_per.add(student);
			}
			
		}
		
		return stu_per;
	}
	
	public static List<Student> findAllStudentsByPercentage(List<Student> students, long per) {
//		 students.stream().filter( (s)-> {
//			if(s.getPercentage()>=per) {
//				return true;
//			}
//		}
//		);
		
		//students.stream().filter(s-> { return (s.getPercentage()> 50);} );
		//students.stream().filter(s->s.getPercentage()>50);
		List<Student> stu_per = students.stream().filter(s->s.getPercentage()>per).collect(Collectors.toList());
		
		return stu_per;
	}
	
	/*
	 * I want to collect just 2 of them 
	 */
	public static List<Student> findAllStudentsByPercentage_limit(List<Student> students, long per) {
//		 students.stream().filter( (s)-> {
//			if(s.getPercentage()>=per) {
//				return true;
//			}
//		}
//		);
		
		//students.stream().filter(s-> { return (s.getPercentage()> 50);} );
		//students.stream().filter(s->s.getPercentage()>50);
		List<Student> stu_per = students.stream().filter(s->s.getPercentage()>per)
				.limit(2).collect(Collectors.toList());
		
		return stu_per;
	}
	
	
	/*
	 * I want to collect just 2 of them 
	 */
	public static long findNoOfStudentsByPercentage(List<Student> students, long per) {
//		 students.stream().filter( (s)-> {
//			if(s.getPercentage()>=per) {
//				return true;
//			}
//		}
//		);
		
		//students.stream().filter(s-> { return (s.getPercentage()> 50);} );
		//students.stream().filter(s->s.getPercentage()>50);
		long count = students.stream().filter(s->s.getPercentage()> per)
				.count();
		
		return count;
	}
	
	public static Optional<Student> findOneStudentByName(List<Student> students, String name) {
		return students.stream().filter((s)-> {return s.getName().equals(name);}).findFirst();
	}


}
