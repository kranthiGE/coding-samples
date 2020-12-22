package com.kran.bfs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class CheckPath {

  public static String tracePath(Map<String,String> map) {

    String result = "";
    HashMap<String, String> rmap = new HashMap();

    // Write - Your - Code   
    // build a reverse map and save as rMap<V,K> from original map
    Iterator<Entry<String, String>> it = map.entrySet().iterator();  
    while(it.hasNext()){
        Entry<String, String> en = it.next();
        rmap.put(en.getValue(), en.getKey());
    }   

    String from = "";
    // loop through rmap to find the starting city
    Iterator<Entry<String, String>> itr = map.entrySet().iterator();  
    while(itr.hasNext()){
        Entry<String, String> en = itr.next();// for ex: chicago is the key
        if(rmap.get(en.getKey()) == null){
        		from = en.getKey();
        }
    }   
    System.out.println(from);
    
    result = search(map, from);
        
    return result; 
  }

  public static String search(Map<String,String> map, String from){
      String value = map.get(from);
      if(value != null)
        return from + "->" + value + " , " + search(map, value);
      else
        return "";
  }
  
  public static void main(String[] args) {
	    HashMap<String,String> hMap = new HashMap<>();  

	    hMap.put("NewYork","Chicago");
	    hMap.put("Boston","Texas");
	    hMap.put("Missouri","NewYork");
	    hMap.put("Texas","Missouri");

	    String actual_output = CheckPath.tracePath(hMap);

	    System.out.println(actual_output);
  }
  
  
}