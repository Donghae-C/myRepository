package ex0811.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExam2 extends ArrayList<Integer>{
	
	
	public ListExam2() {
		add(10);
		add(5);
		add(8);
		add(25);
		add(35);
		add(267);
		add(5);
		
		System.out.println(size());
	}
	
	public static void main(String[] args) {
		ListExam2 lde = new ListExam2();
		System.out.println(lde);
		for(int result : lde) {
			System.out.print(result + " ");
		}
		System.out.println();
		for(int i=0;i<lde.size();i++) {
			System.out.print(lde.get(i) + " ");
		}
		System.out.println();
		Integer remove = lde.remove(5);
		System.out.println(remove);
		for(int i=0;i<lde.size();i++) {
			System.out.print(lde.get(i) + " ");
		}
		System.out.println();
		Integer set = lde.set(3, 225535);
		System.out.println(set);
		for(int i=0;i<lde.size();i++) {
			System.out.print(lde.get(i) + " ");
		}
		System.out.println();
		
		lde.set(2, null);
		lde.set(5, null);
		for(int i=0;i<lde.size();i++) {
			System.out.print(lde.get(i) + " ");
		}
		System.out.println();
		Integer intNull = lde.get(2);
		boolean remove2 = lde.remove(intNull);
		System.out.println(lde);
		boolean remove3 = lde.remove(intNull);
		
		System.out.println(intNull);
		System.out.println(remove2);
		System.out.println(remove3);
		for(int i=0;i<lde.size();i++) {
			System.out.print(lde.get(i) + " ");
		}
		System.out.println();
		System.out.println(lde);
		
		System.out.println(lde);
	}

}
