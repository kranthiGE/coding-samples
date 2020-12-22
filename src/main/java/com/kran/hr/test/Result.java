package com.kran.hr.test;

public class Result {
	
	
    public static void fizzBuzz(int n) {
	    	if(n < 1 && n <= Integer.MAX_VALUE) {
	    		System.err.println("n must be greater than 0 and less than " + Integer.MAX_VALUE);
	    	}
	
	    	for(int i = 1; i <= n; i++) {
			
			int for3 = Math.abs(i % 3);
			int for5 = Math.abs(i % 5);
			
			if(for3 + for5 == 0) {
				System.out.println("FizzBuzz");
				continue;
			}
			
			if(for3 != 0 && for5 != 0) {
				System.out.println(i);
				continue;
			}
			
			if(for3 == 0 && for5 != 0) {
				System.out.println("Fizz");
				continue;
			}
			
			System.out.println("Buzz");
			
		}
    }
    
    
    public static void main(String[] args) {
    		int n = 50;
    		fizzBuzz(n);
    		
    }

}
