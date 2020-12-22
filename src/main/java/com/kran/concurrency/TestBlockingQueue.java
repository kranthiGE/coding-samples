package com.kran.concurrency;

public class TestBlockingQueue {

	public void runTest() throws InterruptedException {
		
		BlockingQueue<Integer> bqueue = new BlockingQueue<>(10);
		
		Runnable producer = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 50; i++) {
					try {
						bqueue.enqueue(i);
						System.out.println("item enqueued " + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		
		Runnable consumer1 = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 25; i++) {
					try {
						System.out.println("item dequeued: "+ bqueue.dequeue());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		
		Runnable consumer2 = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 25; i++) {
					try {
						System.out.println("item dequeued: "+ bqueue.dequeue());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		
		Thread thread1 = new Thread(producer);
		Thread thread2 = new Thread(consumer1);
		Thread thread3 = new Thread(consumer2);
		
		thread1.start();
		
		thread2.start();
		thread2.join();
		
		thread3.start();
		System.out.println("going to join t1");
		thread1.join();
		thread3.join();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestBlockingQueue test = new TestBlockingQueue();
		test.runTest();
	}
}
