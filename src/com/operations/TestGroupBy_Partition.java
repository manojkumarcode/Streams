package com.operations;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pojo.Product;

public class TestGroupBy_Partition {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product("apple", 10, 9.99), new Product("banana", 20, 19.99),
				new Product("orange", 10, 29.99), new Product("watermelon", 10, 29.99), new Product("papaya", 20, 9.99),
				new Product("apple", 10, 9.99), new Product("banana", 11, 19.99), new Product("apple", 10, 9.99));

		// products.forEach(System.out::println);

		products.stream().collect(Collectors.groupingBy(Product::getName)).forEach((key, value) -> {
			System.out.println(key + ": values = " + value);
		});

		products.stream().collect(Collectors.groupingBy(Product::getName)).forEach((key, list) -> {
			System.out.println(key + ": values = ");
			list.forEach(System.out::println);
			System.out.println("***************");
		});

		products.stream().collect(Collectors.groupingBy(Product::getName, Collectors.counting()))
				.forEach((key, num) -> {
					System.out.println(key + ": num=" + num);
					System.out.println("***************");
				});
		
		Map<Boolean, List<Product>> map = products.stream().collect(Collectors.partitioningBy((product) -> {
			return product.getQty() == 10; 
			}
		)
		);
		
		map.forEach((key, list) -> {
			System.out.println(key + ": " + list);
		});
		
		Map<Boolean, List<Product>> map2 = products.stream().collect(Collectors.partitioningBy((product) -> {
			return product.getQty() == 100; 
			}
		)
		);
		
		map2.forEach((key, list) -> {
			System.out.println(key + ": " + list);
		});
		
		System.out.println("#####stats##########");
		
		Map<String, Integer> map3 = products.stream().collect(Collectors.groupingBy(Product::getName, Collectors.summingInt(Product::getQty)));
		System.out.println(map3);
		
		DoubleSummaryStatistics stats = products.stream().mapToDouble(Product::getPrice).summaryStatistics();
		System.out.println(stats);
		
		Map<String, IntSummaryStatistics> summrizingInt = products.stream().collect(Collectors.groupingBy(Product::getName, Collectors.summarizingInt(Product::getQty)));
		System.out.println(summrizingInt);

	}

}
