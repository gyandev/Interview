package com.gyan.Important;

public class MAXANDMIN 
{
	public static void findMax(int a[])
	{
		int max=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]> max)
			{
				max=a[i];
			}
		}
		System.out.println("The max element:" + max);
	}
	
	public static void findMin(int a[])
	{
		int min=a[0];
		for(int i=0;i<a.length; i++)
		{
			if(a[i]<min)
			{
				min=a[i];
			}
		}
		System.out.println("Minimum Element :" + min);
		
	}
	
	public static void main(String[] args) 
	{
		int array []= {5,5,8,9,9,3,2,4};
		findMax(array);
		findMin(array);
		
	}

}
