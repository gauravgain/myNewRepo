package main.java;
/*
 * 
PROBLEM:
You're given an array of integers (eg [3,4,7,1,2,9,8]), write a program to find the index of values that satisfy A+B = C + D, where A,B,C & D are integers values in the array. 
Eg: Given [3,4,7,1,2,9,8] array the following, 
3+7 = 1+ 9 satisfies A+B = C+D 
Print: (0,2,3,5)

SOLUTION:
1. Sort the Array 
2. Take two pointers left (start of the array) and right (end of the array) 
3. Find the sum of the left and right value in the array 
4. Look up iteratively the sum within the subarray , if sum is found print it 
4.a if sum is greater value then increment left side ( i ) or else reduce the (j) value
 * 
 */

import java.util.Arrays;


public class IndexFinder {

	public static void main(String[] args) {

		int[] arr= {3,4,7,1,2,9,8};
		//int[] arr={5,8,9,1,4,11,13,17,3,2};
		indexPairSum(arr);		
	}

	public static Integer[] ConvertArry(int[] arr){
		Integer myArray[] = new Integer[arr.length];
		
		// convert int[] to Integer[]
		for(int ctr = 0; ctr < arr.length; ctr++) {
			myArray[ctr] = Integer.valueOf(arr[ctr]);
		}
		return myArray;
	}
	
	public static void indexPairSum(int arr[])	
	{
	//Return the array if Size less than 4
	if(arr.length < 4)
	{		return;	}
	
	// copy array
	Integer OrgArry[] = ConvertArry(arr);
	
	// Sort the array
	Arrays.sort(arr);	
	// Take two pointer left and right
	int left =0;
	int right = arr.length-1;
	
	// decrease the right pointer on each pass * array is sorted
	for(;left<right;right--)
	{
		// Take sum of left and right
		int outSum = arr[left] + arr[right];
		int i = left;
		int j = right -1;
		// Apply Logic of Pairs in Array of Integers whose Sum is equal to a given Number
		// look up the sum within the subarray
		while(i<j)
		{
			if( arr[i]+arr[j] == outSum)
			{
				System.out.println( " ("+arr[i]+" , "+arr[j]+ ") = "+" ("+arr[left]+" , "+arr[right]+")" +"  Indexs["+Arrays.asList(OrgArry).indexOf(arr[i])+","+Arrays.asList(OrgArry).indexOf(arr[j])+","+Arrays.asList(OrgArry).indexOf(arr[left])+","+Arrays.asList(OrgArry).indexOf(arr[right])+"]");
				i++;
				j--;
			}
			//
			else if( arr[i]+arr[j] < outSum)
			{
				i++;
			}
			else if( arr[i]+arr[j] > outSum)
			{
				j--;
			}
		}
	}
}
}