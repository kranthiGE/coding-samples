package com.kran.bfs;

public class PathTraveled {
	
	StringBuilder places = new StringBuilder();
	int totalDistance = 0;
	
	public PathTraveled() {
		
	}

	public void setPlace(String place, int dist) {
		places.append(place).append("-->");
		totalDistance += dist;
	}
	
	@Override
	public String toString() {
		return places.toString();
	}

}
