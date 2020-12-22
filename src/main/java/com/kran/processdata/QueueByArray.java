package com.kran.processdata;

public class QueueByArray<T> {
	
	private T[] arr;
	private int first;
	private int back;
	private int max_size;
	private int current_size;
	
	@SuppressWarnings("unchecked")
	public QueueByArray(int max_size) {
		this.max_size = max_size;
		arr = (T[]) (new Object[max_size]);
		first = 0;
		back = -1;
		current_size = 0;
	}
	
	public T top() {
		return arr[first];
	}
	
	public boolean isEmpty() {
		return current_size == 0;
	}
	
	public boolean isFull() {
		return current_size == max_size;
	}
	
	public int getMaxSize() {
		return max_size;
	}
	
	public void enqueue(T data) {
		if(isFull()) {
			System.out.println("arr is full");
			return;
		}
		else {
			back = (back + 1) % max_size;
			arr[back] = data;
			current_size++;
		}
	}
	
	public T dequeue() {
		if (isEmpty()) {
			System.out.println("arr is empty");
			return null;
		}
		T t = arr[first];
		first = (first + 1) % max_size;
		current_size--;
		return t;
	}

	public static void main(String[] args) {
		
		QueueByArray<Integer> queue = new QueueByArray<>(10);
		 queue.enqueue(1);
		 queue.enqueue(2);
		 queue.enqueue(3);
		 queue.enqueue(4);
		 queue.enqueue(5);
		 queue.enqueue(6);
		 queue.enqueue(7);
		 System.out.println(queue.dequeue());

		 queue.enqueue(8);
		 queue.enqueue(9);
		 queue.enqueue(10);
		 queue.enqueue(11);
		 System.out.println("added 11");
		 for (int i = 0; i< 11; i++) {
			 System.out.println(queue.dequeue());
		}
		
	}
}
