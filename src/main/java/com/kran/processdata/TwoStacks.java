package com.kran.processdata;

class TwoStacks<V> {
    private int maxSize;
    private V[] array;
    private int top1;
    private int top2;
    private int currentCount;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
        top1 = 0;
        top2 = max_size - 1;
        currentCount = 0;
    }

    //insert at top of first stack
    public void push1(V value) {
        if(isFull()){
            System.out.println("stack is full" + currentCount);
            return;
        }

        // insert at starting index
        array[top1] = value;
        System.out.println("added " + value + " to " + top1);
        top1++;
        currentCount++;
    }

    //insert at top of second stack
    public void push2(V value) {
        if(isFull()){
            System.out.println("stack is full" + currentCount);
            return;
        }

        // insert at mid index
        array[top2] = value;
        System.out.println("added " + value + " to " + top2);
        top2--;
        currentCount++;
    }

    //remove and return value from top of first stack
    public V pop1() {
    		if(isEmpty()) {
			return null;
		}
    		if(top1 <= 0) {
    			System.out.println("no elements in stack1");
    			return null;
    		}
        System.out.println("removed " + array[top1-1] + " from " + (top1-1));
        currentCount--;
        return array[top1--];
    }

    //remove and return value from top of second stack
    public V pop2() {
    		if(isEmpty()) {
    			return null;
    		}
    		if(top2 >= maxSize - 1) {
    			System.out.println("no elements in stack2");
    			return null;
    		}
        System.out.println("removed " + array[top2+1]);
        currentCount--;
        return array[top2++];
    }
    
    private boolean isEmpty() {
    		return array.length == 0;
    }

    private boolean isFull(){
        return currentCount == maxSize - 1;
    }

	public static void main(String[] args) {
		TwoStacks<Integer> twoStacks = new TwoStacks<>(10);
		twoStacks.push1(6);
		twoStacks.push2(4);
		twoStacks.push1(3);
		twoStacks.push1(3);
		twoStacks.push2(5);
		twoStacks.push2(10);
		twoStacks.push2(10);
		twoStacks.push2(11);
		twoStacks.pop1();
		twoStacks.pop2();
		twoStacks.push2(12);
		twoStacks.pop1();
		twoStacks.push2(13);
		twoStacks.push2(14);
		twoStacks.push2(15);
		twoStacks.push2(16);
		twoStacks.pop1();
		twoStacks.pop1();

		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.pop2();
		twoStacks.push1(6);
		twoStacks.push2(4);
		twoStacks.push1(3);
		twoStacks.push1(3);
		twoStacks.push2(5);
		twoStacks.push2(10);
		twoStacks.push2(10);
		twoStacks.push2(11);
		twoStacks.pop1();
		twoStacks.pop2();
		twoStacks.push2(12);
		twoStacks.pop1();
		twoStacks.push2(13);
		twoStacks.push2(14);
		twoStacks.push2(15);
		twoStacks.pop2();

		twoStacks.push1(16);
		
		
		
		
	}

}
