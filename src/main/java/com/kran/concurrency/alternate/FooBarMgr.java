package com.kran.concurrency.alternate;

public class FooBarMgr extends Thread {

	private FooBar fooBar;
	private TYPE type;
	
	public FooBarMgr(FooBar fooBar, TYPE type) {
		this.fooBar = fooBar;
		this.type = type;
	}
	
	@Override
	public void run() {
		switch(type) {
		case foo:
			fooBar.foo();
			break;
		case bar:
			fooBar.bar();
			break;
		}
	}
	
	public enum TYPE{
		foo, bar
	}
	
	public static void main(String[] args) {
		
		FooBar fooBar = new FooBar(10);
		FooBarMgr t1 = new FooBarMgr(fooBar, TYPE.foo);
		FooBarMgr t2 = new FooBarMgr(fooBar, TYPE.bar);
		
		t2.start();
		t1.start();
	}

}
