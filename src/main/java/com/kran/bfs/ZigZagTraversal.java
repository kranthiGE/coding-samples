package com.kran.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import com.kran.TreeNode;

class ZigZagTraversal {
	  public static List<List<Integer>> traverse(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    
	    traverseByBfs(root, result);
	    return result;
	  }
	  
	  public static void traverseByBfs(TreeNode root, List<List<Integer>> result) {
		  if (root == null) {
			  return;
		  }
		  
		  Queue<TreeNode> queue = new LinkedList<>();
		  int levelSize = 0;
		  boolean leftToRight = true;
		  
		  queue.add(root);
		  
		  while(!queue.isEmpty()) {
			  levelSize = queue.size();
			  
			  // add elements from rls into result based on levelSize
			  List<Integer> rls = new LinkedList<>();
			  for(int i = 0; i < levelSize; i++) {
				// visit node
				  TreeNode node = queue.poll();
				
				  Optional<Integer> value = Optional.ofNullable(node.val);

				  if(!leftToRight)
					  rls.add(0, value.isPresent() ? value.get() : 0);
				  else
					  rls.add(value.isPresent() ? value.get() : 0);
				  
				  if(node.left != null)
					  queue.add(node.left);
				  if(node.right != null)
					  queue.add(node.right);
				  
				  leftToRight = !leftToRight;
			  }
			  result.add(rls);
		  }
	  }
	
	  public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
	    List<List<Integer>> result = ZigZagTraversal.traverse(root);
	    System.out.println("Level order traversal: " + result);
	  }
}
