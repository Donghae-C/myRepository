package ex0731.homework;

import java.util.Scanner;

/**
 * 
 */
class RecordService{
	
	/**
	 * ㅇㅇㅇㅇㅇㅇㅇ
	 * @param kor
	 * @param eng
	 * @param math
	 * @return
	 */
	private int sumRecord(int kor, int eng, int math) {
		return kor + eng + math;
	}
	
	private double avgRecord(int countRec, int sumRec) {
		return sumRec/(double)countRec;
	}
	
	private String gradeRecord(double avrRec) {
		String record = "F";
		if(avrRec >= 90) {
			record = "A";
		}else if(avrRec >= 80) {
			record = "B";
		}else if(avrRec >= 70) {
			record = "C";
		}else if(avrRec >= 60) {
			record = "D";
		}else {
			record = "F";
		}
		return record;
	}
	
	public void printRecord(String name, int kor, int eng, int math) {
		int sumRec = sumRecord(kor, eng, math);
		double avgRec = avgRecord(3, sumRec);
		String grade = gradeRecord(avgRec);
		System.out.printf("%5s %-10s %-8s %-5s%n","이름","총점","평균","등급");
		System.out.printf("%5s %-10d %-8.2f %-5s%n",name,sumRec,avgRec,grade);
	}
}


public class RecordCard2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RecordService rs = new RecordService();
		String name = "";
		int kor = 0;
		int eng = 0;
		int math = 0;
		int select = 0;
		while(select == 0 || select != 2) {
			System.out.println("1.성적표 구하기\t 2.종료");
			System.out.print("번호선택>");
			String result = sc.nextLine();
			select = Integer.parseInt(result);
			if(select == 1) {
				System.out.print("이름입력>");
				name = sc.nextLine();
				System.out.print("국어점수 입력>");
				kor = Integer.parseInt(sc.nextLine());
				System.out.print("영어점수 입력>");
				eng = Integer.parseInt(sc.nextLine());
				System.out.print("수학점수 입력>");
				math = Integer.parseInt(sc.nextLine());
				System.out.println();
				rs.printRecord(name, kor, eng, math);
			}
		}
		sc.close();
	}

}
