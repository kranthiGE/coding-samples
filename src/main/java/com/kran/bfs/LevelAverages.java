package com.kran.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.kran.TreeNode;

public class LevelAverages {
	
	public static List<Double> findLevelAverages(TreeNode root) {
	    List<Double> result = new ArrayList<>();
	    findLevelAverages(root, result);
	    return result;
	  }
	
	public static void findLevelAverages(TreeNode root, List<Double> result) {
		if(root == null) {
			return;
		}
		
		int levelSize = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			levelSize = queue.size();
			Double sum = 0d;
			
			for(int i = 0; i < levelSize; i++) {
			
				TreeNode node = queue.poll();
				if(node == null) {
					return;
				}
				
				sum += node.val;
				System.out.println("sum = " + sum);
				
				if(root.left != null)
					queue.add(node.left);
				if(root.right != null)
					queue.add(node.right);
				
			}
			result.add(sum/levelSize);
		}
	}

	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.left.right = new TreeNode(2);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    List<Double> result = LevelAverages.findLevelAverages(root);
	    System.out.print("Level averages are: " + result);
	  }

}
