package com.kran.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.kran.TreeNode;

public class TreeMinDepth {

	public static int findDepth(TreeNode root) {
	    // TODO: Write your code here
	    return findDepthByBfs(root);
//	    OptionalInt minVal = result.stream().mapToInt(i -> i).min();
//	    return minVal.isPresent() ? minVal.getAsInt() : 0;
	  }

	  public static int findDepthByBfs(TreeNode node) {
		  
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  int level = 0;
		  
		  queue.add(node);
		  while(!queue.isEmpty()) {
			  level = queue.size();
			  
			  for(int i = 0; i < level; i++) {
				  TreeNode n = queue.poll();
				  
				  // check the occurrence of the first leaf
				  if(n.left == null && n.right == null) {
					  // first leaf occurred
					  return level;
				  }
				  
				  if(n.left != null)
					  queue.add(n.left);
				  if(n.right != null)
					  queue.add(n.right);
			  }
			  
		  }
		  return level;
	  }
	  
	  public static int findMaxDepthByBfs(TreeNode root) {
			//using maximum depth algorithm in BFS style to calculate
			if(root == null) {
				throw new RuntimeException("no root provided");
			}
			
			int maxDepth = 0;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				maxDepth++;
				
				int levelSize = queue.size();
				
				for(int i = 0; i < levelSize; i++) {
					TreeNode node = queue.poll();
					
					if(node.left != null)
						queue.add(node.left);
					if(node.right != null)
						queue.add(node.right);
					
				}
			}
			
			return maxDepth;
		}

	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    System.out.println("Tree Minimum Depth: " + TreeMinDepth.findDepth(root));
	    root.left.left = new TreeNode(9);
	    root.right.left.left = new TreeNode(11);
	    System.out.println("Tree Minimum Depth: " + TreeMinDepth.findDepth(root));
	  }
}
