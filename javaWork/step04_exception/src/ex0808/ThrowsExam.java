package ex0808;

import java.io.IOException;

public class ThrowsExam {
	public void aa(int i) {
		System.out.println("aa call");
		
		this.bb(i);
		
		System.out.println("aa end");
	}
	public void bb(int i) {
		System.out.println("bb call");
		try {
			int result = 100/i;
			System.out.println("result = " + result);
		}finally {
			System.out.println("bb end");
		}
	}
	public static void main(String[] args){
		System.out.println("***메인 시작***");
		
		ThrowsExam te = new ThrowsExam();
		te.aa(5);
		try {
			throw new MyNumberException();
		} catch (MyNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***메인 끝***");
	}
}
