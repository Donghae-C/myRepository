package ex0801.homework;

import java.util.Scanner;

/**
 * 08/01
 * 최동해
 * 5장 확인문제 9번
 */

public class Homework09 {
	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		int menu = 0;
		int count = 0;
		double avgScore = 0;
		int[] scores = new int[0];
		while(menu != 5) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------");
			System.out.println("선택>");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1){
				System.out.println("학생수>");
				count = Integer.parseInt(sc.nextLine());
				scores = new int[count];
				if(count == 0){
					System.out.println("0명은 등록할 수 없습니다");
				}
			}else if(menu == 2){
				if(count == 0){
					System.out.println("학생 수 부터 입력해주세요");
				}else{
					for(int i=0;i<count;i++){
						System.out.println("scores["+i+"]>");
						scores[i] = Integer.parseInt(sc.nextLine());
					}
				}
			}else if(menu == 3){
				if(count == 0){
					System.out.println("학생 수 부터 입력해주세요");
				}else{
					for(int i=0;i<count;i++){
						System.out.println(scores[i]);
					}
				}
			}else if (menu == 4){
				if(count == 0){
					System.out.println("학생 수 부터 입력해주세요");
				}else{
					int temp = 0;
					int sumScore = 0;
					for(int i=0;i<count-1;i++){
						for(int j=0;j<count - i - 1;j++){
							if(scores[j]>scores[j+1]){
								temp = scores[j];
								scores[j] = scores[j+1];
								scores[j+1] = temp;
							}
						}
					}
					System.out.println("최고 점수 : " + scores[count-1]);
					for(int i=0;i<count;i++){
						sumScore += scores[i];
					}
					avgScore = (double)sumScore/count;
					System.out.println("평균 점수 : " + avgScore);
				}
			}
		}
		sc.close();
	}
}
