package com.kran.dfs;


import com.kran.TreeNode;

public class TreeDiameter {
	
	static int globalSize = 0;

	public static int findDiameter(TreeNode root) {
			
		find(root);
		System.out.println("global = " + globalSize);
		
		return globalSize;
	}
	
	public static int find(TreeNode node) {

		if(node == null) {
			return 0;
		}
		
		int left = find(node.left);
		int right = find(node.right);
		
		int diameter = left + right + 1;
		
		int localMax = Math.max(left, right) + 1;
		System.out.println("left = " + left + " right = " + right + " local max = " + localMax + " current = " + node.val);
		
		globalSize = Math.max(globalSize, diameter);
		
		System.out.println(globalSize);
		return localMax;
	}

	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.right.left = new TreeNode(5);
	    root.right.right = new TreeNode(6);
	    System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
	    globalSize = 0;
	    root.left.left = null;
	    root.right.left.left = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
	    root.right.right.left = new TreeNode(9);
	    root.right.left.right.left = new TreeNode(10);
	    root.right.right.left.left = new TreeNode(11);
	    System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
	  }
}
