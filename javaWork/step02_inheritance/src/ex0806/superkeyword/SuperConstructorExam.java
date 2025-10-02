package ex0806.superkeyword;


class Parent{
	public Parent() {
		System.out.println(1);
	}

	public Parent(int i) {
		System.out.println(2);
	}
	
	public Parent(String s) {
		System.out.println(3);
	}
}

class Child extends Parent{//Chile is a Parent
	public Child() {
		this(4);
		System.out.println(4);
	}
	
	public Child(int a) {
		super(a);
		System.out.println(5);
	}
	
	public Child(boolean b) {
		super("o");
		System.out.println(6);
	}
}


public class SuperConstructorExam {
	public static void main(String[] args) {
		new Child(true);
	}
}
