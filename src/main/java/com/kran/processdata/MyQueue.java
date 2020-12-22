package com.kran.processdata;

public class MyQueue {
	// a queue implementation for integers
	private StackNode<Integer> first;
	private StackNode<Integer> last;
	
	public MyQueue() {
		
	}
	
	public void enqueue(Integer item) {
		if(item == null)
			throw new NullPointerException("no item value provided");
		StackNode<Integer> data = new StackNode<Integer>(item);
		
		if(isEmpty()) // when queue is empty then insert first item
			first = data;
		
		if(last != null)
			last.setNext(data);
		
		last = data;
	}
	
	public StackNode<Integer> dequeue(){
		StackNode<Integer> data = first;
		
		first = first.getNext();
		return data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(4);
		queue.enqueue(3);
		queue.enqueue(1);

		while(!queue.isEmpty()) {
			System.out.println(queue.dequeue().getData());
		}
		
	}

}
