package com.kran.dfs;

import com.kran.TreeNode;

class SumOfPathNumbers {

	public static int findSumOfPathNumbers(TreeNode root) {
	  int s = 0;
	  return findSumOfPathNumbers(root, s);
  }
  
  public static int findSumOfPathNumbers(TreeNode root, int s) {
	  
	  if(root == null) {
		  return 0;
	  }
	  
	  s = Integer.valueOf(s + "" + root.val);
	  
	  // leaf
	  if(root.left == null && root.right == null) {
		  return s;
	  }
		  // first towards left and then right
	  return findSumOfPathNumbers(root.left, s) + findSumOfPathNumbers(root.right, s);
  }

  public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(0);
	root.right = new TreeNode(1);
	root.left.left = new TreeNode(1);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(5);
	System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}
