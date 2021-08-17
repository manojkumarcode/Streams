package com.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.pojo.Product;

public class TestGroupBy_Partition {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product("apple", 10, 9.99), new Product("banana", 20, 19.99),
				new Product("orange", 10, 29.99), new Product("watermelon", 10, 29.99), new Product("papaya", 20, 9.99),
				new Product("apple", 10, 9.99), new Product("banana", 11, 19.99), new Product("apple", 10, 9.99));
		
		//products.forEach(System.out::println);
		
		products.stream().collect(Collectors.groupingBy(Product::getName)).forEach(
				(key, value) ->
				{
					System.out.println(key + ": values = " + value);
				}
				);
		
		products.stream().collect(Collectors.groupingBy(Product::getName)).forEach(
				(key, list) ->
				{
					System.out.println(key + ": values = " );
					list.forEach(System.out::println);
					System.out.println("***************");
				}
				);
		
		
		products.stream().collect(Collectors.groupingBy(Product::getName, Collectors.counting())).forEach(
				(key, num) ->
				{
					System.out.println(key + ": num=" + num);
					System.out.println("***************");
				}
				);


	}

}
