package com.kran.bfs.bidirectional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {
	public HashMap<Integer, PathNode> visited = new HashMap<>();
	public Queue<PathNode> toVisit = new LinkedList<>();
	
	public BFSData(Person person) {
		PathNode pathNode = new PathNode(person);
		visited.put(person.getId(), pathNode);
		toVisit.add(pathNode);
	}
	
	public boolean isEmpty() {
		return toVisit.isEmpty();
	}

}
