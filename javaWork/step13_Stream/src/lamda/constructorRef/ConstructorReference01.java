package lamda.constructorRef;

import java.util.function.Supplier;

class Person {
	public Person() {
		System.out.println("새로운 Person 객체 생성!");
	}
	public int test() {
		return 6;
	}
	
}

public class ConstructorReference01 {
	public static void main(String[] args) {
		Person p = new Person();
		// 기존방식
		Supplier<Person> beforePerson = new Supplier<Person>() {
			@Override
			public Person get() {
				return new Person();
			}
		};
		
		// 1. 람다식으로 변경해보자
		Supplier<Person> lambdaPerson = () -> new Person();
		// 2. 생성자참조로 변경해보자
		Supplier<Person> methodPerson = Person::new;
		Supplier<Integer> methodPerson2 = p::test;
		// 3.호출해보자
		Person person = beforePerson.get();
		Person person2 = lambdaPerson.get();
		Person person3 = methodPerson.get();
		Integer integer = methodPerson2.get();
		System.out.println(person);
		System.out.println(person2);
		System.out.println(person3);
		System.out.println(integer);
		
	}
}
