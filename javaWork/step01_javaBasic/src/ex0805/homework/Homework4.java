package ex0805.homework;
/**
 * 08/05
 * 최동해
 * 6장 확인문제 17번
 * 16번 static 변경
 */
class Printer2{
	public static void println(int a) {
		System.out.println(a);
	}
	public static void println(boolean result) {
		System.out.println(result);
	}
	public static void println(double a) {
		System.out.println(a);
	}
	public static void println(String s) {
		System.out.println(s);
	}
}
public class Homework4 {
	public static void main(String[] args) {
		Printer2.println(10);
		Printer2.println(true);
		Printer2.println(5.7);
		Printer2.println("홍길동");
	}
}
