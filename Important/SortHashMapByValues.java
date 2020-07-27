package com.gyan.Important;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * The idea is to store the entry set in a list and sort the list on the 
 * basis of values. Then fetch values and keys from list and put them in
 *  new hashmap. Thus new hashmap is sorted according to values.
 * 
 */
public class SortHashMapByValues 
{
	public static HashMap<String, Integer> sortByValue(HashMap<String,Integer> hm)
	{
		List<Map.Entry<String,Integer>> list =new LinkedList<Map.Entry<String,Integer>>(hm.entrySet());
		// sort the list
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() 
		{
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o1.getValue()).compareTo(o2.getValue());
		}
			});		
		// put data from sorted List into hashMap
		
		HashMap<String, Integer> temp =new LinkedHashMap<String,Integer>();
		for(Map.Entry<String, Integer> h:list)
		{
			temp.put(h.getKey(), h.getValue());
			
		}
		
	return temp;
		
	}
	
	public static void main(String[] args) {
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("Gyan", 9);
		hm.put("Ravi", 8);
		hm.put("Ram", 12);
		hm.put("Nalini", 18);
		hm.put("Amit", 16);
		hm.put("Love", 20);
		hm.put("You", 11);
		Map<String,Integer> hm1=sortByValue(hm);
		for(Map.Entry<String, Integer> aa:hm1.entrySet())
		{
			System.out.println("Key= " + aa.getKey() + "," + "Value = " + aa.getValue());
			
		}


		
	}

}
