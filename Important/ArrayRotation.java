package com.gyan.Important;

import java.util.Arrays;

// Rotate the array by n postion
public class ArrayRotation 
{
	
	public static void rotation(int[] array, int n,int d)
	{
		for(int i=0;i<d;i++)
		{
			leftRotate(array, n);
		}
	}
	private static void leftRotate(int[] array, int n) 
	{
		int temp,i;
		temp=array[0];
		for(i=0;i<n-1;i++)
		{
			array[i]=array[i+1];			
		}
		array[i]=temp;

		
	}
	public static void main(String args[])
	{
		int array[] = {1,2,3,4,5};
		int n=array.length;
		int d=2;
		rotation(array,n,d);
		System.out.println(Arrays.toString(array));
		
	}
	
	

}
