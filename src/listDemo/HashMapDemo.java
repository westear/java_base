package listDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

	Map<Integer,Object> map = new HashMap<Integer,Object>();
	
	public void putItems(){
		for(int i=0; i<17; i++){	//初始bucket长度=16
			if(i == 0){
				map.put(null, null);	//HashMap可以接受键，值为null
			}else{
				map.put(new Integer(i), "object");
			}
		}
	}
	
	public Map<Integer,Object> getMap(){
		return this.map;
	}
	
	public void printMap(Map<String, Object> map){
		System.out.println(map);
	}
	
	public static void main(String[] args){
		
		HashMapDemo hashMapDemo = new HashMapDemo();
		hashMapDemo.putItems();
		Map<Integer, Object> map=hashMapDemo.getMap();
		//HashMap的每个bucket存Entry<键,值>;
		//键的hashCode值相同时,bucket里以链表形式存储多个key的hashCode相等的Entry对象
		Set<Entry<Integer, Object>> m = map.entrySet();
		Iterator<Entry<Integer, Object>> iter = m.iterator();
		while(iter.hasNext()){
			Entry<Integer,Object> entry = iter.next();
			Integer key = entry.getKey();
			Object obj = entry.getValue();
			System.out.println("key: "+key+"--- value: "+obj);
		}
	}
}
