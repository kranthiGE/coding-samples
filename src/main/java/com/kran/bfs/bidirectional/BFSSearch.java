package com.kran.bfs.bidirectional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BFSSearch {
	
	public LinkedList<Person> search(HashMap<Integer, Person> gmap, int sourcePersonId, int destinationPersonId){
		BFSData source = new BFSData(gmap.get(sourcePersonId));
		BFSData destination = new BFSData(gmap.get(destinationPersonId));
		
		// check if any of the source/destination toVisit nodes are empty 
		// which means there are no further friends of a Person that had not been visited
		while(!source.isEmpty() || !destination.isEmpty()) {
			PathNode collision = traverse(gmap, source, destination);
			if(collision != null) {
				return mergePaths(collision.getPerson().getId(), source, destination);
			}
			
			// traverse from destination treating it as root
			PathNode collisionDest = traverse(gmap, destination, source);
			if(collisionDest != null) {
				return mergePaths(collisionDest.getPerson().getId(), destination, source);
			}
		}
		
		return null;
	}
	
	private PathNode traverse(HashMap<Integer, Person> gmap, BFSData source, BFSData destination) {
		// traverse through the source only to the initial count of toVisit nodes
		int count = source.toVisit.size();
		for(int i = 0; i <= count; i++) {
			PathNode soureNode = source.toVisit.peek();
			Person person = source.toVisit.poll().getPerson();
			
			// check if source Person id exists in the visited node of destination
			// then we found the collision and return the Person/PathNode object
			if(destination.visited.containsKey(person.getId())) {
				return destination.visited.get(person.getId());
			}
			
			// create path nodes for each friend and add into toVisit
			List<Integer> friends = person.getFriends();
			for (Integer friendId : friends) {
				if(!source.visited.containsKey(friendId)) {// don't add the visited node to queue
					Person friend = gmap.get(friendId);
					PathNode fpathNode = new PathNode(friend);
					fpathNode.setPreviousNode(soureNode);
					source.toVisit.add(fpathNode);
				}
			}
			
			source.visited.put(person.getId(), soureNode);
			
		}
		return null;
	}
	
	private LinkedList<Person> mergePaths(int collisionId, BFSData source, BFSData destination){
		
		PathNode snode = source.visited.get(collisionId);
		PathNode dnode = destination.visited.get(collisionId);
		
		LinkedList<Person> finalList = new LinkedList<>();
		
		finalList.addAll(snode.collapse(false));
		
		LinkedList<Person> destList = dnode.collapse(true);
		destList.removeFirst();// collisionId node was already above and so remove it.
		finalList.addAll(destList);
		
		return finalList;
	}

}
