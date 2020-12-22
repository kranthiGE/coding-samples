package com.kran.btree;

public class InorderIterator {
	MyStack<BinaryTreeNode> mstack;
	
	
	public InorderIterator(BinaryTreeNode root) {
		mstack = new MyStack<>(15);
		// traverse through the left of the tree and push them to stack
		prepareStack(root);
	}
	
	private void prepareStack(BinaryTreeNode root) {
		mstack.push(root);
		if(root.left != null)
			prepareStack(root.left);
	}
	
	public boolean hasNext() {
	   return !mstack.isEmpty();
	}
	
	public BinaryTreeNode getNext() {  
		if(mstack.isEmpty()) {
			return null;
		}
		
		BinaryTreeNode top = mstack.pop();
		if(top.right != null) {
			prepareStack(top.right);
		}
		return top;
	}

	//Don't Change anything down below
	public String inorderUsingIterator(BinaryTreeNode root) {
	  InorderIterator iter = new InorderIterator(root);
	  String result = "";
	  while (iter.hasNext()) {
	    result += iter.getNext().data + " ";
	  }
	  return result;
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
