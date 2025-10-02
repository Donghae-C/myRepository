package ex0729.제어문;

public class IfExam01 {

	public static void main(String[] args) {
		// 정수형 변수 하나를 선언과 동시에 적당한 값으로 초기화
		
		// 선언한 변수의 값이 짝수이면 짝수입니다. 아니면 홀수입니다.
		int a = (int)(Math.random() * 1000000) + 1;
		System.out.println(a);
		if(a%2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		

	}
	
	public void check(int a, int max, int min) {
		if(a<min) {
			System.out.println("최소값보다 값이 낮음 : "+a);
		}else if (a>max) {
			System.out.println("최대값보다 값이 높음 : "+a);
		}
	}

}
