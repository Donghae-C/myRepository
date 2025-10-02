package ex0806.homework.child;

public class ChildExample {

	public static void main(String[] args) {
		/*
		 * Child child = new Child();
		 * 
		 * Parent parent = child;
		 */
		
		Parent parent = new Child();
		
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		//parent.method3();
		
		//parent.field2 = "data2" //불가능
		//parent.method3(); //불가능
		
		Child child = (Child)parent;
		child.field2 = "data2";
		child.method3();
	}

}
