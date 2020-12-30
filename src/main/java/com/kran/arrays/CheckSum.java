package com.kran.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class CheckSum
{   
  public static int[] findSum(int[] arr, int n) 
  {
    int[] result = new int[2];
    // write your code here
    int size = arr.length;
    int i = 0, j = size;

    while(j >= 0){
      System.out.println("i = " + i);
      int value = arr[i];
      if(value + arr[j-1] == n){
        result[0] = value;
        result[1] = arr[j-1];
        break;
      }
      if(i < (j - 1)){
        i++;
      }
      else {
        i = 0;
        j--;
      }
    }

    return result;   // return the elements in the array whose sum is equal to the value passed as parameter 
  }

    
    public static void main(String[] args) {    	
    	  int[] result = findSum(new int[] {1,3,4,5,2,86,21,53,76,11,19,20}, 22);
    	  for (int i : result) {
			System.out.println(i);
		}
    	  
    	  HashMap<Integer, Integer> hmap = new HashMap<>();
    	  hmap.put(5, 10);
    	  hmap.put(5, 9);
    	  
    	  hmap.forEach((k,v) -> System.out.println(k + " = " + v));
    	  
    }
    
    
  
    
}