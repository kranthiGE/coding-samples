package com.kran.tests.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = findPair(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});
		if(result == null) {
			System.err.println("no pair found");
			return;
		}
		IntStream.of(result).forEach(a -> System.out.println(a));
		
	}
	
	public static int[] findPair(int[] arr1, int[] arr2) {
		// sort the arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		// get target difference
		int targetDiff = getTargetDifference(arr1, arr2);
		System.out.println(targetDiff);
		
		int a = 0, b = 0;
		
		// 
		while(a < arr1.length && b < arr2.length) {
			int diff = arr1[a] - arr2[b];
			if(diff == targetDiff) {
				int[] values = {arr1[a], arr2[b]};
				return values;
			}
			else if(diff < targetDiff) {
				a++;
			} else {
				b++;
			}
		}
		return null;
	}
	
	public static int getTargetDifference(int[] arr1, int[] arr2) {
		/*
		 * suma - a + b = sumb - b + a
		 * 2a - 2b = suma - sumb
		 *  a - b = (suma - sumb)/2
		 */
		int suma = IntStream.of(arr1).sum();
		int sumb = IntStream.of(arr2).sum();
		return (suma - sumb)/2;
	}

}
