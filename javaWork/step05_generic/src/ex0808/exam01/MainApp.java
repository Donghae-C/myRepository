package ex0808.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainApp {

	public static void main(String[] args) {
		/*
		 * Box box1 = new Box(); box1.setContent("과자");
		 * 
		 * String s = (String)box1.getContent();
		 * 
		 * System.out.println(s);
		 */
		
		//제네릭 사용한 경우
		Box<String> box2 = new Box<>();
		box2.setContent("과자");
		String s = box2.getContent();
		
		Box<Integer> box3 = new Box<>();
		box3.setContent(5);
		Integer content = box3.getContent();
		Box<Board> box4 = new Box<>();
		box4.setContent(new Board());
		Board board = box4.getContent();
	}

}
