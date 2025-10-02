package ex0801.array;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		StudentService stuService = new StudentService();
		StudentEndView stuEndView = new StudentEndView();
		int menu = 0;
		stuEndView.printStart();
		stuService.init(); //초기화 작업
		
		//Student[] stuArr = stuService.getSelectAll();
		//StudentEndView.printSelectAll(stuArr);
		
		while(menu != 5) {
			menu = stuEndView.printMainMenu();
			if(menu == 1) {
				
			}
		}
		
	}	

}
