package com.kran.concurrency;

public class MyThread {
	
	public static void main(String[] args) {
		System.out.println("in main thread");
		
		
		Runnable runnable = () -> {
			System.out.println("running " + Thread.currentThread().getName());
		};
		
		Thread thread = new Thread(runnable);
		thread.setName("child thread");
		
		thread.start();
		
		
	}

}
