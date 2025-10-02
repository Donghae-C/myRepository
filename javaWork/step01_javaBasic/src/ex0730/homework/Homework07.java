package ex0730.homework;

import java.util.Scanner;

public class Homework07 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int deposit = 0;
		
		int menu = 0;
		
		while(true) {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택>");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				System.out.print("예금액>");
				deposit = deposit += Integer.parseInt(sc.nextLine());
				System.out.println();
			}else if(menu == 2) {
				System.out.print("출금액>");
				deposit = deposit - Integer.parseInt(sc.nextLine());
				System.out.println();
			}else if(menu == 3) {
				System.out.print("잔고>");
				System.out.println(deposit);
				System.out.println();
			}else {
				System.out.println();
				System.out.println("프로그램 종료");
				break;
			}
		}
		sc.close();
	}

}
