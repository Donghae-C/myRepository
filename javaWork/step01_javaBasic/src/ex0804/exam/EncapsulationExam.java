package ex0804.exam;

import java.util.Scanner;

public class EncapsulationExam {
	private int weight;
	private String password;
	
	/**
	 * 몸무게 인출 메서드
	 * @param password
	 * @return
	 */
	public int getWeight(String password) {
		if(isCertificate(password)) {
			return this.weight;
		}
		return 0;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setWeight(int weight, String password) {
		if(isCertificate(password)) {
			this.weight = weight;
		}	
	}
	
	public void setPassword(String pw, String pwToChange) {
		if(isCertificate(pw)) {
			this.password = pwToChange;
		}
		
	}
	
	/**
	 * 비밀번호 비교 메서드
	 * @param pw
	 * @return
	 */
	private boolean isCertificate(String pw) {
		if(this.password.equals(pw)) {
			return true;
		}
		System.out.println("비밀번호 오류");
		return false;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EncapsulationExam ee = new EncapsulationExam();
		boolean run = true;
		int menu = 0;
		
		System.out.print("몸무게 입력>");
		ee.weight = Integer.parseInt(sc.nextLine());
		System.out.print("비밀번호 입력>");
		ee.password = sc.nextLine();
		
		
		while(run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.몸무게 검색 | 2.몸무게 변경 | 3.비밀번호 변경 | 4.종료");
			System.out.println("------------------------------------------------");
			System.out.println("선택>");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				System.out.print("비밀번호 입력>");
				int a = ee.getWeight(sc.nextLine());
				if(a != 0) {
					System.out.println("몸무게는 "+ a +" Kg입니다.");
				}else {
					System.out.println("??");
				}
				
			}else if(menu == 2) {
				System.out.println("비밀번호 입력>");
				String str = sc.nextLine();
				System.out.println("변경할 몸무게 입력>");
				int result = Integer.parseInt(sc.nextLine());
				ee.setWeight(result, str);
			}else if(menu == 3) {
				System.out.print("비밀번호 입력>");
				String pw = sc.nextLine();
				System.out.println("변경할 비밀번호 입력>");
				String pwToChange = sc.nextLine();
				ee.setPassword(pw, pwToChange);
			}else if(menu == 4) {
				run = false;
			}
		}
	}

}
