package com.kran.btree;

public class MyStack<T> {
	
	private int top;
	private T[] arr;
	private int maxSize;
	
	@SuppressWarnings("unchecked")
	public MyStack(int maxSize) {
		this.maxSize = maxSize;
		arr = (T[]) (new Object[maxSize]);
		top = -1;
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return null;
		}
		return arr[top--];
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return null;
		}
		return arr[top];
	}
	
	public void push(T data) {
		// check if full
		if(isFull()) {
			System.out.println("stack is full");
			return;
		}
		arr[++top] = data;
	}
	
	public int size() {
		return maxSize;
	}
	
	private boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}
	
	public static void main(String[] args) {
		MyStack<Integer> mstack = new MyStack<>(10);
		mstack.push(1);
		mstack.push(2);
		mstack.push(4);
		mstack.push(6);
		mstack.push(11);
		mstack.push(3);
		mstack.push(12);
		mstack.push(10);
		mstack.push(5);
		mstack.push(9);
		mstack.push(7);
		mstack.push(8);
		
		while(!mstack.isEmpty()) {
			System.out.println(mstack.pop());
		}
	}
	

}
