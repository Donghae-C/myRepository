package ex0808;

import java.util.Scanner;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("***메인 시작***");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int result = 0;
			try {
				result = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("숫자로 못바꿈" + e.getMessage());
				continue;
			} finally {
				System.out.println("일단 돌아");
			}
			System.out.println("이건?");
			if(result == 10) {
				break;
			}
		}
	}

}
