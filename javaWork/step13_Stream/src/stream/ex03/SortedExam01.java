package stream.ex03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortedExam01 {
	public static void main(String[] args) {
		List<Student> list  = Arrays.asList(
				   new Student("희정", 22, 80, "컴퓨터"),
				   new Student("나영", 25, 60, "과학"),
				   new Student("미영", 21, 82, "컴퓨터"),
				   new Student("삼순", 30, 95, "국어"),
				   new Student("삼식", 22, 70, "수학"),
				   new Student("효경", 28, 80, "국어")
		 );
		
		System.out.println("---1.점수기준으로 오름차순-----------");
		list.stream().sorted().forEach(x -> System.out.print(x.getName() + " "));
		System.out.println();
		System.out.println("---2.점수기준으로 내림차순-----------");
		list.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x.getName() + " "));
		System.out.println();
		
		System.out.println("--3.나이를 기준으로 정렬---------");
		list.stream().sorted(Comparator.comparingInt(Student :: getAge).reversed()).forEach(System.out::println);
		
		

	}

}












