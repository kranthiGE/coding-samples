package com.kran.bfs.bidirectional;

import java.util.LinkedList;

public class PathNode {
	
	private Person person;
	private PathNode previousNode;

	public PathNode(Person person) {
		this.person = person;
	}
	
	public PathNode getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(PathNode previousNode) {
		this.previousNode = previousNode;
	}

	public Person getPerson() {
		return person;
	}

	// collapse the paths of both the ends to form the merged path from source and destination and return the shortest path in linked list form
	public LinkedList<Person> collapse(boolean addToLast){
		LinkedList<Person> shortestPath = new LinkedList<>();
		PathNode node = this;
		
		while(node != null) {
			Person person = node.getPerson();
			if(addToLast) {
				shortestPath.addLast(person);
			}
			else {
				shortestPath.addFirst(person);
			}
			node = node.getPreviousNode();
		}
		
		return shortestPath;
	}
	
}
