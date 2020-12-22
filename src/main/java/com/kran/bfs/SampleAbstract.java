package com.kran.bfs;

public class SampleAbstract {
	
	public abstract class bfs{
		
		double maxNodes;
		
		public bfs(double in) {
			maxNodes = in;
		}
		
		public void search() {
			System.out.println("searching through ..." + maxNodes);
		}
	}
	
	public class bfsImpl extends bfs {

		public bfsImpl(double in) {
			super(in);
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		SampleAbstract sam = new SampleAbstract();
		SampleAbstract.bfsImpl impl = sam.new bfsImpl(10);
		impl.search();
	}

}
