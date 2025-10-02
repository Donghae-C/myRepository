package ex0805.homework;
/**
 * 08/05
 * 최동해
 * 6장 확인문제 16번
 * Service 클래스 메소드 선언
 */
class Printer{
	public void println(int a) {
		System.out.println(a);
	}
	public void println(boolean result) {
		System.out.println(result);
	}
	public void println(double a) {
		System.out.println(a);
	}
	public void println(String s) {
		System.out.println(s);
	}
}
public class Homework3 {
	public static void main(String[] args) {
		Printer pr = new Printer();
		pr.println(10);
		pr.println(true);
		pr.println(5.7);
		pr.println("홍길동");
	}
}
