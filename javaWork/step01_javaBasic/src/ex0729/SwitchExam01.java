package ex0729;

public class SwitchExam01 {

	public static void main(String[] args) {
		//1 ~ 12 사이의 난수 발생한다.
		
		//발생한 난수가 1이면 일요일.... 6이면 금요일, 이외의 수는 토요일 출력한다.
		
		int a = (int)(Math.random()*12)+1;
		System.out.println(a);
		char day;
		
		switch(a) {
			case 1 : day = '일'; break;
			case 2 : day = '월'; break;
			case 3 : day = '화'; break;
			case 4 : day = '수'; break;
			case 5 : day = '목'; break;
			case 6 : day = '금'; break;
			default : day = '토';
		}
		
		System.out.println(day+"요일");
		
		a = (int)(Math.random()*12)+1;
		
		switch(a) {
		case 1 -> {day = '일';}
		case 2 -> {day = '월';}
		case 3 -> {day = '화';}
		case 4 -> {day = '수';}
		case 5 -> {day = '목';}
		case 6 -> {day = '금';}
		default -> {day = '토';}
		}
		System.out.println(day+"요일");
		
		a = (int)(Math.random()*12)+1;
		
		day = switch(a) {
		case 1 -> '일';
		case 2 -> '월';
		case 3 -> '화';
		case 4 -> '수';
		case 5 -> '목';
		case 6 -> '금';
		default -> '토';
		};
		
		System.out.println(day+"요일");
	}
		

}
