package stream.ex02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExam01 {

	public static void main(String[] args) {
		System.out.println("1.String Array Stream ------------");
		String [] strArr = {"희정","현준","정화","민지","경찬"};
		/*for(String s:strArr) { //자료구조의 Iterator를 이용한 방식
			System.out.println(s);
		}*/
		Stream<String> stream = Arrays.stream(strArr);
		//Stream을 이용해서  출력해보자
		//1) 람다식
		stream.forEach(x -> System.out.println(x));
		//2) 메소드 참조
		Arrays.stream(strArr).forEach(System.out::println);
		//3) 한번 사용한 Stream을 다시 사용해보자(사용불가x)
		
		
		System.out.println("2.int Array Stream ------------");
		int [] intArr = {1,2,3,4,5,6,7,8,9};
		
		IntStream.of(intArr)
		.filter(i -> i%2 == 0)
		.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		
		
		System.out.println("3.range()  vs rangeClosed() ------------");
		IntStream.range(1, 100).filter(x -> x%5 == 0).forEach(System.out::println);
		IntStream.rangeClosed(1, 100).filter(x -> x%5 == 0).forEach(System.out::println);

	}

}






