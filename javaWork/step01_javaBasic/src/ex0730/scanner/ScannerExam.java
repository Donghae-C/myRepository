package ex0730.scanner;

import java.util.Scanner;

import reader.MyReader;

public class ScannerExam {

	public static void main(String[] args) {
		MyReader mr = new MyReader();
		Scanner sc = mr.getSc();
		
		System.out.print("국어점수는?");
		int kor = sc.nextInt();
		
		System.out.print("영어점수는?");
		int eng = sc.nextInt();
		
		System.out.print("이름은?");
		String name = sc.next();
		
		int sum = kor + eng;
		System.out.println(name+"님의 총점은 "+sum);
	}

}
