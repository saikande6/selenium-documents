package com.hdfc.loans.eduloans;

import java.util.Scanner;

public class ArrayDemo 
{
	Scanner sc=new Scanner(System.in);
	int sum=0;
	
	public int arraySum()
	{
		System.out.println("Enter Array Size :");
		int asize = sc.nextInt();
		int a[]=new int[asize];
		
		System.out.println("Enter Array Elements:");
		for(int i=0;i<a.length;i++)
		{
			System.out.print("a["+i+"]=");
			a[i]=sc.nextInt();
			sum=sum+a[i];
		}
		//System.out.println("Sum of array elements in inside :" + sum);
		return sum;
	}
	
	
	public static void main(String[] args) 
	{
		ArrayDemo d=new ArrayDemo();
		int count = d.arraySum();
		System.out.println("Sum of array elements in outside:" + count);	
	}
}
