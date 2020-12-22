package com.kran.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class ShortestPath {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(shortestPath(new String[][] {
				{ "A", "B", "100" }, { "B", "C", "500" }, { "A", "D", "100" },
				{ "D", "E", "200" }, { "E", "C", "200" } }, "A", "C")));
	}
	
	// TODO : converting this to use Nodes and adjacency list for brevity and understandability.
	// However this conversion can be removed and array can be directly used for optimization. 
	public static List<Node> changeStructure(String[][] distance) {
		List<Node> nodes = new LinkedList<>();
		
		Node nodeC = new Node();
		nodeC.place = distance[4][1];
		nodeC.isVisited = false;
		
		Node nodeE = new Node();
		nodeE.place = distance[4][0];
		nodeE.isVisited = false;
		nodeE.adjMap.put(nodeC, Integer.valueOf(distance[4][2]));
		
		// { "D", "E", "200" }
		Node nodeD = new Node();
		nodeD.place = distance[3][0];
		nodeD.isVisited = false;
		nodeD.adjMap.put(nodeE, Integer.valueOf(distance[3][2]));
		
		Node nodeA = new Node();
		nodeA.place = distance[0][0];
		nodeA.isVisited = false;
		
		Node nodeB = new Node();
		nodeB.place = distance[1][0];
		nodeB.isVisited = false;
		nodeB.adjMap.put(nodeC, Integer.valueOf(distance[1][2]));
		
		// A to D
		nodeA.adjMap.put(nodeD, Integer.valueOf(distance[2][2]));
		// A to B
		nodeA.adjMap.put(nodeB, Integer.valueOf(distance[0][2]));
		
		nodes.add(nodeA);
		nodes.add(nodeB);
		nodes.add(nodeC);
		nodes.add(nodeD);
		nodes.add(nodeE);
		return nodes;
	}

	public static String[] shortestPath(String[][] distance, String src,
			String dest) {
		
		List<Node> nodes = changeStructure(distance);
		List<Map<List<String>, Integer>> paths = new ArrayList<Map<List<String>, Integer>>();
		List<String> rls = new ArrayList<>();
		Map<List<String>, Integer> distMap = new HashMap<>();
		
		paths.add(distMap);
		
		// use DFS to traverse through nodes
		// create a recursive function that calculates distance as it passes through every node in a depth
		Node root = null;
		for(Node n: nodes) {
			if(n.place.equals(src)) {
				root = n;
				break;
			}
			System.err.println("no root node");
			return null;
		}
		
		int distanceByPath = 0;
		
		findPathsInRecursive(root, distanceByPath, rls, paths, dest);
		
		Optional<Entry<List<String>, Integer>> minEntry = null;
		for (Map<List<String>, Integer> path : paths) {
			minEntry = path.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
		}
		
		int minValue = minEntry.get().getValue();
		
		System.out.println("minimum value is " + minValue + " and path is " + minEntry.get().getKey());
		
		return (new String[] {minEntry.get().getKey().toString()});
	}
		
	public static void findPathsInRecursive(Node root, int distanceByPath, List<String> rls, List<Map<List<String>, Integer>> paths, String dest) {
		if(root == null) {
			return;
		}
		
		rls.add(root.place);
		
		if(root.place.equals(dest)) {
			Map<List<String>, Integer> distMap = paths.get(0);
			distMap.put(new ArrayList<>(rls), distanceByPath);
		}
		else {
			Iterator<Entry<Node, Integer>> it = root.adjMap.entrySet().iterator();
			while(it.hasNext()) {
				Entry<Node, Integer> entry = it.next();
				findPathsInRecursive(entry.getKey(), distanceByPath + (entry.getValue() != null ? entry.getValue() : 0), rls, paths, dest);
			}
		}
		
		rls.remove(rls.size() - 1);
	}
	
	
}