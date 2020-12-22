package com.kran.processdata;

public class GraphNode<T> {

	private T number;
	
	private boolean isVisisted;
	
	private GraphNode<T>[] graphNodes;

	public boolean isVisisted() {
		return isVisisted;
	}

	public void setVisisted(boolean isVisisted) {
		this.isVisisted = isVisisted;
	}
	
	public GraphNode(T number, GraphNode<T>[] adjancetNodes) {
		this.number = number;
		this.graphNodes = adjancetNodes;
	}

	public T getNumber() {
		return number;
	}

	public GraphNode<T>[] getGraphNodes() {
		return graphNodes;
	}
	
	
}
