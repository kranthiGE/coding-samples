package com.kran.concurrency.ordered;

public class OrderedPrinting {

	// the problem is to solve ordered printing t1, t2 and then t3 in the same order
	
	private volatile int count = 1;
	
	public void printFirst() {
		synchronized (this) {
			System.out.println("first");
			count++;
			this.notifyAll();
		}
		System.out.println("count = " + count);
	}
	
	public void printSecond() throws InterruptedException {
		
		synchronized (this) {
			while(count != 2) {
				System.out.println("2nd count = " + count);
				this.wait();
			}
			System.out.println("second");
			count++;
			this.notifyAll();
		}
	}
	
	public void printThird() throws InterruptedException {
		System.out.println("3rd count = " + count);
		synchronized (this) {
			while(count != 3) {
				this.wait();
			}
			System.out.println("third");
			count = 1;
			this.notifyAll();
		}
	}
}
