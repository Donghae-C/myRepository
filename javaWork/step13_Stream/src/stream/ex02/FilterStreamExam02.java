package stream.ex02;

import java.util.Arrays;
import java.util.List;

public class FilterStreamExam02 {
	public static void main(String[] args) {
		List<String> list = 
				Arrays.asList("장희정","정정화","오윤겸","장희정","손지민","황태윤","오윤겸");
		
		System.out.println("1.중복행 제거  -------------");
		List<String> list2 = list.stream().distinct().toList();
		list2.stream().forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		System.out.println("2. filter 요소 걸러내기(장희정만 뽑기) -------------");
		List<String> list3 = list.stream().filter(x -> x.equals("장희정")).toList();
		list3.stream().forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		System.out.println("3. filter 요소 걸러내기(장으로 시작하는 ) -------------");
		list.stream().filter(x -> x.startsWith("오")).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		System.out.println("4. filter 요소 걸러내기(정으로 끝나는 ) -------------");
		list.stream().filter(x -> x.endsWith("겸")).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		
		System.out.println("5. 중복제거, 장으로 시작 , 출력하기 -------------");
		list.stream().distinct().filter(x -> x.startsWith("장")).forEach(x -> System.out.print(x + " "));
		System.out.println();
		

	}

}











