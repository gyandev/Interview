package com.gyan.Important;

public class MergeTwoSortedArrays 
{
	
	public static int[] merge(int a[],int b[])
	{
		int i=0,j=0,k=0;
		int n1=a.length;
		int n2=b.length;
		int c[] =new int [n1+n2];
		while(i<n1 && j<n2)
		{
			if(a[i] < b[j])
			{
				c[k++]= a[i++];	
			}
			else
			{
				c[k++] = b[j++];
			}
		}
		while(i<n1)
		{
			c[k++]= a[i++];	
		}
		while(j<n2)
		{
			c[k++] = b[j++];
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		int a[] = {1,3,4,5,6};
		int b[] = {3,5,9,10,11};
		int [] c= merge(a,b);
		
		for(int i=0;i<c.length;i++)
		{
			System.out.print(c[i] + " ");
		}
	}
	

}
