package com.kran.tests.medium;

import java.util.Arrays;

public class FindMinDifference {
	
	private int[] arr1;
	private int[] arr2;
	
	public FindMinDifference(int[] arr1, int[] arr2) {
		this.arr1 = arr1;
		this.arr2 = arr2;
	}

	public static void main(String[] args) {
		/* input = 2 pair of numbers
		{1,3,15,11,2}
		{23,127,235,19,8}
		output = 3. pair = {11,8}
		*/
		// write optimal code to find the minimum difference between a pair of a numbers
		FindMinDifference min = new FindMinDifference(new int[]{1,3,15,11,2}, new int[]{23,127,235,19,8});
		System.out.println(min.find());
		
	}
	
	public int find() {
		
		// sort the arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i = 0, j = 0;
		
		int min = Integer.MAX_VALUE;
		while(i < arr1.length && j < arr2.length) {
			int diff = Math.abs(arr1[i] - arr2[j]);
			if(diff < min) {
				min = diff;
			}
			
			if(Math.abs(arr1[i]) < Math.abs(arr2[i])) {
				i++;
			} else {
				j++;
			}
		}
		return min;
	}

}
