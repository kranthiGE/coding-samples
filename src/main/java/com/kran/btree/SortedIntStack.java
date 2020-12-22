package com.kran.btree;

public class SortedIntStack<T> {
	MyStack<Integer> mstack;
	
	public SortedIntStack(int maxSize) {
		mstack = new MyStack<>(maxSize);
	}
	
	public MyStack<Integer> sortStack(){
		MyStack<Integer> rStk = new MyStack<>(mstack.size());
		
		while(!mstack.isEmpty()) {
			int temp = mstack.pop();
			while(!rStk.isEmpty() && temp < rStk.peek()) {
				mstack.push(rStk.pop());
			}
			rStk.push(temp);
		}
		
		while(!rStk.isEmpty()) {
			mstack.push(rStk.pop());
		}
		
		return mstack;
	}
	
	public Integer pop() {
		return mstack.pop();
	}
	
	public void push(Integer data) {
		mstack.push(data);
	}
	
	public boolean isEmpty() {
		return mstack.isEmpty();
	}
	
	public Integer peek() {
		return mstack.peek();
	}

	public static void main(String[] args) {
		SortedIntStack sorted = new SortedIntStack(10);
		sorted.push(1);
		sorted.push(2);
		sorted.push(4);
		sorted.push(6);
		sorted.push(11);
		sorted.push(3);
		sorted.push(12);
		sorted.push(10);
		sorted.push(5);
		sorted.push(9);
		sorted.push(7);
		sorted.push(8);
		
		while(!sorted.isEmpty()) {
			System.out.println(sorted.pop());
		}
		
		sorted.push(1);
		sorted.push(2);
		sorted.push(4);
		sorted.push(6);
		sorted.push(11);
		sorted.push(3);
		sorted.push(12);
		sorted.push(10);
		sorted.push(5);
		sorted.push(9);
		sorted.push(7);
		sorted.push(8);
		
		sorted.sortStack();
		
		System.out.println("after sorting...");
		
		// after sorting
		while(!sorted.isEmpty()) {
			System.out.println(sorted.pop());
		}
	}

}
