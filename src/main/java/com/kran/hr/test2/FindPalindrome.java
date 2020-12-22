package com.kran.hr.test2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;


public class FindPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int occurrences = countPalindromes("aaa");
		System.out.println(occurrences);
	}
	
	public static int countPalindromes(String s) {
		// iterate through the string and find palindromes from first and last simultaneously
		List<String> result = new ArrayList<>();

		for(int i = 0; i < s.length(); i++) {
			result.addAll(find(s, i, i + 1));
			result.addAll(find(s, i, i));
		}
		return result.size();
	}
	
	public static boolean isPalindrome(String s) {
		return (new StringBuilder(s)).reverse().toString().equals(s);
	}
	
	private static List<String> find(String s, int f, int l){
		List<String> output = new ArrayList<>();
		while(f >= 0 && l < s.length() && s.charAt(f) == s.charAt(l)) {
			output.add(s.substring(f, l + 1));
			f--;
			l++;
		}
		return output;
	}
	

}
