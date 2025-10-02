package ex0729;

public class IfExam2 {
	public static void main(String[] args) {
		//1 ~ 12 사이의 난수 발생한다.
		
		int a = (int)(Math.random()*12)+1;
		System.out.println(a);
		
		//발생한 난수가 1이면 일요일.... 6이면 금요일, 이외의 수는 토요일 출력한다.
		if(a == 1) {
			System.out.println("일요일");
		}else if (a == 2) {
			System.out.println("월요일");
		}else if (a == 3) {
			System.out.println("화요일");
		}else if (a == 4) {
			System.out.println("수요일");
		}else if (a == 5) {
			System.out.println("목요일");
		}else if (a == 6) {
			System.out.println("금요일");
		}else {
			System.out.println("토요일");
		}
		
		for(int i = 0; i<=100; i++) {
			int d = (int)(Math.random()*12)+1;
			check(d, 12, 1);
		}
		
	}
	
	
	
	public static void check(int a, int max, int min) {
		if(a > max) {
			System.out.println("최대치를 초과 : " + a);
		}else if (a < min) {
			System.out.println("최소치 미만 : " + a);
		}
	}
	
}
