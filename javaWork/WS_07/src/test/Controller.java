package test;

import java.util.Scanner;

public class Controller {
	Scanner sc = new Scanner(System.in);
	Service sv = new Service();
	public void saveInfo() {
		
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		System.out.println("몸무게를 입력해주세요");
		Double weight = Double.parseDouble(sc.nextLine());
		System.out.println("비밀번호를 입력해주세요");
		String pw = sc.nextLine();
		sv.saveInfoFile(name, weight, pw);
		
	}
	public void loadInfo() {
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		sv.loadInfoFile(name);
		
		
	}
	
}
