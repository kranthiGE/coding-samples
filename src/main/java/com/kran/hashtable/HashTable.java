package com.kran.hashtable;

public interface HashTable<K, V> {
	
	void put(K k, V v);
	
	V get(K k);
}
