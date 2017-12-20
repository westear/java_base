package listDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ListMap {

	public List<Map<String,Object>> initList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=1; i<=4; i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("tag"+i, "val"+i);
			map.put("title"+i, "value"+i);
			list.add(map);
		}
		return list;
	}
	
	public Map<String,Object> getMap(){
		Map<String,Object> outMap = new HashMap<String,Object>();
		outMap.put("list", initList());
		outMap.put("prop1", "p1");
		outMap.put("prop2", "p2");
		outMap.put("prop3", "p3");
		return outMap;
	}
	
	@SuppressWarnings("unchecked")
	public void printMap(Map<String,Object> map){
		Set<Entry<String, Object>> entrySet = map.entrySet();
		Iterator<Entry<String, Object>> iter = entrySet.iterator();
		while(iter.hasNext()){
			Entry<String,Object> entry = iter.next();
			if(entry.getValue() instanceof List){
				List<Map<String,Object>> list = (List<Map<String, Object>>) entry.getValue();
				if(list != null && list.size() > 0){
					for(Map<String,Object> m : list){
						Set<Entry<String, Object>> entrySetIn = m.entrySet();
						Iterator<Entry<String, Object>> iterIn = entrySetIn.iterator();
						while(iterIn.hasNext()){
							Entry<String,Object> entryIn = iterIn.next();
							System.out.println("key: "+entryIn.getKey()+"--- value:"+(m.get(entryIn.getKey()) == null ? "" : m.get(entryIn.getKey())));
						}
					}
				}else{
					System.out.println("key: "+ entry.getKey() + "--- value:");
				}
			}else{
				System.out.println("key: "+ entry.getKey() + "--- value:"+(map.get(entry.getKey()) == null ? "" : map.get(entry.getKey())));
			}
		}
	}
	
	public static void main(String[] args){
		ListMap listMap = new ListMap();
		listMap.printMap(listMap.getMap());
	}
}
