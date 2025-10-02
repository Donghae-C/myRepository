package ex0807.abstract_final;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Scanner;

/**
 * 모든 동물들이 공통으로 갖는 속성과 메소드를 정의
 */

abstract class Animal{
	int leg;
	
	public abstract void sound();
	public abstract void run();
	
	public void eat() {
		System.out.println("잘 먹는다!!");
	}
}

class Dog extends Animal{

	@Override
	public void sound() {
		System.out.println("멈멈");
	}

	@Override
	public void run() {
		System.out.println("잘뛴다!!");
	}
	
}

class Pig extends Animal{

	@Override
	public void sound() {
		System.out.println("꿀");
	}

	@Override
	public void run() {
		System.out.println("걷는다!!");
	}

	@Override
	public void eat() {
		System.out.println("마신다!");
	}
	
	
	
}

class Cat extends Animal{

	@Override
	public void sound() {
		System.out.println("앵");
	}

	@Override
	public void run() {
		System.out.println("날아다닌다");
		secret();
	}
	
	private void secret() {
		System.out.println("사실 걷는다");
	}
	
}

public class AbstractExam{
	public static void test(Animal animal) {
		animal.sound();
		animal.run();
		animal.eat();
	}
	
	public static void main(String[] args) {
		Animal dog1 = new Dog();
		dog1.sound();
		dog1.run();
		dog1.eat();
		
		Animal pig1 = new Pig();
		pig1.sound();
		pig1.run();
		pig1.eat();
		
		Animal cat1 = new Cat();
		cat1.sound();
		cat1.run();
		cat1.eat();
		
		Animal animal = null;
		System.out.println("1.개 2.돼지 3.고양이");
		Scanner sc = new Scanner(System.in);
		int ch = Integer.parseInt(sc.nextLine());
		if(ch == 1) {
			animal = new Dog();
		}else if(ch == 2) {
			animal = new Pig();
		}else {
			animal = new Cat();
		}
		animal.sound();
		animal.run();
		animal.eat();
		
		System.out.println("1.개 2.돼지 3.고양이");
		ch = Integer.parseInt(sc.nextLine());
		if(ch == 1) {
			test(new Dog());
		}else if(ch == 2) {
			test(new Pig());
		}else {
			test(new Cat());
		}
		
	}
}
