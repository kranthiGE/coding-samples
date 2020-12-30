package com.kran.concurrency.alternate;

public class FooBar {
	
	private boolean isFoo = true;
	private int n;
	
	public FooBar(int n) {
		this.n = n;
	}
	
	public void foo() {
		for(int i = 0; i <= n; i ++) {
			synchronized (this) {
				while(!isFoo) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("foo");
				isFoo = false;
				this.notifyAll();
			}
		}
		
	}
	
	public void bar() {
		System.out.println("entering bar...");
		for(int i = 0; i <= n; i ++) {
			synchronized (this) {
				while(isFoo) {// wait for bar turn
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("bar");
				isFoo = true;
				this.notifyAll();
			}
		}
	}
}
