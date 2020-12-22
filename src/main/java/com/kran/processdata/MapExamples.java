package com.kran.processdata;

import java.util.List;

public class MapExamples {
	
	
	class Country{
		
		private String continent;
		
		private Integer population;
	
		String getContinent() {
			return continent;
		}
		
		Integer getPopulation() {
			return population;
		}
	}
	
	public Integer getTotalPopulation(List<Country> countries, String continent) {
		 return countries.stream()
			.filter(c -> c.getContinent().equals(continent))
			.map(c -> c.getPopulation())
			.reduce(0, Integer::sum);
		
	}

}
