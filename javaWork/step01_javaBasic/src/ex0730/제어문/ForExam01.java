package ex0730.제어문;

public class ForExam01 {
	public static void main(String[] args) {
		ex01();
		ex02();
		ex03();
		ex04();
		ex05();
	}
	 
	public static void ex01() {
		System.out.println("-1-");
		for(int i = 1; i<=100; i++) {
			if(i==100) System.out.println(i);
			else System.out.print(i+", ");
			
		}
		System.out.println("");
	}
	
	public static void ex02() {
		System.out.println("-2-");
		for(char a = 'A'; a<='Z'; a++) {
			if(a=='Z') System.out.println(a);
			else System.out.print(a+", ");
		}
		System.out.println("");
	}
	
	public static void ex03() {
		System.out.println("-3-");
		int num = 0;
		for(int i = 1; i <= 10; i++) {
			num += i;
		}
		System.out.println(num);
	}
	
	public static void ex04() {
		System.out.println("-4-");
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=100; i++) {
			if (i % 7 == 0) {
				sb.append(i);
				sb.append(", ");
			}
			if(i==100) {
				sb.delete(sb.length()-2, sb.length()-1);
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void ex05() {
		System.out.println("-5-");
		StringBuilder sb = new StringBuilder();
		for(int i=100;i>=1;i-=5) {
			sb.append(i);
			sb.append(", ");
		}
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	
}
