package com.kran.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
	
	private T[] array;
	private int size = 0;
	private int capacity;
	private int head = 0;
	private int tail = 0;
	
	private Lock lock = new ReentrantLock();
	
	// initialize an array with a fixed length provided during instantiation
	// add enqueue, dequeue methods
	// implement isFull(), isEmpty() based on counter
	
	
	public BlockingQueue(int length) {
		array = (T[]) (new Object[length]);
		capacity = length;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void enqueue(T item) throws InterruptedException {
		synchronized (lock) {
			if(isFull()) {
				System.out.println("waiting items to be consumed");
				lock.wait();// block the caller
			}
			
			if(tail == capacity) {
				tail = 0;
			}
			
			// add the item
			array[tail] = item;
			
			size++;
			tail++;
			
			System.out.println("item added " + item);
			
			lock.notifyAll();
		}
	}
	
	public T dequeue() throws InterruptedException {
		T item = null;
		synchronized (lock) {
			if(isEmpty()) {
				System.out.println("waiting items to be produced");
				lock.wait();
			}
			
			if(head == capacity) {
				head = 0;
			}
			
			item = array[head];
			head++;
			size--;
			
			System.out.println("item removed " + item);

			lock.notifyAll();
		}
		
		return item;
	}
}
