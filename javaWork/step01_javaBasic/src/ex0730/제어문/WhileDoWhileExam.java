package ex0730.제어문;

public class WhileDoWhileExam {

	public static void main(String[] args) {
		WdwTest test = new WdwTest();
		test.exam10();
	}
	
	public void test() {
		
	}
}

class WdwTest{
	//1번 while
	public void exam01() {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while(i<=100) {
			sb.append(i);
			sb.append(", ");
			i++;
		}
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	//1번 do-while
	public void exam02() {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		do {
			sb.append(i);
			sb.append(", ");
			i++;
		}while(i<=100);
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	//2번 while
	public void exam03() {
		StringBuilder sb = new StringBuilder();
		char a = 'A';
		while(a <= 'Z') {
			sb.append(a);
			sb.append(", ");
			a++;
		}
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	//2번 do-while
	public void exam04() {
		StringBuilder sb = new StringBuilder();
		char a = 'A';
		do {
			sb.append(a);
			sb.append(", ");
			a++;
		}while(a <= 'Z');	
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	//3번 while
	public void exam05() {
		int i = 1;
		int sum = 0;
		while(i <= 10) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}
	//3번 do-while
	public void exam06() {
		int i = 1;
		int sum = 0;
		do {
			sum += i;
			i++;
		}while(i <= 10);
		System.out.println(sum);
	}
	//4번 while
	public void exam07() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i<=100) {
			if(i==0) {
				i += 7;
				continue;
			}
			sb.append(i);
			sb.append(", ");
			i += 7;
		}	
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	//4번 do-while
	public void exam08() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		do {
			if(i == 0) {
				i += 7;
				continue;
			}
			sb.append(i);
			sb.append(", ");
			i += 7;
		}while(i <= 100);	
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	//5번 while
	public void exam09() {
		StringBuilder sb = new StringBuilder();
		int i = 100;
		while(i >= 1) {
			sb.append(i);
			sb.append(", ");
			i -= 5;
		}
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	//5번 do-while
	public void exam10() {
		StringBuilder sb = new StringBuilder();
		int i = 100;
		do {
			sb.append(i);
			sb.append(", ");
			i -= 5;
		}while(i >= 1);
		sb.delete(sb.length()-2, sb.length()-1);
		System.out.println(sb.toString());
	}
	
	
}
