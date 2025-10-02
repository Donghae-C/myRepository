package ex0730.homework;

public class Homework15 {

	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("****************************");
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("****************************");
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=5;j++) {
				if(j>=i) {
					System.out.print("★");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("****************************");
		for(int i=5;i>=1;i--) {
			for(int j=5;j>=1;j--) {
				if(j<=i) {
					System.out.print("★");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}

}
