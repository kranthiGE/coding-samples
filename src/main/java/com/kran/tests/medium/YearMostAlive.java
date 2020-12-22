package com.kran.tests.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class YearMostAlive {

	private int min, max;
	private Person[] persons;
	
	public YearMostAlive(Person[] persons, int min, int max) {
		this.max = max;
		this.min = min;
		this.persons = persons;
	}
	
	public int computeMostLivedYear() {
		int aliveCounter = 0;
		int maxAliveYear = min;
		
		// create 2 arrays with sorted values of birth and death
		int[] birthYears = getArrayByYearAsc(true);
		int[] deathYears = getArrayByYearAsc(false);
		// test the sort by printing.
		// need to use IntStream to print int values. does not work with plain Stream.of()
		IntStream.of(deathYears).forEach(y -> System.out.println(y)); 
		
		/*
		 * 01 10 10 12 13 20 23 75 83 90
		 * 15 72 82 90 94 98 98 98 98 99
		 * 
		 * loop through till the length?
		 * increment aliveCounter based on birthYears values as long as birthYears[i] <= deathYears[j]
		 * else decrement aliveCounter
		 * store latest year value into maxAliveYear whenever we decrement
		 */
		int i = 0, j = 0;
		while(i < birthYears.length) {
			
			if(birthYears[i] <= deathYears[j]) {
				aliveCounter++;
				maxAliveYear = birthYears[i];
				// inc i
				i++;
			}
			else {
				// inc j
				j++;
				aliveCounter--;
				maxAliveYear = birthYears[aliveCounter];
			}
		}
		return maxAliveYear;
	}
	
	private int[] getArrayByYearAsc(boolean onBirth) {
		int[] years = new int[persons.length];
		for(int i = 0; i < persons.length; i++) {
			years[i] = onBirth ? persons[i].getBirthYear() : persons[i].getDeathYear();
		}
		Arrays.sort(years);
		return years;
	}
	
	
	public static void main(String[] args) {
		// create persons
		Person[] persons = new Person[] {
				new Person(1912, 1915),
				new Person(1920, 1990),
				new Person(1910, 1998),
				new Person(1901, 1972),
				new Person(1910, 1998),
				new Person(1923, 1982),
				new Person(1913, 1998),
				new Person(1990, 1998),
				new Person(1983, 1999),
				new Person(1975, 1994)
		};
		YearMostAlive alive = new YearMostAlive(persons, 1900, 2000);
		System.out.println("most alived year is " + alive.computeMostLivedYear()); 
		
	}
	
}
