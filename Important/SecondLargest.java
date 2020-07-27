package com.gyan.Important;

public class SecondLargest 
{
	// 1st way:O(n2)
	public static void secondlargest(int a[])
	{
		int temp;
		for (int i =0;i<a.length;i++)
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
		}
		System.out.println("The second largest is : " + a[1]);
	}
	
	// using one for loop
	public static void secondLar(int a[])
	{
		int largest = Integer.MIN_VALUE;
		int second_largest = Integer.MIN_VALUE;
		
		for (int i=0;i<a.length;i++)
		{
			if(a[i] > largest)
			{
				second_largest =largest;
				largest = a[i];
			}
			else if((a[i]> second_largest) && (a[i] != largest))
			{
				 second_largest = a[i];
			}
		}
		
		System.out.println("Second largest : " + second_largest);
	}
	
	public static void main(String[] args) {
		int array []= {4,3,5,2,5,8};
		secondlargest(array);
		secondLar(array);
	}

}
