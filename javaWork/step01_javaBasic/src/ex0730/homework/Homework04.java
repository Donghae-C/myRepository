package ex0730.homework;

public class Homework04 {

	public static void main(String[] args) {
		int dice1 = 0;
		int dice2 = 0; 
		int sumDice = 0;
		while(sumDice != 5) {
			dice1 = (int)(Math.random()*6)+1;
			dice2 = (int)(Math.random()*6)+1;
			System.out.println("("+dice1+", "+dice2+")");
			sumDice = dice1 + dice2;
		}
	}

}
