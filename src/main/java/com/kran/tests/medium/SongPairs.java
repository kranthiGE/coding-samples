package com.kran.tests.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SongPairs {
	
	
	
	public static void main(String[] args) {
		
		List<Integer> songs = new ArrayList<>();
		songs.addAll(Arrays.asList(30, 20, 150, 100));
		//songs.addAll(Arrays.asList(30, 60, 60, 60));
		//songs.add(120);
		
		System.out.println("less optimal count is " + finder(songs)); 
		System.out.println("count is " + finderOptimal(songs));
	}
	
	public static void find() {
		long count = 0;
		
		int[] arr = new int[] {30, 60, 60, 60};
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				
				int val = Math.abs(arr[i] + arr[j]);
				
				System.out.println(val);

			
				
				if(Math.abs(val  % 60) == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static long finder(List<Integer> songs) {

		long count = 0;
		
		//{30, 20, 150, 100};
		//{30, 60, 60, 60};
		
		int i = 0, j = songs.size();
		while(i < songs.size()) {
			int val = Math.abs(songs.get(i) + songs.get(j - 1));
			
			System.out.println(val);
			
			if(i == j-1) {
				i++;
				j = songs.size();
				continue;
			}
			else {
				j--;
			}
			
			if(Math.abs(val  % 60) == 0) {
				count++;
			}
		}
		return count;
	}
	
	public static long finderOptimal(List<Integer> songs) {
		long count = 0;
		int k = 60;
		int[] freq = new int[k];
		
		// we are calculating simultaneously a%k and b%k values and checking if we had found b
		// because we don't know b, we need to find a way through which we can calculate b%k based on a.
		// so, b%k = (k - a%k) % k
		for(int i = 0; i<songs.size(); i++) {
			int rem = songs.get(i) % k;
			count += freq[(k - rem) % k];
			freq[rem]++;
			System.out.println(rem); // 20
			System.out.println((k - rem) % k); // 40
			System.out.println("");
			// 
		}

		
		return count;
	}

}
