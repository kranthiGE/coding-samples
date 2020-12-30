package com.kran.hr.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumAndMinDiff {

	public static int weightCapacity(List<Integer> weights, int maxCapacity) {
		
		if(weights.size() == 0) {
			return 0;
		}
		int minDiff = 0;
//		
//	    // sort the array to exclude the numbers greater than maxCapacity
//		Collections.sort(weights);
//		int a = weights.size() - 1;
//		
//		int lastIndex = weights.size() - 1;
//		
//		sum = weights.get(lastIndex);
//		// 17 22 26
//		while(lastIndex > 0 && a - 1 >= 0) {
//			// 4, 5, 8, 9
//			// 9, 8, 5, 4
//			sum = sum + weights.get(a - 1);
//			System.out.println(sum);
//			if(sum < maxCapacity && sum > minDiff) {
//				minDiff = sum;
//				//sum = 0;
//			}
//			if(a - 1 == 0) {
//				lastIndex--;
//				a = lastIndex;
//				sum = weights.get(lastIndex);
//			} else {
//				a--;
//			}
//		}
		int sum = 0;
		// first find the distinct subsets of the given array
		// we could use BFS style to iterate through the array and create an empty set and
		// in each iteration of the array, for the obtained number, add this number to the each existing value in the set
		// 4, 5, 8, 9
		List<List<Integer>> rls = new ArrayList<>();
		rls.add(new ArrayList<>());
		
		for(int num: weights) {
			//System.out.println(num);
			//System.out.println(sets.size());
			int max = rls.size();
			for(int i = 0; i < max; i++) {
				List<Integer> list = new ArrayList<>(rls.get(i));
				list.add(num);
				rls.add(list);
				//System.out.println(i);
			}
		}
		
		// print the list
		rls.stream()
			.forEach(ls -> System.out.println(ls.toString()));
		
		rls.stream()
			.forEach(ls -> System.out.println(ls.stream()
												.mapToInt(Integer::intValue)
												.sum()
					));
		
		for(List<Integer> ls: rls) {
			int total = ls.stream()
						.mapToInt(Integer::intValue)
						.sum();
			if(total < maxCapacity && total > minDiff) {
				minDiff = total;
			}
		}
			
		
		System.out.println("");
		
		return minDiff;
	}
	
	public static void main(String[] args) {
		List<Integer> weights = new ArrayList<>();
		weights.addAll(Arrays.asList(4, 8, 5, 9));

		int res = weightCapacity(weights, 20);
		System.out.println(res);
	}
}
