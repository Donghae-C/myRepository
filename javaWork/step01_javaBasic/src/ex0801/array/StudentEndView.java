package ex0801.array;

import java.util.Scanner;

/**
 * 사용자 요청의 결과 출력 담당 클래스
 */
public class StudentEndView {
	Scanner sc = new Scanner(System.in);
	/**
	 * 전체 학생 출력
	 */
	public static void printSelectAll(Student[] stuArr) {
		int len = StudentService.currentCount;
		for(int i=0;i<len;i++) {
			System.out.println("이름 : "+stuArr[i].getName()+"\t나이 : "+stuArr[i].getAge()+"\t주소 : "+stuArr[i].getAddress());
		}
	}
	
	
	/**
	 * 이름에 해당하는 학생 정보를 출력
	 */
	public void printSelectOne(Student stu) {
		System.out.println("이름 : "+stu.getName()+"\t나이 : "+stu.getAge()+"\t주소 : "+stu.getAddress());
	}
	
	
	/**
	 * 수정, 삭제, 등록 결과에 대한 메시지 출력
	 */
	public void printResultCUD(boolean result, String str) {
		if(result) {
			System.out.println(str + " 완료되었습니다.");
		}else {
			System.out.println(str + " 실패");
		}
	}
	
	public int printMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1.등록 | 2.전체조회 | 3.이름으로 조회 | 4. 수정 | 5. 종료");
		System.out.println("------------------------------------------------");
		System.out.print("선택>");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	public void printStart() {
		System.out.println("학생관리 프로그램 시작");
	}
	
}
