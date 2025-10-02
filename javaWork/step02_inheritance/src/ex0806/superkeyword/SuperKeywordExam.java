package ex0806.superkeyword;


class Animal{
	int age = 5;
	String bodyColor;
	
	public void sound() {
		System.out.println("super의 sound call..");
	}
	
	public void eat() {
		System.out.println("super eat call..");
	}
}

class Cat extends Animal{ // Cat is a Animal
	int age = 2;
	int weight;
	@Override
	public void sound() {
		System.out.println("Cat의 sound call..");
	}
	public void run() {
		System.out.println("Cat의 run call..");
	}
	public void test() {
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(super.age);
		
		System.out.println("-----------------------------------");
		
		System.out.println(bodyColor);
		System.out.println(this.bodyColor);
		System.out.println(super.bodyColor);
		
		System.out.println("-----------------------------------");
		
		System.out.println(weight);
		System.out.println(this.weight);
		//System.out.println(super.weight);
		
		System.out.println("-------------메소드------------------");
		sound();
		this.sound();
		super.sound();
		
		System.out.println("-----------------------------------");
		
		eat();
		this.eat();
		super.eat();
		
		System.out.println("-----------------------------------");
		
		run();
		this.run();
		//super.run();
	}
	
}


public class SuperKeywordExam {

	public static void main(String[] args) {
		//new Cat().test();
		
		Cat cat = new Cat();
		System.out.println(cat.age);
		System.out.println(cat.bodyColor);
		System.out.println(cat.weight);
		
		cat.sound();
		cat.eat();
		cat.run();
		
		System.out.println("-------------------------------");
		
		Animal cat2 = new Cat();
		System.out.println(cat2.age);
		System.out.println(cat2.bodyColor);
		//System.out.println(cat2.weight);
		
		cat2.sound();
		cat2.eat();
		//cat2.run();
	}

}
