package com.kran.dfs;


import com.kran.TreeNode;

public class MaxPathSum {
	
	static int globalSum = 0;

	public static int findMaximumPathSum(TreeNode root) {
		globalSum = Integer.MIN_VALUE;
		find(root);
		//System.out.println("global = " + globalSum);
		
		return globalSum;
	}
	
	public static int find(TreeNode node) {

		if(node == null) {
			return 0;
		}
		
		int left = find(node.left);
		int right = find(node.right);
		
		int localSum = Math.max(left, 0) + Math.max(right, 0) + node.val;
		int returnval = Math.max(left, right) + node.val;
		//System.out.println("left = " + left + " right = " + right + " local sum = " + localSum + " current = " + node.val + " return val = " + returnval);
		
		globalSum = Math.max(globalSum, localSum);
		
		//System.out.println(globalSum);
		return returnval;
	}

	public static void main(String[] args) {
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    System.out.println("Maximum Path Sum: " + MaxPathSum.findMaximumPathSum(root));
	    
	    root.left.left = new TreeNode(1);
	    root.left.right = new TreeNode(3);
	    root.right.left = new TreeNode(5);
	    root.right.right = new TreeNode(6);
	    root.right.left.left = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
	    root.right.right.left = new TreeNode(9);
	    System.out.println("Maximum Path Sum: " + MaxPathSum.findMaximumPathSum(root));
	    
	    root = new TreeNode(-1);
	    root.left = new TreeNode(-3);
	    System.out.println("Maximum Path Sum: " + MaxPathSum.findMaximumPathSum(root));
	  }
}
