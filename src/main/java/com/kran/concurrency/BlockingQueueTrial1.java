package com.kran.concurrency;

public class BlockingQueueTrial1<T> {
	
	private T[] arr;
	private int head = 0;
	private int tail = 0;
	private int size = 0;
	private int capacity;
	private Object lock = new Object();
	
	@SuppressWarnings("unchecked")
	public BlockingQueueTrial1(int capacity) {
		arr = (T[])new Object[capacity];
		this.capacity = capacity;
		size = this.capacity;
	}
	
	public void enqueue(T item) throws InterruptedException {
		// add into queue
		// need to block adding if arr reaches capacity
		synchronized (lock) {
			while(isFull()) {
				wait();
			}
			
			arr[tail] = item;
			tail++;
			size++;
			
			notifyAll();
		}
	}
	
	private boolean isFull() {
		return arr.length == size;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	public T dequeue() throws InterruptedException {
		
		T item = null;
		
		synchronized (lock) {
			if(isEmpty()) {
				wait();
			}
			
			if(head == size) {
				head = 0;
			}
			// queue is FIFO, so return the head element
			item = arr[head];
			arr[head] = null;
			head++;
			size--;
		}
		
		return item; 
	}

}
