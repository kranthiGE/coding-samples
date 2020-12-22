package com.kran.bfs.bidirectional;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private int id;
	private String name;
	
	private List<Integer> friends = new ArrayList<Integer>();
	
	public Person(String name, int id) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getFriends() {
		return friends;
	}

	public void setFriends(List<Integer> friends) {
		this.friends = friends;
	}
		
}
