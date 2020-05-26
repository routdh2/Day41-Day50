package may_26;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class SortAMap {
	private static String input;
	private static Map<Character,Integer> map;
	
	SortAMap(String _input) {
		input=_input;
		map=new HashMap<>();
	}
	
	private static void storeCharCount() {
		if(input!=null) {
			for(int i=0;i<input.length();i++) {
				char key=input.charAt(i);
				map.put(key,map.getOrDefault(key, 0)+1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		String input=new String("This is a test string. My name is Dhananjay Rout");
		SortAMap ob = new SortAMap(input);
		ob.storeCharCount();
		
		//Now we have a hashmap. how to sort it based on key
		//There are two approaches
		//1. Use treemap which sorts the keys automatically or by using a comparator provided at creation time
		//2. Use Java 8 streams
//		ob.sortByKeyUsingTreemap();
//		ob.sortByKeyUsingStream();
		//Now we have to sort it based on value
		//There are two approaches
		//1. use linkedhashmap
		//2. Use Java 8 streams
		ob.sortByValueUsingLinkedHashMap();
		ob.sortByValueUsingStream();
		

	}
	
	private static void sortByValueUsingLinkedHashMap() {
		if(map!=null) {
			//first convert the map into list
			List<Map.Entry<Character,Integer>> list = new LinkedList<>(map.entrySet());
			Collections.sort(list,(e1,e2)->{
				if(e1.getValue()==e2.getValue()) {
					return e1.getKey()-e2.getKey();
				}
				else
					return e1.getValue()-e2.getValue();
			});
			//iterate the list and put it into linkedhashmap
			LinkedHashMap<Character,Integer> linkedmap=new LinkedHashMap<>();
			ListIterator itr = list.listIterator();
			while(itr.hasNext()) {
				Map.Entry<Character,Integer> entry = (Map.Entry<Character, Integer>)itr.next();
				linkedmap.put(entry.getKey(),entry.getValue());
			}
			traverseMap(linkedmap);
		}
	}
	
	private static void sortByValueUsingStream() {
		if(map!=null) {
			LinkedHashMap<Character,Integer> linkedmap = map.entrySet().stream().sorted((e1,e2)->{
				if(e1.getValue()==e2.getValue())
					return e1.getKey()-e2.getKey();
				else
					return e1.getValue()-e2.getValue();
			}).collect(Collectors.toMap(entry->entry.getKey(), entry->entry.getValue(),(oldValue,newValue)->oldValue,LinkedHashMap::new));
			traverseMap(linkedmap);
		}
	}
	
	private static void sortByKeyUsingStream() {
		if(map!=null) {
			map.entrySet().stream().sorted((e1,e2)->e1.getKey()-e2.getKey()).forEach((entry)->System.out.println(entry.getKey()+" : "+entry.getValue()));
		}
	}
	
	private static void sortByKeyUsingTreemap() {
		if(map!=null) {
			TreeMap<Character,Integer> treemap = new TreeMap<>(map);
			traverseMap(treemap);
		}
	}
	
	private static void traverseMap(Map<Character,Integer> map) {
		if(map!=null) {
			for(Map.Entry<Character,Integer> entry:map.entrySet()) {
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}
		}
	}

}
