package ex0811.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExam01{
	List<Integer> list = new LinkedList<>();
	
	public ListExam01() {
		list.add(10);
		list.add(5);
		list.add(8);
		list.add(25);
		list.add(35);
		list.add(267);
		list.add(5);
		
		System.out.println(list.size());
	}
	
	public static void main(String[] args) {
		ListExam01 le = new ListExam01();
		System.out.println(le.list);
		for(int result : le.list) {
			System.out.print(result + " ");
		}
		System.out.println();
		for(int i=0;i<le.list.size();i++) {
			System.out.print(le.list.get(i) + " ");
		}
		System.out.println();
		Integer remove = le.list.remove(5);
		System.out.println(remove);
		for(int i=0;i<le.list.size();i++) {
			System.out.print(le.list.get(i) + " ");
		}
		System.out.println();
		Integer set = le.list.set(3, 225535);
		System.out.println(set);
		for(int i=0;i<le.list.size();i++) {
			System.out.print(le.list.get(i) + " ");
		}
		System.out.println();
		
		le.list.set(2, null);
		le.list.set(5, null);
		for(int i=0;i<le.list.size();i++) {
			System.out.print(le.list.get(i) + " ");
		}
		System.out.println();
		Integer intNull = le.list.get(2);
		boolean remove2 = le.list.remove(intNull);
		System.out.println(le.list);
		boolean remove3 = le.list.remove(intNull);
		
		System.out.println(intNull);
		System.out.println(remove2);
		System.out.println(remove3);
		for(int i=0;i<le.list.size();i++) {
			System.out.print(le.list.get(i) + " ");
		}
		System.out.println();
		System.out.println(le.list);
		
		System.out.println(le.list);
	}

}
