package com.kran.processdata;

public class MyStack<T> {
	// stack inserts elements to the top.
	// implement stack using linked list where elements will be inserted and removed from one side
	private StackNode<T> top;

	// push adds elements to the top 
	public void push(T data) throws Exception {
		if (data == null) {
			throw new Exception("data input is null");
		}
		StackNode<T> newNode = new StackNode<T>(data);
		if(top != null)
			newNode.setNext(top);
		top = newNode;
	}
	
	public StackNode<T> pop() {
		StackNode<T> item = top;
		top = top.getNext();
		return item;
	}
	
	public StackNode<T> peek() {
		return top;
	}
	
	public boolean isEmpty() {
		return (top == null);
	}

	public static void main(String[] args) throws Exception {
		MyStack<Integer> stack = new MyStack<Integer>();
		
		stack.push(12);
		stack.push(4);
		stack.push(8);
		stack.push(1);
		stack.push(7);
		stack.push(9);
		
		System.out.println("elements added to stack");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().getData()); 
		}
		
	}
	
	

}
