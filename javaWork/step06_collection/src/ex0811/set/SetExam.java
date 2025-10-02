package ex0811.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
	Set<String> set = new HashSet<>();
	//Set<String> set = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
	public SetExam() {
		
	}
	public SetExam(String[] args) {
		for(String str : args) {
			boolean b = set.add(str);
			System.out.println(str + "추가결과 : " + b);
		}
		System.out.println("추가된 개수 : " + set.size());
		System.out.println("set = " + set);
		
		System.out.println("****저장된 요소를 하나씩 추출하기 ****");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String string = it.next();
			System.out.println(string);
		}
		
		System.out.println("****요소 제거****");
		boolean remove = set.remove("10");
		System.out.println("제거결과 : " + remove);
		System.out.println(set);
		System.out.println("***존재 여부 체크***");
		boolean contains = set.contains("50");
		System.out.println("존재체크 결과 : " + contains);
	}
	public static void main(String[] args) {
		new SetExam(args);

	}

}
