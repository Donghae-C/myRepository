package test;

import java.util.Scanner;

public class View {
	public View() {
	Controller con = new Controller();
	boolean run = true;	
	while(run) {
	System.out.println("--------------------------------------------");
	System.out.println("1. 프로필 저장 2. 프로필 불러오기 3. 종료");
	Scanner sc = new Scanner(System.in);
	int sel = sc.nextInt();
	switch(sel) {
	case 1 : con.saveInfo(); ; break;
	case 2 : con.loadInfo();; break;
	case 3 : {System.out.println("프로그램이 종료되었습니다.");
	run = false;
	} ; break;
	
	
	}
	
		 }
	}

}
