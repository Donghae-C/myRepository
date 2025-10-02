package ex0813.map;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapExam {
	Map<Integer, String> map = new TreeMap<>();
	
	public MapExam() {
		map.put(30, "test1");
		map.put(20, "test2");
		map.put(33, "test3");
		map.put(34, "test4");
		map.put(20, "test5");
		map.put(35, "test6");
		
		System.out.println("저장된 개수 = " + map.size());
		System.out.println("map = " + map);
		
		for(Entry<Integer, String> m : map.entrySet()) {
			System.out.print(m.getValue() + " ");
		}
		System.out.println();
		String re = map.put(50, "test7");
		System.out.println(re);
		
		re = map.put(33, "test8");
		System.out.println(re);
		
		System.out.println("-----------key, value 분리------------");
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int key = it.next();
			String value = map.get(key);
			System.out.println("key = " + key + " value = " + value);
		}
		System.out.println("------------for each--------------");
		for(Integer key : map.keySet()) {
			String value = map.get(key);
			System.out.println("key = " + key + " value = " + value);
		}
		
		System.out.println("-------Map.Entry<K,V> 사용하기---------");
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<Integer, String> e = iterator.next();
			Integer key = e.getKey();
			String value = e.getValue();
			System.out.println("key = " + key + " value = " + value);
		}
		System.out.println("-------Map.Entry<K,V> + for each 사용하기---------");
		for(Entry<Integer, String> e : entrySet) {
			Integer key = e.getKey();
			String value = e.getValue();
			System.out.println("key = " + key + " value = " + value);
		}
		
		String remove = map.remove(50);
		System.out.println("삭제된 value = " + remove);
		System.out.println(map);
		
	}
	
	public static void main(String[] args) {
		new MapExam();

	}

}
