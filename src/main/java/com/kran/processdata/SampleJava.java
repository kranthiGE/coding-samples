package com.kran.processdata;

public class SampleJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "cloudd";
		
		int[] letters = new int[128];
		
		char[] charStr = s.toCharArray();
		
		for(char c : charStr) {
			letters[c]++;
			System.out.println(letters[c]);
		}
	}

}
