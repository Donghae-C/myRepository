package ex0729.homework;

public class ReportCard {

	public static void main(String[] args) {
		String myName = "donghae";
		int koreanRecord = (int)(Math.random()*56)+45;
		int englishRecord = (int)(Math.random()*56)+45;
		int mathRecord = (int)(Math.random()*56)+45;
		
		int sumRecord = koreanRecord + englishRecord + mathRecord;
		double recordAvg = sumRecord / 3.0;
		char grade = 'F';
		
		//if문
		
		if(recordAvg >= 90) {
			grade = 'A';
		}else if(recordAvg >= 80) {
			grade = 'B';
		}else if(recordAvg >= 70) {
			grade = 'C';
		}else if(recordAvg >= 60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		
		System.out.println(myName + "\n국어점수 : " + koreanRecord + "\n영어점수 : " + englishRecord
				+ "\n수학점수 : " + mathRecord + "\n총점 : " + sumRecord + "\n평균 : " + recordAvg + "\n학점 : " + grade);
		
		// switch문
		
		koreanRecord = (int)(Math.random()*56)+45;
		englishRecord = (int)(Math.random()*56)+45;
		mathRecord = (int)(Math.random()*56)+45;
		
		sumRecord = koreanRecord + englishRecord + mathRecord;
		recordAvg = sumRecord / 3.0;
		int intRecordAvg = (int)recordAvg/10;
		grade = 'F';
		
		switch(intRecordAvg) {
		case 10, 9 -> {grade = 'A';}
		case 8 -> {grade = 'B';}
		case 7 -> {grade = 'C';}
		case 6 -> {grade = 'D';}
		default -> {grade = 'F';}
		}
		
		System.out.println(myName + "\n국어점수 : " + koreanRecord + "\n영어점수 : " + englishRecord
				+ "\n수학점수 : " + mathRecord + "\n총점 : " + sumRecord + "\n평균 : " + recordAvg + "\n학점 : " + grade);
		
		
	}

}
