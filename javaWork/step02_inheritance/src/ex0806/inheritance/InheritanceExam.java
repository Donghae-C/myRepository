package ex0806.inheritance;

import test.Test;
import test.TestImpl;

class Car{
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
	//각 클래스에 인수를 받지않는 생성자 작성
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
class EfSonata extends Car{
	int a = 10;
	
	public EfSonata() {
		carname = "EfSonata";
		super.cost = 10;
		test();
	}
	public void test() {
		System.out.println("ㅇㅇ");
	}
	
}

class Excel extends Car{

	public Excel() {
		carname = "Excel";
		cost = 15;
	}
	
}

class Carnival extends Car{

	public Carnival() {
		carname = "Carnival";
		cost = 11;
	}
	
}
	

public class InheritanceExam{
	//메인메소드에서 
	public static void main(String[] args) {
		//Car, EfSonata, Excel, Carnival 네개의 객체를 생성
		// 각 클래스에서 Car class에있는 printAttributes()메소드를 호출할수있다.
		//Car car = new Car();		
		Car efSonata = new EfSonata();
		//Excel excel = new Excel();
		//Carnival carnival = new Carnival();
		//Object car2 = new Car();
		//Object car3 = new Car();
		
		//car.printAttributes();
		//System.out.println("abc" == ("ab"+"c"));
		efSonata.printAttributes();
		//excel.printAttributes();
		//carnival.printAttributes();
	}	

}

