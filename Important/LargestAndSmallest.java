package com.gyan.Important;

public class LargestAndSmallest 
{
	public static void largestK(int a[],int k)
	{
		// largest at Kth Position
		int temp;
		for (int i =0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]<a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			if(i==k-1)
			{
				System.out.println("largest element at kth position :" + a[i]);
				break;
			}
		}	
		System.out.println("=========");
		for (int i=0;i<a.length; i++)
		{
			System.out.print(a[i]+ ",");
		}
		System.out.println();
		System.out.println("-------------");
	}
	
	
	public static void smallestK(int a[],int k)
	{
		// smallest at Kth Position
		int temp;
		for (int i =0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			if(i==k-1)
			{
				System.out.println("Smallest Element at Kth Position :" + a[i]);
				break;
			}
		}	
		System.out.println("=========");
		for (int i=0;i<a.length; i++)
		{
			System.out.print(a[i] + ",");
		}
	}
	
	public static void main(String[] args) {
		int array []= {4,3,5,2,5,8,9,11,3,9,10};
		largestK(array, 3);
		smallestK(array, 3);
	}

}
