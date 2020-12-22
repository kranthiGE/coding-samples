package com.kran.processdata;

public class MyStackForMin extends MyStack<Integer> {
	
	private MyStack<Integer> minStack;
	
	public MyStackForMin() {
		minStack = new MyStack<Integer>();
	}
	
	public void push(int item) throws Exception {
		if(item <= min()) {
			minStack.push(item);
		} else if(item <= next().getData()) {
			minStack.peek().setData(item);
			minStack.peek().setNext(minStack.peek());
		}
		super.push(item);
	}
	
	public StackNode<Integer> pop() {
		StackNode<Integer> value = super.pop();
		if(value.getData() == minStack.peek().getData()) {
			minStack.pop();
		}
		return value;
	}
	
	private StackNode<Integer> next() {
		return minStack.peek().getNext();
	}
	
	private Integer min() {
		if(minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return minStack.peek().getData();
	}
	
	public static void main(String[] args) throws Exception {
		MyStackForMin stack = new MyStackForMin();
		
		stack.push(12);
		stack.push(4);// peek = 12, min() = 12, item = 4, 4 <= 12 then push -> min() = 4
		stack.push(8);// peek = 4, min() = 4, item = 8, 8 <= 4 then min() = 4
		stack.push(1);
		stack.push(7);
		stack.push(9);
		
		System.out.println("elements added to min stack");
		
		System.out.println("min value = " + stack.min());
		
		MyStack<Integer> minStackToPrint = stack.minStack;
		
		while(!minStackToPrint.isEmpty()) {
			System.out.println(minStackToPrint.pop().getData()); 
		}
//		
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop().getData()); 
//		}
		
		
		
	}

}
