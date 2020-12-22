package com.kran.hashtable;

import java.util.ArrayList;

public class MyHashTable<K, V> implements HashTable<K, V>{
	
	static private class LinkedListNode<K, V> {
		
		public LinkedListNode<K, V> next;
		public LinkedListNode<K, V> previous;
		public K key;
		public V value;
		
		public LinkedListNode(K k, V v) {
			key = k;
			value = v;
		}
		
	}
	
	
	private ArrayList<LinkedListNode<K, V>> array;
	
	public MyHashTable(int minCapacity) {
		array = new ArrayList<>();
		array.ensureCapacity(minCapacity);
		for(int i = 0; i < minCapacity; i++) {
			array.add(i, null);
		}
	}
	
	@Override
	public void put(K k, V v) {
		// first check if the key already exists then update the value
		LinkedListNode<K, V> current = getNodeByKey(k);
		if(current != null) {
			// key is already present
			// update the value
			current.value = v;
			return;
		}
		// else create a new node and add based on the key hash/index
		LinkedListNode<K, V>  newNode = new LinkedListNode<K, V>(k, v);
		int newIndex = getIndexForKey(k);
		if(array.get(newIndex) != null) {
			newNode.next = array.get(newIndex);
			newNode.next.previous = newNode;
		}
		// there exist no element in the array at newIndex then simply add 
		array.set(newIndex, newNode);

		return;
	}
	
	public LinkedListNode<K, V> getNodeByKey(K k){
		// first generate the hash on key
		int index = getIndexForKey(k);
		LinkedListNode<K, V> existing = array.get(index);
		while(existing != null) {
			if(existing.key == k) {
				return existing;
			}
			existing = existing.next;
		}
		return null;
	}
	
	private int getIndexForKey(K k) {
		return Math.abs(k.hashCode() % array.size());
	}

	@Override
	public V get(K k) {
		LinkedListNode<K, V> current = getNodeByKey(k);
		if(current != null)
			return current.value;
		return null;
	}

	
}
