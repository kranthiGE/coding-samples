package com.kran.bfs;

import java.util.*;

	class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	
	  TreeNode(int x) {
	    val = x;
	  }
	};

	class FindAllTreePaths {
	  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
	    List<List<Integer>> allPaths = new ArrayList<>();
	    if(root == null){
	        return null;
	    }
	    
	    List<Integer> ls = new ArrayList<>();
	    
    		findRecursivePaths(root, ls, sum, allPaths);
	    
	    return allPaths;
	  }
	  
	  public static void findRecursivePaths(TreeNode root, List<Integer> rls, int sum, List<List<Integer>> allPaths) {
		
		if(root == null){
	        return;
	    }
		
		rls.add(root.val);
		
		if(root.left == null && root.right == null && sum == root.val){
			allPaths.add(new ArrayList<>(rls));
			
		}
		else {
			if(root.left != null)
				findRecursivePaths(root.left, rls, sum - root.val, allPaths);
			if(root.right != null)
				findRecursivePaths(root.right, rls, sum - root.val, allPaths);
		}
		rls.remove(rls.size() - 1);
		
	  }
	
	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(4);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    int sum = 23;
	    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
	    System.out.println("Tree paths with sum " + sum + ": " + result);
	  }
}
