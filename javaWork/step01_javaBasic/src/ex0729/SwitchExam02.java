package ex0729;

public class SwitchExam02 {

	public static void main(String[] args) {
		//1 ~ 12 사이의 난수 발생
		int a = (int)(Math.random()*12) + 1;
		
		int day = switch(a){
		case 2 -> 28;
		case 4, 6, 9, 11 -> 30;
		default -> 31;
		};
		
		System.out.println(a+"월은 "+day+"일 까지");
		
		a = (int)(Math.random()*12) + 1;
		day = 0;
		switch(a) {
		case 2 -> {day = 28;}
		case 4, 6, 9, 11 -> {day = 30;}
		default -> {day = 31;}
		};
		
		System.out.println(a+"월은 "+day+"일 까지");
		
		a = (int)(Math.random()*12) + 1;
		day = 0;
		if(a == 2) {
			day = 28;
		}else if(a == 4 || a == 6 || a == 9 || a == 11) {
			day = 30;
		}else {
			day = 31;
		}
		
		System.out.println(a+"월은 "+day+"일 까지");
	
		
	}

}
