package com.kran.dfs;

import java.util.HashMap;
import java.util.Map;

public class Node {
	
	public String place;
	public boolean isVisited;
	public Map<Node, Integer> adjMap = new HashMap<>();
}
