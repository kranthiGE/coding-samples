package com.kran.concurrency.ordered;

public class OrderThreadMgr extends Thread {
	
	private OrderedPrinting order;
	private String method;
	
	public OrderThreadMgr(OrderedPrinting order, String method) {
		this.order = order;
		this.method = method;
	}

	@Override
	public void run() {
		if(method.equals("first"))
			order.printFirst();
		if(method.equals("second"))
			try {
				order.printSecond();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(method.equals("third"))
			try {
				order.printThird();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		
		OrderedPrinting printer = new OrderedPrinting();
		
		OrderThreadMgr t1 = new OrderThreadMgr(printer, "first");
		OrderThreadMgr t2 = new OrderThreadMgr(printer, "second");
		OrderThreadMgr t3 = new OrderThreadMgr(printer, "third");
		
		t2.start();
		t1.start();
		t3.start();
		
		System.out.println("******* using semaphore *******");
		
		OrderedPrintingSemaphore printerSem = OrderedPrintingSemaphore.makePrintingInOrder();
		
		for(int i = 0; i <= 10; i++) {
			OrderThreadMgr t4 = new OrderThreadMgr(printerSem, "first");
			OrderThreadMgr t5 = new OrderThreadMgr(printerSem, "second");
			OrderThreadMgr t6 = new OrderThreadMgr(printerSem, "third");
			
			t5.start();
			t4.start();
			t6.start();
		}
	}
}
