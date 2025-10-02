package ex0730.제어문;

public class DoubleForExam02 {

	public static void main(String[] args) {
		ForTest test = new ForTest();
		
		test.ex05();
	}
}

class ForTest{
	public void ex01() {
		for(int i = 0; i<10; i++) {
			for(int j=1; j<=10; j++) {
				System.out.print((i*10+j)+"\t");
			}
			System.out.println("");
		}
	}
	
	public void ex02() {
		for(int i=1; i<=100; i++) {
			if(i%10 == 0) {
				System.out.println(i);
			}else {
				System.out.print(i + "\t");
			}
		}
	}
	
	public void ex03() {
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				System.out.print(j + " * " + i + " = " + (j*i) + "\t");
			}
			System.out.println("");
		}
	}
	
	//5단만 빼고 출력하기
	public void ex04() {
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				if(j==5) {
					continue;	
				}else {
					System.out.print(j + " * " + i + " = " + (j*i) + "\t");
				}
			}
			System.out.println("");
		}
	}
	//5단까지만 출력하기
		public void ex05() {
			for(int i=1; i<=9; i++) {
				for(int j=2; j<=9; j++) {
					if(j==6) {
						break;	
					}else {
						System.out.print(j + " * " + i + " = " + (j*i) + "\t");
					}
				}
				System.out.println("");
			}
		}
	
}
