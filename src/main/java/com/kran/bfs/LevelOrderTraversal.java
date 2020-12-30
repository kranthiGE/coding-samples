package com.kran.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import com.kran.TreeNode;

class LevelOrderTraversal {
	  public static List<List<Integer>> traverse(TreeNode root) {
	    List<List<Integer>> result = new LinkedList<List<Integer>>();
	    
	    traverseByBfs(root, result);
	    return result;
	  }
	  
	  public static void traverseByBfs(TreeNode root, List<List<Integer>> result) {
		  if (root == null) {
			  return;
		  }
		  
		  Queue<TreeNode> queue = new LinkedList<>();
		  int levelSize = 0;
		  
		  queue.add(root);
		  
		  while(!queue.isEmpty()) {
			  levelSize = queue.size();
			  
			  // add elements from rls into result based on levelSize
			  List<Integer> rls = new ArrayList<>();
			  for(int i = 0; i < levelSize; i++) {
				// visit node
				  TreeNode node = queue.poll();
				
				  Optional<Integer> value = Optional.ofNullable(node.val);
				  rls.add(value.isPresent() ? value.get() : 0);
				  
				  if(node.left != null)
					  queue.add(node.left);
				  if(node.right != null)
					  queue.add(node.right);
			  }
			  result.add(0, rls);
		  }
	  }
	
	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
	    System.out.println("Level order traversal: " + result);
	  }
}
