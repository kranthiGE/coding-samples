package com.kran.concurrency.ordered;

import java.util.concurrent.Semaphore;

public class OrderedPrintingSemaphore extends OrderedPrinting {

	private static OrderedPrintingSemaphore printObj = null;
	private static Semaphore firstSem = null;
	private static Semaphore secondSem = null;
	private static Semaphore thirdSem = null;
	
	private OrderedPrintingSemaphore() {
		
	}
	
	public synchronized static OrderedPrintingSemaphore makePrintingInOrder() {
		if(printObj == null) {
			printObj = new OrderedPrintingSemaphore();
		}
		firstSem = new Semaphore(1);
		secondSem = new Semaphore(0);
		thirdSem = new Semaphore(0);
		return printObj; 
	}
	
	@Override
	public void printFirst() {
		try {
			firstSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("first");
		secondSem.release();
	}
	
	@Override
	public void printSecond() {
		try {
			secondSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("second");
		thirdSem.release();
	}
	
	@Override
	public void printThird() {
		try {
			thirdSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("third");
		firstSem.release();

	}
}
