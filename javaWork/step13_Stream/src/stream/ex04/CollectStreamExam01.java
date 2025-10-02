package stream.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectStreamExam01 {

	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>(); 
		totalList.add(new Student("장희정", "남", 92)); 
		totalList.add(new Student("하승현", "여", 87)); 
		totalList.add(new Student("오문정", "남", 95)); 
		totalList.add(new Student("김은영", "여", 93));
		
		//문제) 학생들중 남학생만 뽑아 새로운 List로 만들자
		
		System.out.println("1.학생들중 남학생만 뽑아 새로운 List로 만들자 - collect()");
		List<Student> mans = totalList.stream().filter(s -> s.getGender().equals("남")).collect(Collectors.toList());
		System.out.println(mans);
		System.out.println(mans.getClass());
		mans.add(new Student("test", "여", 22));
		
		System.out.println("2.학생들중 남학생만 뽑아 새로운 List로 만들자 - toList()");
		List<Student> mans2 = totalList.stream().filter(s -> s.getGender().equals("남")).toList();
		System.out.println(mans2);
		System.out.println(mans2.getClass());
		
		
		System.out.println("----toMap<K, V> 사용해보자-------");
		System.out.println("3.학생들정보를 이름을 key , 점수를 value 만들이서 Map 리턴해보자");
		
		Map<String, Integer> collect = totalList.stream().collect(Collectors.toMap(Student::getName, Student::getScore));
		collect.forEach((a,b) -> System.out.println(a +" = "+ b));

	}

}














