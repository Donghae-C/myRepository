package ex0814.homework.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ex0814.homework.controller.MainController;
import ex0814.homework.dto.DataDto;

public class MenuView {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	MainController mc = new MainController();


	public void printMenu() {
		int count = 3;
		while(true) {
			System.out.println("다음 사항에 맞게 입력하여 주십시오");
			System.out.println("         몸무게 입력은 1번");
			System.out.println("         몸무게 검색은 2번");
			System.out.println("         몸무게 변경은 3번");
			System.out.println("         비밀번호 변경은 4번");
			System.out.println("         프로그램 종료는 5번");
			System.out.println("을 입력후 Enter 을 눌러 주십시오");
			System.out.println("메뉴 선택 : ");
			String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (line) {
				case "1" : viewInput(); break;
				case "2" : viewSearch(count, 0); break;
				case "3" : viewUpdateWeight(); break;
				case "4" : viewUpdatePwd(); break;
				case "5" : System.exit(0); break;
			}
		}
	}
	
	private DataDto viewSearch(int count, int style) {
		String name = null;
		String pwd = null;
		try {
			System.out.println("검색할 이름을 입력하여 주십시오");
			System.out.println("이름 : ");
			name = br.readLine();
			System.out.println("비밀번호를 입력하여 주십시오");
			System.out.println("비밀번호 : ");
			pwd = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataDto data = new DataDto(name, pwd);
		if(!mc.searchByName(data, style)) {
			count--;
			if(count != 0){
				System.out.println(count + "회 남았습니다");	
			}else{
				System.out.println("메인으로 돌아갑니다");
				return data;
			}
			viewSearch(count, style);
		}
		return data;
	}
	
	private void viewInput() {
		DataDto data = null;
		String name = null;
		int weight = 0;
		String pwd = null;
		try {
			System.out.println("이름을 입력하여 주십시오");
			System.out.println("이름 : ");
			name = br.readLine();
			System.out.println("몸무게를 입력하여 주십시오");
			System.out.println("몸무게 : ");
			weight = Integer.parseInt(br.readLine());
			System.out.println("비밀번호를 입력하여 주십시오");
			System.out.println("비밀번호 : ");
			pwd = br.readLine();
			data = new DataDto(name, weight, pwd);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		mc.insert(data);
	}

	private void viewUpdateWeight(){
		DataDto loaded = viewSearch(3, 0);
        try {
            System.out.println("변경할 몸무게를 입력하여 주십시오");
            System.out.print("변경할 몸무게 : ");
            int weight = Integer.parseInt(br.readLine());
			loaded.setWeight(weight);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
			System.out.println("숫자로 입력해야함");
		}
        mc.updateWeight(loaded);
	}

	private void viewUpdatePwd(){
		DataDto loaded = viewSearch(3, 1);
		try {
			System.out.println("변경할 비밀번호를 입력해 주십시오");
			System.out.print("변경할 비밀번호 : ");
			String pwd = br.readLine();
			loaded.setPwd(pwd);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		mc.updatePwd(loaded);
	}
}
