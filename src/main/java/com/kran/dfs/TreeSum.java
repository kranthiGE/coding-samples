package com.kran.dfs;

import com.kran.TreeNode;

public class TreeSum {
	public static boolean hasPath(TreeNode root, int sum) {
		
		return find(root, sum);
	  }
	
	public static boolean find(TreeNode node, int s) {
		
		if(node == null) {
			return false;
		}
		
		// check if it is leaf
		if(node.left == null && node.right == null && node.val - s == 0) {
			return true;
		}
		
		return find(node.left, Math.abs(s - node.val)) || find(node.right, Math.abs(s - node.val));
		
	}

	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    System.out.println("Tree has path: " + TreeSum.hasPath(root, 23));
	    System.out.println("Tree has path: " + TreeSum.hasPath(root, 16));
	  }
}
