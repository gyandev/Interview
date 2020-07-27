package com.gyan.Important;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class FrequencyArray 
{
	
	public static void frequentElement(int a[])
	{
        //Creating HashMap object with elements as keys and their occurrences as values
		HashMap<Integer,Integer> hashMap =new HashMap<>();
        //Inserting all the elements of inputArray into elementCountMap
		for(int i:a)
		{
            //If an element is present, incrementing its count by 1
			if(hashMap.containsKey(i))
			{
				hashMap.put(i, hashMap.get(i)+1);
			}
			else
			{
				hashMap.put(i, 1);
			}
			
		}
	int element =0;
		int frequency =0;
		
		Set<Entry<Integer,Integer>> entrySet = hashMap.entrySet();
		for(Entry<Integer,Integer> entry :entrySet)
		{
			if(entry.getValue() > frequency)
			{
				element =entry.getKey();
				frequency =entry.getValue();
			}
			
//			System.out.println("The frequency of a given number "+  entry.getKey() + " is " +  entry.getValue());
//			System.out.println(entry.getValue());
		}
		if(frequency>1)
		{
			System.out.println("Input Array :" + Arrays.toString(a));
			System.out.println("The most frequent element is:" + element);
			System.out.println("Its frequency is: " + frequency);
			
		}

	}
	
	public static void main(String[] args) {
		int a[] = {2,3,4,4,3,2,1,2,9,8,4};
		frequentElement(a);
	}

}
