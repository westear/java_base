package listDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {

	public static void main(String[] args){
		List<Integer> initList = new ArrayList<Integer>();
		Collections.addAll(initList, 1, 2, 3, 4, 5, 6);
		for(int i = 0; i < initList.size(); i++){
			Integer value = initList.get(i);
			if(value == 3 || value == 5){
				initList.remove(i);
			}
		}
		System.out.println(initList);
	}
}
