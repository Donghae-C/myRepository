package ex0804.homework;

import java.util.Scanner;

//TwoDmArrayExam.java

/**
 * 08/01
 * 최동해
 * 2차원 배열 출력문제입니다.
 */

class TwoDmArray{
	//String을 저장하는 twoDmArray 배열선언
	
	int rowLen;
	String[][] twoDmArray;
	public TwoDmArray(int a) {
		this.rowLen = a; 
		twoDmArray = new String[rowLen][];
	}
	//메소드 make2DmArray
	public void make2DmArray() {
		//twoDmArray 배열에  값을 할당
		for(int i=0;i<rowLen;i++) {
			twoDmArray[i] = new String[i+1];
			for(int j=0;j<=i;j++) {
				twoDmArray[i][j] = i+1 + "동" + (j+1) + "호\t";
				System.out.print(twoDmArray[i][j]);
			}
			System.out.println();
		}
	}		
	//메소드 print2DmArray
	//	twoDmArray 배열의 값을 주어진형식으로 출력
	public void print2DmArray() {
		for(int i=0;i<rowLen;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("\t");
			}
			for(int j=i;j<rowLen;j++) {
				System.out.print(twoDmArray[j][i]);
			}
			System.out.println();
		}
		
	}
	public void print3DmArray() {
		for(int i=0;i<rowLen;i++) {
			for(int j=0;j<rowLen;j++) {
				if(j>=i) {
					System.out.print(twoDmArray[j][i]);	
				}else {
					System.out.print("\t");
				}
				
			}
			System.out.println();
		}
		
	}
		
}

public class TwoDmArrayExam{
	//main메소드에서
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자");
		int num = Integer.parseInt(sc.nextLine());
		TwoDmArray tda = new TwoDmArray(num);
		tda.make2DmArray();
		tda.print2DmArray();
		tda.print3DmArray();
	}
	
		//TwoDmArray객체생성
		
		//TwoDmArray객체의 make2DmArray메소드 호출
		
		//TwoDmArray객체의 print2DmArray메소드 호출
		
	
}
