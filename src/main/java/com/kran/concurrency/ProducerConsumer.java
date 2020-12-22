package com.kran.concurrency;

public class ProducerConsumer {
	
	private static Object lock = new Object();
	
	private static int[] buffer;
	private static int counter;
	
	static class Producer{
		
		public void produce() throws InterruptedException {
			synchronized (lock) {
				if (isFull(buffer)) {
					lock.wait();
				}
				buffer[counter++] = 1;
				lock.notifyAll();
			}
			
		}
	}
	
	static boolean isFull(int[] buffer) {
		return counter == buffer.length;
	}
	
	static boolean isEmpty(int[] buffer) {
		return counter == 0;
	}
	
	static class Consumer{
		
		public void consume() throws InterruptedException {
			synchronized (lock) {
				if(isEmpty(buffer)) {
					lock.wait();
				}
				buffer[--counter] = 0;
				lock.notifyAll();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		buffer = new int[10];
		counter = 0;
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable produceTask = () -> {
			for(int i = 0; i < 100; i++) {
				try {
					producer.produce();
					System.out.println("inside P = " + counter);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("done P");
		};
		
		Runnable consumerTask = () -> {
			for(int i = 0; i < 80; i++) {
				try {
					consumer.consume();
					System.out.println("inside C = " + counter);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("done C");
		};
		
		Thread threadP = new Thread(produceTask);
		threadP.setName("Producer");
		
		Thread threadC = new Thread(consumerTask);
		threadC.setName("Consumer");
		
		threadC.start();
		threadP.start();
		
		threadC.join();
		threadP.join();
		
		System.out.println("counter = " + counter);
	}

}
