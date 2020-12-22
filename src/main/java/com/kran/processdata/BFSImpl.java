package com.kran.processdata;

import java.util.LinkedList;
import java.util.Queue;

public class BFSImpl {

	// breadth first search implementation using MyQueue
	// in bfs, we visit each neighbour nodes of an arbitrarily selected node in a graph and then proceed to the next node
	// this is mainly implemented using queue.
	private GraphNode<Integer> gNode;
	private Queue<GraphNode<Integer>> queue;

	public BFSImpl(GraphNode<Integer> gRoot) {
		this.gNode = gRoot;
		queue = new LinkedList<>();
	}
	
	public void search() {
		if(gNode == null)
			throw new NullPointerException("root node is null");
		visit(gNode);
		queue.add(gNode);//added root node
		//printQueue();
		
		while(!queue.isEmpty()) {
			//printQueue();
			gNode = queue.poll();
			//System.out.println("node fetched from queue = " + gNode.getNumber());
			
			for(GraphNode<Integer> node : gNode.getGraphNodes()) {
				if(!node.isVisisted()) {
					visit(node);
					node.setVisisted(true);
					queue.add(node);
				} else {
					System.out.println("node already visited: " + node.getNumber());
				}
				
			}
		}
	}
	
	public void searchRouteBetweenNodes(GraphNode<Integer> fromNode, GraphNode<Integer> toNode) {
		
		
	}
	
	private void printQueue() {
		System.out.println("queue length" + queue.size());
	}
	
	public void visit(GraphNode<Integer> node) {
		System.out.print(node.getNumber() + " --> ");
	}
	
	public static void main(String[] args) {
		
		GraphNode<Integer> gEnd = new GraphNode<Integer>(7, new GraphNode[0]);

		GraphNode<Integer> node6 = new GraphNode<Integer>(6, new GraphNode[] {
				new GraphNode<Integer>(5, new GraphNode[] {
						gEnd
				})
		});
		
		GraphNode<Integer> gRoot = new GraphNode<Integer>(1, new GraphNode[] { 
					new GraphNode<Integer>(4, new GraphNode[] {
							new GraphNode<Integer>(7, new GraphNode[0]),
							node6
					}),
					new GraphNode<Integer>(3, new GraphNode[] {
							node6
							
					})
					});
		
		
		BFSImpl bfs = new BFSImpl(gRoot);
		bfs.search();
		
	}
	
	
}
