package com.kran.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Queue;

import com.kran.TreeNode;

public class MinElementsInTreeLevel {

	public static int findDepth(TreeNode root) {
	    // TODO: Write your code here
	    List<Integer> result = new ArrayList<>();
	    findDepth(root, result);
	    OptionalInt minVal = result.stream().mapToInt(i -> i).min();
	    return minVal.isPresent() ? minVal.getAsInt() : 0;
	  }

	  public static void findDepth(TreeNode node, List<Integer> result) {
		  
		  List<List<Integer>> rls = new ArrayList<>();
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  int level = 0;
		  
		  queue.add(node);
		  while(!queue.isEmpty()) {
			  level = queue.size();
			  
			  List<Integer> currentLevel = new ArrayList<>();
			  for(int i = 0; i < level; i++) {
				  TreeNode n = queue.poll();
				  
				  currentLevel.add(n.val);
				  
				  if(n.left != null)
					  queue.add(n.left);
				  if(n.right != null)
					  queue.add(n.right);
				  
			  }
			  rls.add(currentLevel);
			  System.out.println("current = " + currentLevel.size());
		  }
		  
	  }

	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    System.out.println("Tree Minimum Depth: " + MinElementsInTreeLevel.findDepth(root));
	    root.left.left = new TreeNode(9);
	    root.right.left.left = new TreeNode(11);
	    System.out.println("Tree Minimum Depth: " + MinElementsInTreeLevel.findDepth(root));
	  }
}
