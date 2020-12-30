package com.kran.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.kran.TreeNode;

class LevelOrderSuccessor {
	  public static TreeNode findSuccessor(TreeNode root, int key) {
		  
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  queue.add(root);
		  
		  while(!queue.isEmpty()) {
			  TreeNode n = queue.poll();
			  
			  if(n.left != null) {
				  queue.add(n.left);
			  }
			  if(n.right != null) {
				  queue.add(n.right);
			  }
			  
			// if n is not a leaf then n.left is the successor
			  // else if n is 
			  
			  if(n.val == key) {
				  break;
			  }
		  }
		  
		  return queue.peek();   
	  }
	
	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
	    if (result != null)
	      System.out.println(result.val + " ");
	    result = LevelOrderSuccessor.findSuccessor(root, 9);
	    if (result != null)
	      System.out.println(result.val + " ");
	  }
}