package com.gyan.Important;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyArrayByStream 
{
	
	public static void main(String[] args) {
		
		List<Integer> list =Arrays.asList(1,2,2,3,4,5,6,7,3,4,5,6);
		Map<Integer, Long> result=list.stream()
				.collect(Collectors.groupingBy(
						Function.identity(),
						Collectors.counting())
						);
		System.out.println(result);
		
		
	}

}
